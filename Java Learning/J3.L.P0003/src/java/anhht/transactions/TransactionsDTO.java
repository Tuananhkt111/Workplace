/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.transactions;

import anhht.bookingcart.BookingDetails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tuana
 */
public class TransactionsDTO implements Serializable, Comparable<TransactionsDTO>{
    private String tranID, email;
    private String discountCode;
    private float totalPrice;
    private int SalePercent;
    private Date dateBooked;
    private ArrayList<BookingDetails> list;

    public TransactionsDTO(String tranID, String email, String discountCode, float totalPrice, int SalePercent, Date dateBooked) {
        this.tranID = tranID;
        this.email = email;
        this.discountCode = discountCode;
        this.totalPrice = totalPrice;
        this.SalePercent = SalePercent;
        this.dateBooked = dateBooked;
    }

    public TransactionsDTO() {
    }
    
    
    public String getTranID() {
        return tranID;
    }

    public void setTranID(String tranID) {
        this.tranID = tranID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSalePercent() {
        return SalePercent;
    }

    public void setSalePercent(int SalePercent) {
        this.SalePercent = SalePercent;
    }

    public Date getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(Date dateBooked) {
        this.dateBooked = dateBooked;
    }

    public ArrayList<BookingDetails> getList() {
        return list;
    }

    public void setList(ArrayList<BookingDetails> list) {
        this.list = list;
    }

    @Override
    public int compareTo(TransactionsDTO o) {
        return getDateBooked().compareTo(o.getDateBooked());
    }
    
}
