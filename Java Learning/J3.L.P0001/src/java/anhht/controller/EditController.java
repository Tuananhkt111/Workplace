/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controller;

import anhht.account.AccountDAO;
import anhht.account.AccountDTO;
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
public class EditController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String ADMIN = "update.jsp";
    private static final String USER = "user.jsp";
    private static final String LOGIN = "index.jsp";

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
            String msg;
            HttpSession session = request.getSession();
            String roleSession = (String) (session.getAttribute("ROLE") != null ? session.getAttribute("ROLE") : "");
            if (roleSession.equals("admin")) {
                String userID = request.getParameter("userID");
                AccountDAO dao = new AccountDAO();
                AccountDTO dto = dao.loadAccountByUserID(userID);
                if (dto != null) {
                    request.setAttribute("DTO", dto);
                    url = ADMIN;
                } else {
                    msg = "Load user details failed";
                    request.setAttribute("MSG", msg);
                    url = ERROR;
                }
            } else if (!roleSession.equals("")) {
                msg = "You are not authorized";
                request.setAttribute("MSG", msg);
                url = USER;
            } else {
                msg = "You need to login";
                request.setAttribute("MSG", msg);
                url = LOGIN;
            }
        } catch (IOException | SQLException | NamingException e) {
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
