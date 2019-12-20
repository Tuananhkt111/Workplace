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
public class CarDTO implements Serializable{
    private String serial, name;
    private int numberOfSeats;
    private boolean isAvailable;

    public CarDTO(String serial, String name, int numberOfSeats, boolean isAvailable) {
        this.serial = serial;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.isAvailable = isAvailable;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(serial);   
        v.add(name);
        v.add(numberOfSeats);
        v.add(isAvailable);
        return v;
    }
    
    public Vector toVector2() {
        Vector v = new Vector();  
        v.add(name);
        v.add(numberOfSeats);
        return v;
    }
    
}
