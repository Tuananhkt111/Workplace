/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuana
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
       maxFileSize = 1024 * 1024 * 10, // 10MB
       maxRequestSize = 1024 * 1024 * 50) // 50MB
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LogInController";
    private static final String LOGOUT = "LogOutController";
    private static final String INSERT = "InsertController";
    private static final String SEARCH = "SearchController";
    private static final String DELETE = "DeleteController";
    private static final String ADDTOPROLIST = "AddToProListController";
    private static final String DELETEPROLIST = "DeleteProListController";
    private static final String UPDATEPROLIST = "UpdateProListController";
    private static final String SAVEPROLIST = "SaveProListController";
    private static final String UPDATE = "UpdateController";
    private static final String EDIT = "EditController";
    private static final String CHANGEPASS = "ChangePassController";

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
            String action = request.getParameter("action");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Logout")) {
                url = LOGOUT;
            } else if (action.equals("Insert")) {
                url = INSERT;
            } else if (action.equals("Search")) {
                url = SEARCH;
            } else if (action.equals("Delete")) {
                url = DELETE;
            } else if (action.equals("AddToProList")) {
                url = ADDTOPROLIST;
            } else if (action.equals("DeleteProList")) {
                url = DELETEPROLIST;
            } else if (action.equals("UpdateProList")) {
                url = UPDATEPROLIST;
            } else if (action.equals("SaveProList")) {
                url = SAVEPROLIST;
            } else if (action.equals("Update")) {
                url = UPDATE;
            } else if (action.equals("Edit")) {
                url = EDIT;
            } else if (action.equals("ChangePass")) {
                url = CHANGEPASS;
            } else {
                request.setAttribute("ERROR", "Action is not supported");
            }
        } catch (Exception e) {
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
