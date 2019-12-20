/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.dtos;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Vector;
/**
 *
 * @author tuana
 */
public class PromotionDTO implements Serializable{
    private String code;
    private float discount;
    private Timestamp startTime, endTime;

    public PromotionDTO(String code, float discount, Timestamp startTime, Timestamp endTime) {
        this.code = code;
        this.discount = discount;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getDiscount() {
        return discount;
    }
    
    public String getDiscountString() {
        return Integer.toString(Math.round(getDiscount() * 100)) + "%";
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(code);
        v.add(getDiscountString());
        v.add(startTime);
        v.add(endTime);
        return v;
    }
}
