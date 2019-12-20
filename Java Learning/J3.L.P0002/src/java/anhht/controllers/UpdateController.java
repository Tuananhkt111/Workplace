/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controllers;

import anhht.book.BookDAO;
import anhht.book.BookDTO;
import anhht.utils.MyUtils;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author tuana
 */
@WebServlet("/Update")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UpdateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String FAILED = "EditController";
    private static final String SUCCESS = "SearchController";
    public static final String SAVE_DIRECTORY = "bookImage";

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
            String bookID = request.getParameter("txtBookID");
            String title = request.getParameter("txtTitle");
            String author = request.getParameter("txtAuthor");
            String catID = request.getParameter("cbCat");
            String des = request.getParameter("txtDes");
            float price = Float.parseFloat(request.getParameter("txtPrice"));
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            Date importDate = new Date();
            String status = "Active";
            String appPath = request.getServletContext().getRealPath("/");
            String fullSavePath;
            if (appPath.endsWith("\\")) {
                fullSavePath = appPath + SAVE_DIRECTORY;
            } else {
                fullSavePath = appPath + "\\" + SAVE_DIRECTORY;
            }
            File fileSaveDir = new File(fullSavePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
            String image = "";
            for (Part part : request.getParts()) {
                String fileName = MyUtils.extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    String extension = fileName.substring(fileName.lastIndexOf("."));
                    String filePath = fullSavePath + "\\" + bookID + extension;
                    image = bookID + extension;
                    part.write(filePath);
                }
            }
            BookDTO dto = new BookDTO(bookID, title, catID, author, des, image, status, price, quantity, importDate);
            BookDAO dao = new BookDAO();
            if (dao.update(dto)) {
                msg = "Update success";
                url = SUCCESS;
            } else {
                msg = "Update failed";
                url = FAILED;
            }
            request.setAttribute("MSG", msg);
        } catch (SQLException | NamingException e) {
            log("ERROR at UpdateController: " + e.getMessage());
            msg = "ERROR at UpdateController";
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
