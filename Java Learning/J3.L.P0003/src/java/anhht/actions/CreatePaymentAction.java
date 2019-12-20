/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.bookingcart.BookingCart;
import anhht.bookingcart.BookingDetails;
import anhht.discount.DiscountDAO;
import anhht.paypal.PaypalServices;
import anhht.roomtype.RoomTypeDAO;
import anhht.transactions.TransactionsDTO;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Result(name = "failed", location = "CartPageAction")
    ,
    @Result(name = "error", location = "error.jsp")
})
public class CreatePaymentAction {

    private static final Logger LOGGER = Logger.getLogger(CreatePaymentAction.class);
    private static final String FAILED = "failed";
    private static final String ERROR = "error";
    private String txtCode;
    private float txtTotalCost;
    private String msg;
    private TransactionsDTO orderDTO;

    public CreatePaymentAction() {
    }

    @Action("CreatePaymentAction")
    public String execute() throws Exception {
        String url = ERROR;
        try {
            String msgDetails = "";
            // Get cart
            HttpServletRequest req = ServletActionContext.getRequest();
            HttpSession session = req.getSession();
            BookingCart cart = (BookingCart) session.getAttribute("CART");

            RoomTypeDAO rtDAO = new RoomTypeDAO();
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
                String tranID = "TRAN" + UUID.randomUUID().toString();
                DiscountDAO dDAO = new DiscountDAO();
                int sale = dDAO.loadSalePercentByCode(txtCode);
                Date dateBooked = new Date();
                orderDTO = new TransactionsDTO(tranID, email, txtCode, txtTotalCost, sale, dateBooked);
                Collection<BookingDetails> values = cart.getCart().values(); 
                orderDTO.setList(new ArrayList<>(values));
                session.setAttribute("ORDER_PAYMENT", orderDTO);

                PaypalServices paypalServices = new PaypalServices();
                String approvalLink = paypalServices.createPayment(orderDTO);
                session.setAttribute("DTO", orderDTO);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.sendRedirect(approvalLink);
            } else {
                msg = "Checkout failed";
                req.setAttribute("MSGDETAILS", msgDetails);
                url = FAILED;
            }
        } catch (PayPalRESTException | IOException | SQLException | NamingException e) {
            LOGGER.error("ERROR at CreatePaymentAction: " + e.getMessage());
            msg = "ERROR at CreatePaymentAction";
        }
        return url;
    }

    public String getTxtCode() {
        return txtCode;
    }

    public void setTxtCode(String txtCode) {
        this.txtCode = txtCode;
    }

    public float getTxtTotalCost() {
        return txtTotalCost;
    }

    public void setTxtTotalCost(float txtTotalCost) {
        this.txtTotalCost = txtTotalCost;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public TransactionsDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(TransactionsDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

}
