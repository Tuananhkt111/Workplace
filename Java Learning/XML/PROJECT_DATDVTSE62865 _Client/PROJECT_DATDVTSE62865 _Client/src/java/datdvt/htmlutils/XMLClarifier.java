/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.htmlutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Admin
 */
public class XMLClarifier {

    public static Document parseFileToDom(String filePath) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(filePath);
            Document doc = db.parse(file);
//            Document doc = db.parse(new InputSource(file));
            return doc;
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean transformDomToStreamResult(Node node, String filepath) {
        Source src = new DOMSource(node);
        File file = new File(filepath);
        Result result = new StreamResult(file);
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            Transformer trans = tff.newTransformer();
            trans.transform(src, result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Source createXMLSource(String urlString) throws IOException {
        String xmlString = HTMLClarifier.getXML(urlString);
        Source xml = new StreamSource(new StringReader(xmlString));
        return xml;
    }

    public static boolean getXMLToFile(String xmlString, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter("web\\WEB-INF\\" + filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(xmlString);
            printWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(HTMLClarifier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    public static String getXMLWithExpression(String filePath, String exp) throws IOException {
        String result = readFile("web\\WEB-INF\\"+filePath);
        String expression = exp;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(result);
        if (matcher.find()) {
            result = matcher.group(0);
        }
        return result;
    }
    
    public static boolean convertXMLToFile(String xmlString, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter("web\\WEB-INF\\" + filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(xmlString);
            printWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(HTMLClarifier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Node moveToChildNode(Node node, String nodeName) {
        node = node.getFirstChild();
        while (true) {
            if (node != null && !node.getNodeName().equals(nodeName)) {
                node = node.getNextSibling();

                if (node == null) {
                    return null;
                }
            } else {
                break;
            }
        }
        return node;
    }

    public static Node moveToNodeSibling(Node node, String nodeName) {
        node = node.getNextSibling();
        while (true) {
            if (node != null && !node.getNodeName().equals(nodeName)) {
                node = node.getNextSibling();
                if (node == null) {
                    return null;
                }
            } else {
                break;
            }
        }
        return node;
    }

    public static Node getNodeWithAttribute(Node node, String nodeName, String attribute) {
        while (true) {
            if (node == null) {
                return null;
            }
            if (node != null && !node.getNodeName().equals(nodeName)) {
                if (node.hasChildNodes()) {
                    System.out.println("tag child " + node.getNodeName() + " - " + node.getFirstChild().getNodeName());
                    getNodeWithAttribute(node.getFirstChild(), nodeName, attribute);
                }
                if (node.getNextSibling() != null && !node.getNextSibling().getNodeName().equals("#text")) {
                    System.out.println("tag nextsibling " + node.getNodeName() + " - " + node.getNextSibling().getNodeName());
                    getNodeWithAttribute(node.getNextSibling(), nodeName, attribute);
                }

            } else {
                break;
            }
        }
        return node;
    }
    public static  String parseObjectToXMLString(Object object, Class c) {
        StringWriter sw = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            
            Marshaller marshaller = context.createMarshaller(); 
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, sw);
            
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            try {
                sw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
 
}
