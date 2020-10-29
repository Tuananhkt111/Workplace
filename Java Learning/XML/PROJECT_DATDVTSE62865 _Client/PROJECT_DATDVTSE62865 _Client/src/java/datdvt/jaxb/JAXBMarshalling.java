/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.jaxb;

import datdvt.dtos.ColorsDTO;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


/**
 *
 * @author Admin
 */
public class JAXBMarshalling {
    public static void marshallColorObject(ColorsDTO colorDTO, String filepath){
         try {
            JAXBContext ctx = JAXBContext.newInstance(ColorsDTO.class);
            Marshaller mar = ctx.createMarshaller();
                mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
                mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                mar.marshal(colorDTO, new File(filepath));
                
        } catch (Exception e) {
        }
    }
}
