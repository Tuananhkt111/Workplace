/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.shoppingcart;

import anhht.transactiondetails.TransactionDetailsDTO;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author tuana
 */
public class ShoppingCart implements Serializable {

    private final HashMap<String, TransactionDetailsDTO> cart;

    public HashMap<String, TransactionDetailsDTO> getCart() {
        return cart;
    }

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public boolean addCart(TransactionDetailsDTO dto) {
        boolean check = false;
        if (!this.cart.containsKey(dto.getBookID())) {
            this.cart.put(dto.getBookID(), dto);
            check = true;
        } else {
            int quantity = this.cart.get(dto.getBookID()).getQuantity();
            if (dto.getAvailableQuantity() >= (quantity + 1)) {
                this.cart.get(dto.getBookID()).setQuantity(quantity + 1);
                check = true;
            }
        }
        return check;
    }

    public boolean removeCart(String bookID) {
        if (this.cart.containsKey(bookID)) {
            this.cart.remove(bookID);
            return true;
        }
        return false;
    }

    public boolean updateCart(String bookID, int quantity) {
        boolean check = false;
        if (this.cart.containsKey(bookID)) {
            if (quantity <= this.cart.get(bookID).getAvailableQuantity()) {
                this.cart.get(bookID).setQuantity(quantity);
                check = true;
            }
        }
        return check;
    }
}
