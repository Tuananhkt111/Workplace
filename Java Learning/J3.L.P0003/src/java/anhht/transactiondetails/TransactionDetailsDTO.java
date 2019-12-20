/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.transactiondetails;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tuana
 */
public class TransactionDetailsDTO implements Serializable {
    private String tranID, roomID, hotelName, roomType;
    private Date DateCheckin, DateCheckout;
    private float subPrice;

    public TransactionDetailsDTO(String tranID, String roomID, String hotelName, String roomType, Date DateCheckin, Date DateCheckout, float subPrice) {
        this.tranID = tranID;
        this.roomID = roomID;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.DateCheckin = DateCheckin;
        this.DateCheckout = DateCheckout;
        this.subPrice = subPrice;
    }

    public TransactionDetailsDTO(String roomID, String hotelName, String roomType, Date DateCheckin, Date DateCheckout, float subPrice) {
        this.roomID = roomID;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.DateCheckin = DateCheckin;
        this.DateCheckout = DateCheckout;
        this.subPrice = subPrice;
    }

    public String getTranID() {
        return tranID;
    }

    public void setTranID(String tranID) {
        this.tranID = tranID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getDateCheckin() {
        return DateCheckin;
    }

    public void setDateCheckin(Date DateCheckin) {
        this.DateCheckin = DateCheckin;
    }

    public Date getDateCheckout() {
        return DateCheckout;
    }

    public void setDateCheckout(Date DateCheckout) {
        this.DateCheckout = DateCheckout;
    }

    public float getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(float subPrice) {
        this.subPrice = subPrice;
    }
    
}
