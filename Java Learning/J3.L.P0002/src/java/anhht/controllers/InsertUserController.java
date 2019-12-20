/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controllers;

import anhht.account.AccountDAO;
import anhht.account.AccountDTO;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuana
 */
public class InsertUserController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchController";
    private static final String FAILED = "InsertUserPageController";

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
        String msg;
        String url = ERROR;
        try {
            AccountDAO dao = new AccountDAO();
            String userID = request.getParameter("txtUserID");
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtPhone");
            String address = request.getParameter("txtAddress");
            String roleID = request.getParameter("cbRole");
            AccountDTO dto = new AccountDTO(userID, username, roleID, password, email, phone, address);
            if (dao.insert(dto)) {
                msg = "Insert account success";
                url = SUCCESS;
            } else {
                msg = "Insert account fail";
                url = FAILED;
            }
            request.setAttribute("MSG", msg);
        } catch (SQLException | NamingException e) {
            if (e.getMessage().contains("duplicate")) {
                request.setAttribute("MSG", "UserID existed");
                url = FAILED;
            } else {
                log("ERROR at InsertUserController: " + e.getMessage());
                msg = "ERROR at InsertUserController";
                request.setAttribute("ERROR", msg);
            }
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
