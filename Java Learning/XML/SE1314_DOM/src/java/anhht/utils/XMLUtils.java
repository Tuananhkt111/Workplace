/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.utils;

import java.io.File;
import java.io.Serializable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author tuana
 */
public class XMLUtils implements Serializable{
    public static Document parseFileToDOM(String filePath) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        File file = new File(filePath);
        Document doc = db.parse(file);
        return doc;
    }
    
    public static XPath createXPath() throws Exception {
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xPath = xpf.newXPath();
        return xPath;
    }
    
    public static boolean transformDOMSrcToStreamResult(Node node, String filePath) {
        try {
            Source src = new DOMSource(node);
            File file = new File(filePath);
            Result result = new StreamResult(file);
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.transform(src, result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
