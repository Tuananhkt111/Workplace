/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.htmlutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Admin
 */
public class UltimateCrawler {

    public static DOMResult crawl(String configPath, String xslPath) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        // init files 
        StreamSource xslCate = new StreamSource(xslPath);
        InputStream is = new FileInputStream(configPath);

        // int transformer api
        TransformerFactory factory = TransformerFactory.newInstance();
        DOMResult domRs = new DOMResult();
        Transformer transformer = factory.newTransformer(xslCate);
        transformer.setOutputProperty("indent", "yes");
//        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new StreamSource(is), domRs);
        return domRs;
    }

    public static boolean ultimateCrawl(String configPath, String xslPath, String outputPath) {
        try {
            DOMResult rs = crawl(configPath, xslPath);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult sr = new StreamResult(new FileOutputStream(outputPath));
            transformer.transform(new DOMSource(rs.getNode()), sr);
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UltimateCrawler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(UltimateCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


}
