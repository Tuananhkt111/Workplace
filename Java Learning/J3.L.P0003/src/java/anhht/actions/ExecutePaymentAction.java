/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.bookingcart.BookingCart;
import anhht.bookingcart.BookingDetails;
import anhht.paypal.PaypalServices;
import anhht.room.RoomDAO;
import anhht.room.RoomDTO;
import anhht.transactions.TransactionsDAO;
import anhht.transactions.TransactionsDTO;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.HashMap;
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
    @Result(name = "success", location = "SearchAction", type = "chain")
    ,
    @Result(name = "error", location = "error.jsp")
})
public class ExecutePaymentAction {
    private static final Logger LOGGER = Logger.getLogger(ExecutePaymentAction.class);
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    private String paymentId;
    private String PayerID;
    private TransactionsDTO orderDTO;
    private String msg;
    
    public ExecutePaymentAction() {
    }
    @Action("ExecutePaymentAction")
    public String execute() throws Exception {
        String url = ERROR;
        try {
            HttpServletRequest req = ServletActionContext.getRequest();
            HttpSession session = req.getSession();
            orderDTO = (TransactionsDTO) session.getAttribute("DTO");
            TransactionsDAO dao = new TransactionsDAO();
            PaypalServices paypalServices = new PaypalServices();
            Payment payment = paypalServices.executePayment(paymentId, PayerID);
            if (payment != null) {
                RoomDAO rDAO = new RoomDAO();
                ArrayList<RoomDTO> roomList = new ArrayList<>();
                for (BookingDetails bd : orderDTO.getList()) {
                    roomList.addAll(rDAO.loadRoomByRoomTypeID(bd.getRoomTypeID(), bd.getDateCheckin(), bd.getDateCheckout(), bd.getQuantity()));
                }
                BookingCart cart = new BookingCart();
                HashMap<String, BookingDetails> list = new HashMap<>();
                for (BookingDetails bds : orderDTO.getList()) {
                    list.put(bds.getRoomTypeID(), bds);
                }
                cart.setCart(list);
                if (orderDTO.getDiscountCode() == null || orderDTO.getDiscountCode().equals("")) {
                    if (dao.checkout(cart, orderDTO.getEmail(), orderDTO.getTotalPrice(), roomList)) {
                        session.removeAttribute("CART");
                        msg = "Checkout success";
                        url = SUCCESS;
                    } else {
                        msg = "ERROR at CheckoutAction";
                    }
                } else {
                    if (dao.checkout(cart, orderDTO.getEmail(), orderDTO.getTotalPrice(), orderDTO.getDiscountCode(), roomList)) {
                        session.removeAttribute("CART");
                        msg = "Checkout success";
                        url = SUCCESS;
                    } else {
                        msg = "ERROR at CheckoutAction";
                    }
                }
            }
        } catch (PayPalRESTException e) {
            LOGGER.error("ERROR at ExecutePaymentAction: " + e.getMessage());
            msg = "ERROR at ExecutePaymentAction";
        }
        return url;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPayerID() {
        return PayerID;
    }

    public void setPayerID(String PayerID) {
        this.PayerID = PayerID;
    }

    public TransactionsDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(TransactionsDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuana
 */


