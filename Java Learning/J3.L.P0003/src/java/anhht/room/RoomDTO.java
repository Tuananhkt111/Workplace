/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.room;

import java.io.Serializable;

/**
 *
 * @author tuana
 */
public class RoomDTO implements Serializable {
    private String roomID, roomTypeID;

    public RoomDTO(String roomID, String roomTypeID) {
        this.roomID = roomID;
        this.roomTypeID = roomTypeID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(String roomTypeID) {
        this.roomTypeID = roomTypeID;
    }
    
}
