/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controller;

import anhht.account.AccountDAO;
import anhht.utils.MyUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class ChangePassController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchController";
    private static final String FAILED = "SearchController";
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
            String userID = (String) session.getAttribute("USER");
            if (!roleSession.equals("")) {
                String passwordOld = request.getParameter("txtPassOld");
                String passwordNew = request.getParameter("txtPassNew");
                AccountDAO dao = new AccountDAO();
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] encodedhashOld = digest.digest(
                        passwordOld.getBytes(StandardCharsets.UTF_8));
                String passwordHashOld = MyUtils.bytesToHex(encodedhashOld);
                byte[] encodedhashNew = digest.digest(
                        passwordNew.getBytes(StandardCharsets.UTF_8));
                String passwordHashNew = MyUtils.bytesToHex(encodedhashNew);
                if (dao.checkLogin(userID, passwordHashOld) != null) {
                    if (dao.update(passwordHashNew, userID)) {
                        msg = "Update user password success";
                        url = SUCCESS;
                    } else {
                        msg = "Update user password fail";
                        url = FAILED;
                    }
                } else {
                    msg = "Old password incorrect";
                    url = FAILED;
                }
            } else {
                msg = "You need to login";
                url = LOGIN;
            }
            request.setAttribute("MSG", msg);
        } catch (NoSuchAlgorithmException | SQLException | NamingException e) {
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
