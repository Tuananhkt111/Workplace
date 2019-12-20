/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.hotel;

import java.io.Serializable;

/**
 *
 * @author tuana
 */
public class HotelDTO implements Serializable {
    private String hotelID, hotelName, address, phone, photo, description;
    private float minPrice;

    public HotelDTO(String hotelID, String hotelName, String address, String phone, String photo, String description, float minPrice) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.address = address;
        this.phone = phone;
        this.photo = photo;
        this.description = description;
        this.minPrice = minPrice;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }
    
}
