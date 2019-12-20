/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controller;

import anhht.account.AccountDAO;
import anhht.account.AccountDTO;
import anhht.utils.MyUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author tuana
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class InsertController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchController";
    private static final String FAILED = "insert.jsp";
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
            String msg = "";
            HttpSession session = request.getSession();
            String roleSession = (String) (session.getAttribute("ROLE") != null ? session.getAttribute("ROLE") : "");
            if (roleSession.equals("admin")) {
                String role = request.getParameter("txtRole");
                if (role.equals("admin")) {
                    msg = "Cannot insert user with role admin";
                    url = FAILED;
                } else {
                    String userID = request.getParameter("txtUserID");
                    String username = request.getParameter("txtUsername");
                    String password = request.getParameter("txtPassword");
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    byte[] encodedhash = digest.digest(
                            password.getBytes(StandardCharsets.UTF_8));
                    String passwordHash = MyUtils.bytesToHex(encodedhash);
                    String email = request.getParameter("txtEmail");
                    String phone = request.getParameter("txtPhone");
                    AccountDTO dto = new AccountDTO(userID, username, passwordHash, email, phone, role);
                    for (Part part : request.getParts()) {
                        String fileName = MyUtils.extractFileName(part);
                        if (fileName != null && fileName.length() > 0) {
                            InputStream is = part.getInputStream();
                            AccountDAO dao = new AccountDAO();
                            if (dao.insert(dto, is)) {
                                msg = "Insert account success";
                                url = SUCCESS;
                            } else {
                                msg = "Insert account fail";
                                url = FAILED;
                            }
                        }
                    }
                }
            } else if (!roleSession.equals("")) {
                msg = "You are not authorized";
                url = USER;
            } else {
                msg = "You need to login";
                url = LOGIN;
            }
            request.setAttribute("MSG", msg);
        } catch (IOException | NoSuchAlgorithmException | SQLException | NamingException | ServletException e) {
            if (e.getMessage().contains("duplicate")) {
                request.setAttribute("MSG", "UserID existed");
                url = FAILED;
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
