/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.prolistdetails;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author tuana
 */
public class ProListDetailsDTO implements Serializable {
    private String userID, phID;
    private float rank;
    private Timestamp timeAssigned;

    public ProListDetailsDTO(String userID, float rank) {
        this.userID = userID;
        this.rank = rank;
    }

    public ProListDetailsDTO(String userID, String phID, float rank, Timestamp timeAssigned) {
        this.userID = userID;
        this.phID = phID;
        this.rank = rank;
        this.timeAssigned = timeAssigned;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public String getPhID() {
        return phID;
    }

    public void setPhID(String phID) {
        this.phID = phID;
    }

    public Timestamp getTimeAssigned() {
        return timeAssigned;
    }

    public void setTimeAssigned(Timestamp timeAssigned) {
        this.timeAssigned = timeAssigned;
    }

   
    
}
