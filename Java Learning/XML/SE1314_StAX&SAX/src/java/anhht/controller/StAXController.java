/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controller;

import anhht.sax.StudentHandler;
import anhht.utils.XMLUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author tuana
 */
public class StAXController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "success.jsp";
    private static final String xmlFile = "/WEB-INF/studentAccounts.xml";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String pass = request.getParameter("txtPass");
            String realPath = getServletContext().getRealPath("/");
            String filePath = realPath + xmlFile;
            String fullname = "";
            boolean found = false;
            XMLStreamReader reader = XMLUtils.createStAXCursorReaderFormFile(filePath);
            while (reader.hasNext()) {
                int cursor = reader.next();
                if (cursor == XMLStreamConstants.START_ELEMENT) {
                    String tagName = reader.getLocalName();
                    if (tagName.equals("student")) {
                        String id = reader.getAttributeValue("", "id");
                        if (id.equals(username)) {
                            fullname = XMLUtils.getTextContent(reader, "lastname").trim();
                            fullname += " " + XMLUtils.getTextContent(reader, "middlename").trim();
                            fullname += " " + XMLUtils.getTextContent(reader, "firstname").trim();
                            String password = XMLUtils.getTextContent(reader, "password").trim();
                            if(password.equals(pass)) {
                                String status = XMLUtils.getTextContent(reader, "status");
                                if(!status.equals("dropout")) {
                                    found = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (found) {
                url = SUCCESS;
                HttpSession session = request.getSession();
                session.setAttribute("FULLNAME", fullname);
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
