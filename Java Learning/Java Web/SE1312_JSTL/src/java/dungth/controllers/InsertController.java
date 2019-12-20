/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.controllers;

import dungth.dtos.RegistrationDTO;
import dungth.dtos.RegistrationErrorObject;
import dungth.models.ProcessBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuana
 */
public class InsertController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "index.jsp";
    private static final String INVALID = "insert.jsp";
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
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String fullname = request.getParameter("txtFullname");
            String role = request.getParameter("txtRole");
            RegistrationErrorObject errorObj = new RegistrationErrorObject();
            boolean valid = true;
            if(username.length() == 0) {
                errorObj.setUsernameError("Username cannot be blank.");
                valid = false;
            }
            if(password.length() == 0) {
                errorObj.setPasswordError("Password cannot be blank.");
                valid = false;
            }
            if(!confirm.equals(password)) {
                errorObj.setConfirmError("Confirm must match Password.");
                valid = false;
            }
            if(fullname.length() == 0) {
                errorObj.setUsernameError("Fullname cannot be blank.");
                valid = false;
            }
            if(valid) {
                RegistrationDTO dto = new RegistrationDTO(username, password, fullname, role);
                ProcessBean beans = new ProcessBean();
                beans.setDto(dto);
                if(beans.insert()) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Insert failed");
                }
            } else {
                request.setAttribute("INVALID", errorObj);
                url = INVALID;
            }
        } catch (Exception e) {
            log("ERROR at InsertController: " + e.getMessage());
            if(e.getMessage().contains("duplicate")) {
                RegistrationErrorObject errorObj = new RegistrationErrorObject();
                errorObj.setUsernameError("Username existed.");
                request.setAttribute("INVALID", errorObj);
                url = INVALID;
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
