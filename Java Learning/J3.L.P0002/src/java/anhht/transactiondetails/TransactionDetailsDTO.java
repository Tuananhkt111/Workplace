/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.transactiondetails;

import java.io.Serializable;

/**
 *
 * @author tuana
 */
public class TransactionDetailsDTO implements Serializable {
    private String tranID, bookID, title;
    private int quantity;
    private int availableQuantity;
    private float price;
    

    public TransactionDetailsDTO(String tranID, String bookID, String title, int quantity, float price) {
        this.tranID = tranID;
        this.bookID = bookID;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public TransactionDetailsDTO(String bookID, String title, int quantity, float price) {
        this.bookID = bookID;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public TransactionDetailsDTO(String bookID, String title, int quantity, int availableQuantity, float price) {
        this.bookID = bookID;
        this.title = title;
        this.quantity = quantity;
        this.availableQuantity = availableQuantity;
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getTranID() {
        return tranID;
    }

    public void setTranID(String tranID) {
        this.tranID = tranID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotalPrice() {
        return price * quantity;
    }
    
}
