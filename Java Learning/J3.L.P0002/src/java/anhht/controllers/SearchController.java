/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controllers;

import anhht.book.BookDAO;
import anhht.book.BookDTO;
import anhht.category.CategoryDAO;
import anhht.category.CategoryDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuana
 */
public class SearchController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "search.jsp";

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
        String msg;
        try {
            BookDAO dao = new BookDAO();
            CategoryDAO catDAO = new CategoryDAO();
            String txtSearch = request.getParameter("txtSearch");
            ArrayList<BookDTO> list;
            if (txtSearch == null) {
                list = dao.searchBookByName("");
            } else if (txtSearch.equals("Name")) {
                String name = request.getParameter("txtName");
                list = dao.searchBookByName(name);
            } else if (txtSearch.equals("Price")) {
                String minText = request.getParameter("min");
                String maxText = request.getParameter("max");
                float min, max;
                if(minText != null && !minText.equals("")) {
                    min = Float.parseFloat(minText);
                } else {
                    min = 0;
                }
                if(maxText != null && !maxText.equals("")) {
                    max = Float.parseFloat(maxText);
                } else {
                    max = 0;
                }
                list = dao.searchBookByPrice(min, max);
            } else {
                String catID = request.getParameter("cbCat");
                list = dao.searchBookByCategory(catID);
            }
            ArrayList<CategoryDTO> bookList = catDAO.loadCategory();
            request.setAttribute("BOOKLIST", list);
            request.setAttribute("CATLIST", bookList);
            url = SUCCESS;
        } catch (SQLException | NamingException e) {
            log("ERROR at SearchController: " + e.getMessage());
            msg = "ERROR at SearchController";
            request.setAttribute("ERROR", msg);
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
