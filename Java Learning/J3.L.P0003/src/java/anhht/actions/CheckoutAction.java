/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.bookingcart.BookingCart;
import anhht.bookingcart.BookingDetails;
import anhht.room.RoomDAO;
import anhht.room.RoomDTO;
import anhht.roomtype.RoomTypeDAO;
import anhht.transactions.TransactionsDAO;
import java.sql.SQLException;
import java.util.ArrayList;
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
    @Result(name = "error", location = "error.jsp")
    ,
    @Result(name = "success", location = "SearchAction", type = "chain")
    ,
    @Result(name = "failed", location = "cart.jsp")})
public class CheckoutAction {

    private static final Logger LOGGER = Logger.getLogger(CheckoutAction.class);
    private float txtTotalCost;
    private String txtCode;
    private String msg;

    public CheckoutAction() {
    }

    @Action("CheckoutAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            String msgDetails = "";
            HttpServletRequest req = ServletActionContext.getRequest();
            HttpSession session = req.getSession();
            BookingCart cart = (BookingCart) session.getAttribute("CART");
            RoomDAO rDAO = new RoomDAO();
            RoomTypeDAO rtDAO = new RoomTypeDAO();
            TransactionsDAO tDAO = new TransactionsDAO();
            for (BookingDetails bd : cart.getCart().values()) {
                int quantity = rtDAO.loadAvailableRoomByRoomTypeID(bd.getRoomTypeID(), bd.getDateCheckin(), bd.getDateCheckout());
                if (quantity <= 0) {
                    msgDetails += bd.getHotelName() + "-" + bd.getRoomType() + ":\n Out of stock\n\n";
                } else if (quantity < bd.getQuantity()) {
                    msgDetails += bd.getHotelName() + "-" + bd.getRoomType() + ":\n Available: " + quantity + "  Your amount: " + bd.getQuantity() + "\n\n";
                }
            }
            if (msgDetails.equals("")) {
                String email = (String) session.getAttribute("USER");
                ArrayList<RoomDTO> roomList = new ArrayList<>();
                for (BookingDetails bd : cart.getCart().values()) {
                    roomList.addAll(rDAO.loadRoomByRoomTypeID(bd.getRoomTypeID(), bd.getDateCheckin(), bd.getDateCheckout(), bd.getQuantity()));
                }
                if (txtCode == null || txtCode.equals("")) {
                    if (tDAO.checkout(cart, email, txtTotalCost, roomList)) {
                        session.removeAttribute("CART");
                        msg = "Checkout success";
                        url = "success";
                    } else {
                        msg = "ERROR at CheckoutAction";
                    }
                } else {
                    if (tDAO.checkout(cart, email, txtTotalCost, txtCode, roomList)) {
                        session.removeAttribute("CART");
                        msg = "Checkout success";
                        url = "success";
                    } else {
                        msg = "ERROR at CheckoutAction";
                    }
                }
            } else {
                msg = "Checkout failed";
                req.setAttribute("MSGDETAILS", msgDetails);
                url = "failed";
            }
        } catch (SQLException | NamingException e) {
            LOGGER.error("ERROR at CheckoutAction: " + e.getMessage());
            msg = "ERROR at CheckoutAction";
        }
        return url;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public float getTxtTotalCost() {
        return txtTotalCost;
    }

    public void setTxtTotalCost(float txtTotalCost) {
        this.txtTotalCost = txtTotalCost;
    }

    public String getTxtCode() {
        return txtCode;
    }

    public void setTxtCode(String txtCode) {
        this.txtCode = txtCode;
    }

}
