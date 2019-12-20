/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.controllers;

import anhht.transactiondetails.TransactionDetailsDAO;
import anhht.transactiondetails.TransactionDetailsDTO;
import anhht.transactions.TransactionDTO;
import anhht.transactions.TransactionsDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ShoppingHistoryController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "history.jsp";

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
            HttpSession session = request.getSession();
            String userID = (String) session.getAttribute("USER");
            TransactionDetailsDAO dao = new TransactionDetailsDAO();
            TransactionsDAO tranDAO = new TransactionsDAO();
            String txtSearch = request.getParameter("txtSearch");
            ArrayList<TransactionDTO> tranList;
            if (txtSearch == null) {
                tranList = tranDAO.loadTransByUserID(userID);
            } else if (txtSearch.equals("Name")) {
                String name = request.getParameter("txtName");
                tranList = tranDAO.loadTransByUserIDAndName(userID, name);
            } else {
                String dateText = request.getParameter("txtDate");
                if (!dateText.equals("")) {
                    Date dateBought = new SimpleDateFormat("yyyy-MM-dd").parse(dateText);
                    tranList = tranDAO.loadTransByUserIDAndDate(userID, dateBought);
                } else {
                    tranList = tranDAO.loadTransByUserID(userID);
                }
            }
            for (TransactionDTO transactionDTO : tranList) {
                ArrayList<TransactionDetailsDTO> list = dao.loadTransDetailsByTranID(transactionDTO.getTranID());
                transactionDTO.setList(list);
            }
            request.setAttribute("TRANLIST", tranList);
            url = SUCCESS;
        } catch (NumberFormatException | SQLException | NamingException | ParseException e) {
            log("ERROR at ShoppingHistoryController: " + e.getMessage());
            msg = "ERROR at ShoppingHistoryController";
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
