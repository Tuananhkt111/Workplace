/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controllers;

import anhht.dao.RegistrationDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuana
 */
public class LoginController extends HttpServlet {

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
        String url = "ErrorServlet";
        try {
            //1.Nhan request tu client hoac controller khac
            //request.getParameter() lay du lieu o 3 vi tri:
            //- thanh dia chi URL, hyperlink
            //- lay o tren form khi nguoi dung submit
            //- the param
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPass");
            System.out.println(username);
            System.out.println(password);
            //2.Goi model
            RegistrationDAO regDAO = new RegistrationDAO();
            String role = regDAO.checkLogin(username, password);
            System.out.println(role);
            //3. Dieu huong ve trang tuong ung
            if(role.equals("failed")) {
                //Invalid username or password
                
            } else {
                if(role.equals("admin")) {
                    url = "AdminServlet";
                } else if(role.equals("user")) {
                    url = "UserServlet";
                } else {
                    //Your role is not existed.
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect(url);
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
