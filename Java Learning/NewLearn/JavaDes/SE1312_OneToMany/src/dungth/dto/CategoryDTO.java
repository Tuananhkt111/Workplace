/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.dto;

import java.util.Vector;

/**
 *
 * @author Hoang Dung
 */
public class CategoryDTO {

    private String id, name, des;

    public CategoryDTO() {

    }

    public CategoryDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(id);
        v.add(name);
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

}
