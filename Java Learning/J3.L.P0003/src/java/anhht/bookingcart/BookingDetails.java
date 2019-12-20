/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.bookingcart;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tuana
 */
public class BookingDetails implements Serializable {
    private String hotelName, roomType, roomTypeID;
    private int quantity, availableRoom;
    private Date dateCheckin, dateCheckout;
    private float price;

    public BookingDetails(String hotelName, String roomType, String roomTypeID, int quantity, int availableRoom, Date dateCheckin, Date dateCheckout, float price) {
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.roomTypeID = roomTypeID;
        this.quantity = quantity;
        this.availableRoom = availableRoom;
        this.dateCheckin = dateCheckin;
        this.dateCheckout = dateCheckout;
        this.price = price;
    }

    public BookingDetails(String hotelName, String roomType, int quantity, Date dateCheckin, Date dateCheckout, float price) {
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.quantity = quantity;
        this.dateCheckin = dateCheckin;
        this.dateCheckout = dateCheckout;
        this.price = price;
    }
    
    

    public String getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(String roomTypeID) {
        this.roomTypeID = roomTypeID;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailableRoom() {
        return availableRoom;
    }

    public void setAvailableRoom(int availableRoom) {
        this.availableRoom = availableRoom;
    }

    public Date getDateCheckin() {
        return dateCheckin;
    }

    public void setDateCheckin(Date dateCheckin) {
        this.dateCheckin = dateCheckin;
    }

    public Date getDateCheckout() {
        return dateCheckout;
    }

    public void setDateCheckout(Date dateCheckout) {
        this.dateCheckout = dateCheckout;
    }

    public float getSubPrice() {
        return price * quantity * ((dateCheckout.getTime() - dateCheckin.getTime())/86400000);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
}
