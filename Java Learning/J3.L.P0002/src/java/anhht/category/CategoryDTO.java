/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.category;

import java.io.Serializable;

/**
 *
 * @author tuana
 */
public class CategoryDTO implements Serializable {
    private String catID, catName;

    public CategoryDTO(String catID, String catName) {
        this.catID = catID;
        this.catName = catName;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
