/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controller;

import anhht.account.AccountDAO;
import anhht.account.AccountDTO;
import anhht.prolistdetails.ProListDetailsDTO;
import anhht.promotionlist.PromotionListDAO;
import anhht.promotionlist.PromotionListDTO;
import anhht.utils.MyUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
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
public class LogInController extends HttpServlet {

    private static final String ERROR = "index.jsp";
    private static final String ADMIN = "SearchController";
    private static final String USER = "SearchController";

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
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    password.getBytes(StandardCharsets.UTF_8));
            String passwordHash = MyUtils.bytesToHex(encodedhash);
            AccountDAO dao = new AccountDAO();
            AccountDTO dto = dao.checkLogin(userID, passwordHash);
            if (dto != null) {
                HttpSession session = request.getSession();
                session.setAttribute("USER", userID);
                session.setAttribute("NAME", dto.getUsername());
                session.setAttribute("ROLE", dto.getRole());
                if (dto.getRole().equals("admin")) {
                    PromotionListDAO plDAO = new PromotionListDAO();
                    HashMap<String, ProListDetailsDTO> list = plDAO.loadProList();
                    PromotionListDTO plDTO = new PromotionListDTO();
                    list.values().forEach((pldDTO) -> {
                        plDTO.addProList(pldDTO);
                    });
                    session.setAttribute("PROLIST", plDTO);
                    url = ADMIN;
                } else {
                    url = USER;
                }
            } else {
                request.setAttribute("MSG", "Invalid Username or Password");
            }
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
