/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.dtos;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@XmlRootElement(name = "categories")

public class CategoriesDTO {
     private List<CategoryDTO> list;

    @XmlElement(name = "category")

    public List<CategoryDTO> getList() {
        return list;
    }

    public void setList(List<CategoryDTO> list) {
        this.list = list;
    }
    
}