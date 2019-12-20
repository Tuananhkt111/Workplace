/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.dtos;

import java.util.Vector;

/**
 *
 * @author popem
 */
public class CompletedMissionDTO {
    private String username, mission;
    private int highestScore;

    public CompletedMissionDTO(String username, String mission, int highestScore) {
        this.username = username;
        this.mission = mission;
        this.highestScore = highestScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(mission);
        v.add("");
        v.add(highestScore);
        return v;
    }
}
