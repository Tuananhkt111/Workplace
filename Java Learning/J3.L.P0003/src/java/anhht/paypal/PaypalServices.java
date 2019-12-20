/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.paypal;

/**
 *
 * @author tuana
 */
import anhht.bookingcart.BookingDetails;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import anhht.transactions.TransactionsDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LeVaLu
 */
public class PaypalServices implements Serializable {

    private static final String CLIENT_ID = "Af-PcQIImNW0dWkaoTd0HY8QnhB29eB5juEd6f94iomJLXzNwZ_ojA9gcwuM4c30CeHgdhm6rlR8TuCZ";
    private static final String CLIENT_SECRET = "EGvc4CAgPQXrHQg_h8GlINyZV1XMHQpIMc6RVNBRR81JumNyalveHsg-pC6g4WWib0L76TO0usfbz5kS";
    private static final String MODE = "sandbox";

    private static final String URL_RETURN = "http://localhost:8084/J3.L.P0003/ExecutePaymentAction";
    private static final String URL_CANCEL = "http://localhost:8084/J3.L.P0003/CartPageAction";

    private static final String CURRENCY = "USD";
    private static final String INTENT = "sale";

    public String createPayment(TransactionsDTO tDTO) throws PayPalRESTException {
        Payer payer = getPayer();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransactions = getTransactions(tDTO);

        // Create request payment
        Payment requestPayment = new Payment();
        requestPayment.setPayer(payer);
        requestPayment.setTransactions(listTransactions);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setIntent(INTENT);

        // Create approved payment 
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContent = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContent, paymentExecution);
    }

    // Get Payer with paypal method
    private Payer getPayer() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        return payer;
    }

    // Set redirect urls when payer accept or cancel payment
    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setReturnUrl(URL_RETURN);
        redirectUrls.setCancelUrl(URL_CANCEL);

        return redirectUrls;
    }

    // Get approval url after created payment
    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }
        return approvalLink;
    }

    // Get Transtion list
    private List<Transaction> getTransactions(TransactionsDTO tDTO) {
        Details details = new Details();
        Amount amount = new Amount();
        if (tDTO.getDiscountCode() == null || tDTO.getDiscountCode().equals("")) {
            details.setShipping("0.00");
            details.setSubtotal(String.format("%.2f", tDTO.getTotalPrice()));
            details.setTax("0.00");

            amount.setCurrency(CURRENCY);
            amount.setTotal(String.format("%.2f", tDTO.getTotalPrice()));
            amount.setDetails(details);
        } else {
            details.setShipping("0.00");
            float x = (tDTO.getTotalPrice() * (100 - tDTO.getSalePercent()) / 100);
            details.setSubtotal(String.format("%.2f", x));
            details.setTax("0.00");

            amount.setCurrency(CURRENCY);
            amount.setTotal(String.format("%.2f", (tDTO.getTotalPrice() * (100 - tDTO.getSalePercent()) / 100)));
            amount.setDetails(details);
        }

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();
        Item item;

        for (BookingDetails bd : tDTO.getList()) {
            item = new Item();
            item.setCurrency(CURRENCY);
            item.setName(bd.getHotelName() + " - " + bd.getRoomType() + " - x" + bd.getQuantity() + " - From " + bd.getDateCheckin() + " to " + bd.getDateCheckout());
            item.setPrice(String.format("%.2f", bd.getSubPrice()));
            item.setQuantity(String.valueOf(bd.getQuantity()));
            item.setTax("0.0");
            items.add(item);
        }

        if (tDTO.getDiscountCode() != null && !tDTO.getDiscountCode().equals("")) {
            item = new Item();
            item.setCurrency(CURRENCY);
            item.setName("SalePercent");
            item.setPrice(String.format("%.2f", (0 - tDTO.getTotalPrice() * tDTO.getSalePercent() / 100)));
            item.setTax("0.0");
            item.setQuantity("1");
            items.add(item);
        }

        itemList.setItems(items);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

}
