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
@XmlRootElement(name = "images")

public class ImagesDTO {

    private List<ImageDTO> list;

    @XmlElement(name = "image")

    public List<ImageDTO> getList() {
        return list;
    }

    public void setList(List<ImageDTO> list) {
        this.list = list;
    }

}
