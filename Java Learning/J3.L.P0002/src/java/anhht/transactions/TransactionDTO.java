/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.transactions;

import anhht.transactiondetails.TransactionDetailsDTO;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author tuana
 */
public class TransactionDTO implements Serializable {
    private String tranID, userID;
    private ArrayList<TransactionDetailsDTO> list;
    private float totalPrice;
    private int salePercent;
    private Timestamp timeBought;

    public TransactionDTO(String tranID, String userID, float totalPrice, Timestamp timeBought) {
        this.tranID = tranID;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.timeBought = timeBought;
    }

    public String getTranID() {
        return tranID;
    }

    public void setTranID(String tranID) {
        this.tranID = tranID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getTimeBought() {
        return timeBought;
    }

    public void setTimeBought(Timestamp timeBought) {
        this.timeBought = timeBought;
    }

    public ArrayList<TransactionDetailsDTO> getList() {
        return list;
    }

    public void setList(ArrayList<TransactionDetailsDTO> list) {
        this.list = list;
    }

    public int getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }
    
}
