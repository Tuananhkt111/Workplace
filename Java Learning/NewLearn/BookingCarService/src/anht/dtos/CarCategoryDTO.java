/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anht.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author tuana
 */
public class CarCategoryDTO implements Serializable{
    private int numberOfSeats, surchargeHr;
    private float discount;

    public CarCategoryDTO(int numberOfSeats, int surchargeHr, float discount) {
        this.numberOfSeats = numberOfSeats;
        this.surchargeHr = surchargeHr;
        this.discount = discount;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getSurchargeHr() {
        return surchargeHr;
    }

    public void setSurchargeHr(int surchargeHr) {
        this.surchargeHr = surchargeHr;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(numberOfSeats);
        v.add(surchargeHr);  
        v.add(discount);                  
        return v;
    }
}
