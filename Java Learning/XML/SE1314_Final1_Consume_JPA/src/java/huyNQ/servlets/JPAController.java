/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyNQ.servlets;

import huyNQ.clients.HuyNQ;
import huyNQ.dtos.Registration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nguyen Quang Huy
 */
@WebServlet(name = "JPAController", urlPatterns = {"/JPAController"})
public class JPAController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JPAController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JPAController at " + request.getContextPath() + "</h1>");
            
            HuyNQ client = new HuyNQ();
            String action = request.getParameter("action");
            if(action.equals("Create")){
                Registration dto = new Registration();
                dto.setUsername("Test1");
                dto.setPassowrd("abc");
                dto.setFullname("1234");
                dto.setRole("user");
                client.create_XML(dto);
            } else if(action.equals("Remove")){
                client.remove("Test");
            } else if (action.equals("Search")){
                String search = request.getParameter("txtSearch");
                List<Registration> result = client.findByLikeNameObject(List.class, search);
                for (Registration registration : result) {
                    out.println("Username: " + registration.getUsername() + "<br/>");
                    out.println("Fullname: " + registration.getFullname()+ "<br/>");
                    out.println("Role: " + registration.getRole()+ "<br/>");
                    out.println("---------------------------------");
                }
            }
            out.println("</body>");
            out.println("</html>");
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
