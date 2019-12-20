/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.area;

import java.io.Serializable;

/**
 *
 * @author tuana
 */
public class AreaDTO implements Serializable {
    private String areaID, areaName;

    public AreaDTO(String areaID, String areaName) {
        this.areaID = areaID;
        this.areaName = areaName;
    }

    public String getAreaID() {
        return areaID;
    }

    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
}
