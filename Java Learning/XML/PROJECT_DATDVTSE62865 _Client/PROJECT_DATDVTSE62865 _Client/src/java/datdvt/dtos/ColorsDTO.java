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
@XmlRootElement(name = "colors")
public class ColorsDTO {

    private List<ColorDTO> list;

    @XmlElement(name = "color")
    public List<ColorDTO> getList() {
        return list;
    }

    public void setList(List<ColorDTO> list) {
        this.list = list;
    }
}
