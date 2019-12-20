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
public class DeleteCartAction {

    private static final Logger LOGGER = Logger.getLogger(DeleteCartAction.class);
    private String roomTypeID;
    private String msg;
    public DeleteCartAction() {
    }

    @Action("DeleteCartAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            HttpServletRequest req = ServletActionContext.getRequest();
            HttpSession session = req.getSession();
            BookingCart cart = (BookingCart) session.getAttribute("CART");
            if (cart.removeCart(roomTypeID)) {
                session.setAttribute("CART", cart);
                msg = "Delete rooms from cart success";
                url = "success";
            } else {
                msg = "Delete rooms from cart failed";
                url = "failed";
            }
        } catch (Exception e) {
            LOGGER.error("ERROR at DeleteCartAction: " + e.getMessage());
            msg = "ERROR at DeleteCartAction";
        }
        return url;
    }

    public String getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(String roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
