/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.controllers;

import dungth.dtos.BookDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hoang Dung
 */
public class AddController extends HttpServlet {

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
        try {
            String bookINFO = request.getParameter("listBook");
            HttpSession session = request.getSession();
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
            if (shoppingCart == null) {
                shoppingCart = new ShoppingCart("DungTH");
            }
            //id-name-price
            String[] tmp = bookINFO.split("-");
            String id = tmp[0];
            String name = tmp[1];
            float price = Float.parseFloat(tmp[2]);
            BookDTO dto = new BookDTO();
            dto.setId(id);
            dto.setName(name);
            dto.setPrice(price);
            dto.setQuantity(1);
            //  ShoppingCart shoppingCart = new ShoppingCart("DungTH");
            shoppingCart.addCart(dto);
            session.setAttribute("cart", shoppingCart);
        } catch (Exception e) {
            log("ERROR at AddToCartController: " + e.getMessage());
        } finally {
            //request.getRequestDispatcher("index.jsp").forward(request, response);
            response.sendRedirect("index.jsp");
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
