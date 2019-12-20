/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.bookingcart.BookingCart;
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
    @Result(name = "error", location = "error.jsp")
    ,
    @Result(name = "success", location = "cart.jsp")
    ,
    @Result(name = "failed", location = "cart.jsp")})
public class UpdateCartAction {

    private static final Logger LOGGER = Logger.getLogger(UpdateCartAction.class);
    private String txtRoomTypeID;
    private int txtQuantity;
    private String msg;

    public UpdateCartAction() {
    }

    @Action("UpdateCartAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            HttpServletRequest req = ServletActionContext.getRequest();
            HttpSession session = req.getSession();
            BookingCart cart = (BookingCart) session.getAttribute("CART");
            if (cart.updateCart(txtRoomTypeID, txtQuantity)) {
                session.setAttribute("CART", cart);
                msg = "Update rooms in cart success";
                url = "success";
            } else {
                msg = "Not enough rooms";
                url = "failed";
            }
        } catch (Exception e) {
            LOGGER.error("ERROR at UpdateCartAction: " + e.getMessage());
            msg = "ERROR at UpdateCartAction";
        }
        return url;
    }

    public String getTxtRoomTypeID() {
        return txtRoomTypeID;
    }

    public void setTxtRoomTypeID(String txtRoomTypeID) {
        this.txtRoomTypeID = txtRoomTypeID;
    }

    public int getTxtQuantity() {
        return txtQuantity;
    }

    public void setTxtQuantity(int txtQuantity) {
        this.txtQuantity = txtQuantity;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
