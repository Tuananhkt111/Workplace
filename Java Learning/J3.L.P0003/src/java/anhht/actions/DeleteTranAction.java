/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.transactions.TransactionsDAO;
import java.sql.SQLException;
import javax.naming.NamingException;
import org.apache.log4j.Logger;
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
    @Result(name = "error", location = "error.jsp")
    ,
    @Result(name = "success", location = "BookingHistoryAction", type = "chain")
    ,
    @Result(name = "failed", location = "BookingHistoryAction", type = "chain")})
public class DeleteTranAction {
    private static final Logger LOGGER = Logger.getLogger(DeleteTranAction.class);
    private String txtTranID;
    private String msg;
    public DeleteTranAction() {
    }
    @Action("DeleteTranAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            TransactionsDAO tDAO = new TransactionsDAO();
            if(tDAO.deleteTran(txtTranID)) {
                msg = "Delete transaction success";
            } else {
                msg = "Delete transaction failed";
            }
            url = "success";
        } catch (SQLException | NamingException e) {
            LOGGER.error("ERROR at DeleteTranAction: " + e.getMessage());
            msg = "ERROR at DeleteTranAction";
        }
        return url;
    }

    public String getTxtTranID() {
        return txtTranID;
    }

    public void setTxtTranID(String txtTranID) {
        this.txtTranID = txtTranID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
