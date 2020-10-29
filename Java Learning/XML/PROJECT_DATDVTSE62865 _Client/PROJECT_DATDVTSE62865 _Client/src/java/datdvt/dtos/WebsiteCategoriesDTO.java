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
@XmlRootElement(name = "websiteCategories")
public class WebsiteCategoriesDTO {

    private List<WebsiteCategoryDTO> list;

    @XmlElement(name = "websiteCategory")
    public List<WebsiteCategoryDTO> getList() {
        return list;
    }

    public void setList(List<WebsiteCategoryDTO> list) {
        this.list = list;
    }

}
