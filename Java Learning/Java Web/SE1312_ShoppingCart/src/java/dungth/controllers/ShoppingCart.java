/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.controllers;

import dungth.dtos.BookDTO;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Hoang Dung
 */
public class ShoppingCart implements Serializable {
    
    private String customerName;
    private HashMap<String, BookDTO> cart;
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public HashMap<String, BookDTO> getCart() {
        return cart;
    }
    
    public ShoppingCart() {
        this.customerName = "Guest";
        this.cart = new HashMap<>();
    }
    
    public ShoppingCart(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }
    
    public void addCart(BookDTO dto) throws Exception {
        if (this.cart.containsKey(dto.getId())) {
            int quantity = this.cart.get(dto.getId()).getQuantity() + 1;
            dto.setQuantity(quantity);
        }
        this.cart.put(dto.getId(), dto);
    }
    
    public void removeCart(String id) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    
    public float getTotal() throws Exception {
        float result = 0;
        for (BookDTO dto : this.cart.values()) {
            result += dto.getPrice() * dto.getQuantity();
        }
        return result;
    }
    
    public void updateCart(String id, int quantity) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.get(id).setQuantity(quantity);
        }
    }
}
