/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controllers;

import anhht.book.BookDAO;
import anhht.book.BookDTO;
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
public class AddCartController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String FAILED = "SearchController";
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
            BookDAO dao = new BookDAO();
            String bookID = request.getParameter("bookID");
            BookDTO dto = dao.searchBookByBookID(bookID);
            if (dto == null) {
                msg = "Load book info failed at AddCart";
            } else {
                TransactionDetailsDTO tdDTO = new TransactionDetailsDTO(bookID, dto.getTitle(), 1, dto.getQuantity(), dto.getPrice());
                HttpSession session = request.getSession();
                ShoppingCart cart = (ShoppingCart) session.getAttribute("CART");
                if (cart == null) {
                    cart = new ShoppingCart();
                }
                if (cart.addCart(tdDTO)) {
                    session.setAttribute("CART", cart);
                    msg = "Add book to cart success";
                    url = SUCCESS;
                } else {
                    msg = "Available book is not enough to buy";
                    url = FAILED;
                }
            }
            request.setAttribute("MSG", msg);
        } catch (SQLException | NamingException e) {
            log("ERROR at AddCartController: " + e.getMessage());
            msg = "ERROR at AddCartController";
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
