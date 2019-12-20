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
public class RestaurantDTO implements Serializable{
    private String id, name, address, district;
    private boolean isDelete;

    public RestaurantDTO(String id, String name, String address, String district, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.district = district;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(address);
        v.add(district);
        v.add(isDelete);
        return v;
    }
}
