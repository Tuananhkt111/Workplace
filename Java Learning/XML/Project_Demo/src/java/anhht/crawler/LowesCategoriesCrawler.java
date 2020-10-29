/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.crawler;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author tuana
 */
public class LowesCategoriesCrawler extends BaseCrawler {

    public LowesCategoriesCrawler(ServletContext context) {
        super(context);
    }

    public Map<String, String> getCategories(String url) {
        try (BufferedReader reader = getBufferedreaderFromURL(url)) {
            String document = "", line;
            int divCounter = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<div class=\"imagecolumncontainer parbase section\">")) {
                    divCounter++;
                }
                if (divCounter > 1) {
                    break;
                }
                if (divCounter == 1) {
                    document += line.trim();
                }
            }
            return stAXParserForCategories(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String, String> stAXParserForCategories(String document) throws Exception {
        document = document.trim();
        XMLEventReader eventReader = parseStringToXMlEventReader(document);
        Map<String, String> categories = new HashMap<>();
        while(eventReader.hasNext()) {
            XMLEvent event = (XMLEvent) eventReader.next();
            if(event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                String tagName = startElement.getName().getLocalPart();
                if("a".equals(tagName)) {
                    Attribute attrHref = startElement.getAttributeByName(new QName("href"));
                    String link = attrHref == null ? "" : attrHref.getValue();
                    eventReader.next();
                    eventReader.next();
                    event = (XMLEvent) eventReader.next();
                    Characters characters = event.asCharacters();
                    categories.put(link, characters.getData());
                }
            }
        }
        return categories;
    }
}
