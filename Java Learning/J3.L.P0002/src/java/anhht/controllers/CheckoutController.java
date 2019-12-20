/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controllers;

import anhht.book.BookDAO;
import anhht.shoppingcart.ShoppingCart;
import anhht.transactiondetails.TransactionDetailsDTO;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tuana
 */
public class CheckoutController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String FAILED = "cart.jsp";
    private static final String SUCCESS = "SearchController";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String msg;
        try {
            String msgResult = "";
            BookDAO bDAO = new BookDAO();
            HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart) session.getAttribute("CART");
            for (TransactionDetailsDTO tdDTO : cart.getCart().values()) {
                int quantity = bDAO.searchQuantityByBookID(tdDTO.getBookID());
                if (quantity <= 0) {
                    msgResult += "<h5>" + tdDTO.getBookID() + "-" + tdDTO.getTitle() + "</h5> is out of stock<br><br>";
                } else if (quantity < tdDTO.getQuantity()) {
                    msgResult += "<h5>" + tdDTO.getBookID() + "-" + tdDTO.getTitle() + ":</h5> <strong>Available</strong>: " + quantity + " <strong>Your amount</strong>: " + tdDTO.getQuantity() + "<br><br>";
                }
            }
            if (msgResult.equals("")) {
                String userID = (String) session.getAttribute("USER");
                float total = Float.parseFloat(request.getParameter("txtTotalCost"));
                String saleText = request.getParameter("txtSale");
                if (saleText == null || saleText.equals("")) {
                    if (bDAO.checkout(cart, userID, total)) {
                        session.removeAttribute("CART");
                        msg = "Checkout success";
                        url = SUCCESS;
                    } else {
                        msg = "ERROR at Checkout";
                    }
                } else {
                    int salePercent = Integer.parseInt(saleText);
                    String code = request.getParameter("txtCode");
                    if (bDAO.checkout(cart, userID, total, salePercent, code)) {
                        session.removeAttribute("CART");
                        msg = "Checkout success";
                        url = SUCCESS;
                    } else {
                        msg = "ERROR at Checkout";
                    }
                }
            } else {
                msg = "Checkout failed";
                request.setAttribute("MSGDETAILS", msgResult);
                url = FAILED;
            }
            request.setAttribute("MSG", msg);
        } catch (NumberFormatException | SQLException | NamingException e) {
            log("ERROR at CheckoutController: " + e.getMessage());
            msg = "ERROR at CheckoutController";
            request.setAttribute("ERROR", msg);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
