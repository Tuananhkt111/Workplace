/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controller;

import anhht.utils.XMLUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author tuana
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String xmlFile = "/WEB-INF/studentAccounts.xml";
    private static final String ERROR = "error.jsp";
    private static final String SEARCH = "search.jsp";
    private String fullname;
    private boolean found;

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
            String realPath = getServletContext().getRealPath("/");
            String filePath = realPath + xmlFile;
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            Document doc = XMLUtils.parseFileToDOM(filePath);
            fullname = "";
            found = false;
            //checkLogin
            checkLogin(doc, username, password);
            if (found) {
                url = SEARCH;
                HttpSession session = request.getSession();
                session.setAttribute("USER", username);
                session.setAttribute("PASS", password);
                session.setAttribute("FULLNAME", fullname);
            } else {
                request.setAttribute("ERROR", "Invalid Username or Password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private void checkLogin(Node node, String username, String password) {
        if (node == null || found) {
            return;
        }
        if (node.getNodeName().equals("student")) {
            String id = node.getAttributes().getNamedItem("id").getNodeValue();
            if (id.equals(username)) {
                NodeList childrenOfStudent = node.getChildNodes();
                for (int i = 0; i < childrenOfStudent.getLength(); i++) {
                    Node tmp = childrenOfStudent.item(i);
                    if (tmp.getNodeName().equals("lastname")) {
                        fullname = tmp.getTextContent().trim();
                    } else if (tmp.getNodeName().equals("middlename")) {
                        fullname += " " + tmp.getTextContent().trim();
                    } else if (tmp.getNodeName().equals("firstname")) {
                        fullname += " " + tmp.getTextContent().trim();
                    } else if (tmp.getNodeName().equals("password")) {
                        String pass = tmp.getTextContent().trim();
                        if (!pass.equals(password)) {
                            break;
                        }
                    } else if (tmp.getNodeName().equals("status")) {
                        String status = tmp.getTextContent().trim();
                        if (!status.equals("dropout")) {
                            found = true;
                            return;
                        }
                    }
                }
            }
        }
        //
        NodeList children = node.getChildNodes();
        int count = 0;
        while (count < children.getLength()) {
            checkLogin(children.item(count++), username, password);
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
