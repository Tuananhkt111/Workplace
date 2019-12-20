/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author tuana
 */
public class TravelPriceDTO implements Serializable{
    private String id, destination;
    private int limitTime, estDistance, numberOfSeats, price;

    public TravelPriceDTO(String id, String destination, int limitTime, int estDistance, int numberOfSeats, int price) {
        this.id = id;
        this.destination = destination;
        this.limitTime = limitTime;
        this.estDistance = estDistance;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(int limitTime) {
        this.limitTime = limitTime;
    }

    public int getEstDistance() {
        return estDistance;
    }

    public void setEstDistance(int estDistance) {
        this.estDistance = estDistance;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(id);
        v.add(destination);  
        v.add(limitTime);
        v.add(estDistance);
        v.add(numberOfSeats);        
        v.add(price);                     
        return v;
    }
}
