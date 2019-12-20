/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.pdto;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Hoang Dung
 */
public class ProductDTO implements Serializable {

    private String id, name, des, cateID;
    private int quantity;

    public ProductDTO() {

    }

    public ProductDTO(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(quantity);
        return v;
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

    public int getQuantity() {
        return quantity;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
