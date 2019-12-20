/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controllers;

import anhht.dao.FoodDAO;
import anhht.dto.FoodDTO;
import anhht.dto.InsertErrorObject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuana
 */
public class UpdateController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchController";
    private static final String INVALID = "EditController";

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
            String id = request.getParameter("txtId");
            String name = request.getParameter("txtName");
            float price = Float.parseFloat(request.getParameter("txtPrice"));
            String description = request.getParameter("txtDes");
            String type = request.getParameter("txtType");
            String status = request.getParameter("txtStatus");
            boolean valid = true;
            InsertErrorObject errorObj = new InsertErrorObject();
            if(name.length() == 0) {
                errorObj.setNameError("Name cannot be blank");
                valid = false;
            }
            if(description.length() == 0) {
                errorObj.setDescriptionError("Description cannot be blank");
                valid = false;
            }
            if(type.length() == 0) {
                errorObj.setTypeError("Type cannot be blank");
                valid = false;
            }
            if(valid) {
                FoodDAO dao =new FoodDAO();
                FoodDTO dto = new FoodDTO(id, name, description, type, status, price);
                if(dao.update(dto)) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Update failed");
                }
            } else {
                request.setAttribute("INVALID", errorObj);
                url = INVALID;
            }
        } catch (Exception e) {
            log("ERROR at Updatecontroller: " + e.getMessage());
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
