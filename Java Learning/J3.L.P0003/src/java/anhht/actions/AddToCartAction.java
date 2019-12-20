/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.bookingcart.BookingCart;
import anhht.bookingcart.BookingDetails;
import anhht.roomtype.RoomTypeDAO;
import anhht.roomtype.RoomTypeDTO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
    @Result(name = "error", location = "error.jsp")
    ,
    @Result(name = "success", location = "SearchRoomAction", type = "chain")
    ,
    @Result(name = "failed", location = "SearchRoomAction", type = "chain")})
public class AddToCartAction {

    private static final Logger LOGGER = Logger.getLogger(AddToCartAction.class);
    private String txtHotelID, txtHotelName, txtCheckinDate, txtCheckoutDate;
    private int txtQuantity;
    private String txtRoomTypeID;
    private String msg;

    public AddToCartAction() {
    }

    @Action("AddToCartAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate = format.parse(txtCheckinDate);
            Date endDate = format.parse(txtCheckoutDate);
            RoomTypeDAO rtDAO = new RoomTypeDAO();
            RoomTypeDTO rtDTO = rtDAO.loadRoomTypeByID(txtRoomTypeID, beginDate, endDate, txtQuantity);
            if (rtDTO != null) {
                BookingDetails bd = new BookingDetails(txtHotelName, rtDTO.getRoomType(), txtRoomTypeID, txtQuantity, rtDTO.getAvailableRoom(), beginDate, endDate, rtDTO.getPrice());
                HttpServletRequest req = ServletActionContext.getRequest();
                HttpSession session = req.getSession();
                BookingCart cart = (BookingCart) session.getAttribute("CART");
                if(cart == null) {
                    cart = new BookingCart();
                }
                if(cart.addCart(bd)) {
                    session.setAttribute("CART", cart);
                    msg = "Add rooms to cart success";
                    url = "success";
                } else {
                    msg = "Not enough available rooms";
                    url = "failed";
                }
            } else {
                msg = "Not enough available rooms";
                url = "failed";
            }
        } catch (SQLException | NamingException e) {
            LOGGER.error("ERROR at AddToCartAction: " + e.getMessage());
            msg = "ERROR at AddToCartAction";
        }
        return url;
    }

    public String getTxtHotelID() {
        return txtHotelID;
    }

    public void setTxtHotelID(String txtHotelID) {
        this.txtHotelID = txtHotelID;
    }

    public String getTxtHotelName() {
        return txtHotelName;
    }

    public void setTxtHotelName(String txtHotelName) {
        this.txtHotelName = txtHotelName;
    }

    public String getTxtCheckinDate() {
        return txtCheckinDate;
    }

    public void setTxtCheckinDate(String txtCheckinDate) {
        this.txtCheckinDate = txtCheckinDate;
    }

    public String getTxtCheckoutDate() {
        return txtCheckoutDate;
    }

    public void setTxtCheckoutDate(String txtCheckoutDate) {
        this.txtCheckoutDate = txtCheckoutDate;
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

    public String getTxtRoomTypeID() {
        return txtRoomTypeID;
    }

    public void setTxtRoomTypeID(String txtRoomTypeID) {
        this.txtRoomTypeID = txtRoomTypeID;
    }

}
