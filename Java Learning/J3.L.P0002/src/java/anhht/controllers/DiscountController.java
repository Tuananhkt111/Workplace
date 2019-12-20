/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controllers;

import anhht.discount.DiscountDAO;
import anhht.discount.DiscountDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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
public class DiscountController extends HttpServlet {
private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "cart.jsp";
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
            HttpSession session = request.getSession();
            String userID = (String) session.getAttribute("USER");
            String code = request.getParameter("txtCode");
            DiscountDAO dDAO = new DiscountDAO();
            DiscountDTO dDTO = dDAO.loadCode(code, userID);
            if(dDTO == null) {
                msg = "Invalid code";
            } else if(dDTO.getStatus().equals("Invalid")){
                    msg = "Code has been used";
            } else {
                Date curDate = new Date();
                if(curDate.compareTo(dDTO.getDateBegin()) >= 0 && curDate.compareTo(dDTO.getDateEnd()) <= 0) {
                    msg = "Apply code success";
                    request.setAttribute("SALE", dDTO.getSalePercent());
                } else {
                    msg = "Code is expired";
                }
            }
            request.setAttribute("MSG", msg);
            url = SUCCESS;
        } catch (SQLException | NamingException e) {
            log("ERROR at DiscountController: " + e.getMessage());
            msg = "ERROR at DiscountController";
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
