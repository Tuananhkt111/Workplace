/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.discount.DiscountDAO;
import anhht.discount.DiscountDTO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Result(name = "success", location = "cart.jsp")})
public class DiscountAction {

    private static final Logger LOGGER = Logger.getLogger(DiscountAction.class);
    private String txtCode;
    private int sale;
    private String msg;

    public DiscountAction() {
    }

    @Action("DiscountAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            DiscountDAO dDAO = new DiscountDAO();
            DiscountDTO dDTO = dDAO.loadCode(txtCode);
            if (dDTO == null) {
                msg = "Invalid code";
            } else if (!dDTO.getStatus().equals("Valid")) {
                msg = "Code has been used";
            } else {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date curDate = new Date();
                Date todayWithZeroTime = formatter.parse(formatter.format(curDate));
                Date dateBegin = formatter.parse(formatter.format(dDTO.getDateBegin()));
                Date dateEnd = formatter.parse(formatter.format(dDTO.getDateEnd()));
                if ((todayWithZeroTime.compareTo(dateBegin) >= 0) && (todayWithZeroTime.compareTo(dateEnd) <= 0)) {
                    sale = dDTO.getSalePercent();
                    msg = "Apply code success";
                } else {
                    msg = "Code is expired";
                }
            }
            url = "success";
        } catch (SQLException | NamingException e) {
            LOGGER.error("ERROR at CheckoutAction: " + e.getMessage());
            msg = "ERROR at CheckoutAction";
        }
        return url;
    }

    public String getTxtCode() {
        return txtCode;
    }

    public void setTxtCode(String txtCode) {
        this.txtCode = txtCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

}
