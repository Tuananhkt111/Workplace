/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.bookingcart;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author tuana
 */
public class BookingCart implements Serializable {
    private HashMap<String, BookingDetails> cart;

    public BookingCart() {
        this.cart = new HashMap<>();
    }

    public HashMap<String, BookingDetails> getCart() {
        return cart;
    }
    public boolean addCart(BookingDetails dto) {
        boolean check = false;
        if (!this.cart.containsKey(dto.getRoomTypeID())) {
            this.cart.put(dto.getRoomTypeID(), dto);
            check = true;
        } else {
            int quantity = this.cart.get(dto.getRoomTypeID()).getQuantity();
            if (dto.getAvailableRoom()>= (quantity + 1)) {
                this.cart.get(dto.getRoomTypeID()).setQuantity(quantity + 1);
                check = true;
            }
        }
        return check;
    }

    public boolean removeCart(String roomTypeID) {
        if (this.cart.containsKey(roomTypeID)) {
            this.cart.remove(roomTypeID);
            return true;
        }
        return false;
    }

    public boolean updateCart(String roomTypeID, int quantity) {
        boolean check = false;
        if (this.cart.containsKey(roomTypeID)) {
            if (quantity <= this.cart.get(roomTypeID).getAvailableRoom()) {
                this.cart.get(roomTypeID).setQuantity(quantity);
                check = true;
            }
        }
        return check;
    }

    public void setCart(HashMap<String, BookingDetails> cart) {
        this.cart = cart;
    }
    
}
