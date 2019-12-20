/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author popem
 */
public class InventoryDTO implements Serializable{
    private String username, item;
    private int quantity;

    public InventoryDTO(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    
    public InventoryDTO(String username, String Item, int quantity) {
        this.username = username;
        this.item = Item;
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(item);
        v.add(quantity);
        return v;
    }
}
