/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.roomtype;

import java.io.Serializable;

/**
 *
 * @author tuana
 */
public class RoomTypeDTO implements Serializable {
    private String roomTypeID, roomType, description;
    private int maxPeople, availableRoom;
    private float price;

    public RoomTypeDTO(String roomTypeID, String roomType, String description, int maxPeople, int availableRoom, float price) {
        this.roomTypeID = roomTypeID;
        this.roomType = roomType;
        this.description = description;
        this.maxPeople = maxPeople;
        this.availableRoom = availableRoom;
        this.price = price;
    }

    public int getAvailableRoom() {
        return availableRoom;
    }

    public void setAvailableRoom(int availableRoom) {
        this.availableRoom = availableRoom;
    }

    public String getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(String roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
