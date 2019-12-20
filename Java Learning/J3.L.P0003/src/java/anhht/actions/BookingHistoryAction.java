/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.bookingcart.BookingDetails;
import anhht.transactiondetails.TransactionDetailsDAO;
import anhht.transactions.TransactionsDAO;
import anhht.transactions.TransactionsDTO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author tuana
 */
@ResultPath("/")
@Results({
    @Result(name = "success", location = "history.jsp")
    ,
    @Result(name = "error", location = "error.jsp")})
public class BookingHistoryAction {

    private static final Logger LOGGER = Logger.getLogger(BookingHistoryAction.class);
    private String txtDate;
    private String msg;
    private ArrayList<TransactionsDTO> tranList;

    public BookingHistoryAction() {
    }

    @Action("BookingHistoryAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("USER");
            TransactionDetailsDAO dao = new TransactionDetailsDAO();
            TransactionsDAO tranDAO = new TransactionsDAO();
            if (txtDate == null || txtDate.equals("")) {
                tranList = tranDAO.loadTransByEmail(email);
            } else {
                Date dateBooked = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
                tranList = tranDAO.loadTransByEmailAndDate(email, dateBooked);
            }
            for (TransactionsDTO transactionDTO : tranList) {
                ArrayList<BookingDetails> list = dao.loadBookingDetailsByTranID(transactionDTO.getTranID());
                transactionDTO.setList(list);
            }
            Collections.sort(tranList);
            Collections.reverse(tranList);
            url = "success";
        } catch (SQLException | NamingException e) {
            LOGGER.error("ERROR at BookingHistoryAction: " + e.getMessage());
            msg = "ERROR at BookingHistoryAction";
        }
        return url;
    }

    public String getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(String txtDate) {
        this.txtDate = txtDate;
    }

    public ArrayList<TransactionsDTO> getTranList() {
        return tranList;
    }

    public void setTranList(ArrayList<TransactionsDTO> tranList) {
        this.tranList = tranList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
