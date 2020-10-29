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
public class BurpeeCategoriesCrawler extends BaseCrawler {

    public BurpeeCategoriesCrawler(ServletContext context) {
        super(context);
    }

    public Map<String, String> getCategories(String url) {
        BufferedReader reader = null;
        try {
            reader = getBufferedreaderFromURL(url);
            String line;
            String document = "";
            boolean isStart = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<ul class=\"b-categories_popup-list\" data-cat-name=\"Vegetables\">")) {
                    isStart = true;
                }
                if (isStart) {
                    document += line.trim();
                }
                if (isStart && line.contains("</ul>")) {
                    break;
                }
            }
            return stAXParserForCategories(document);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Map<String, String> stAXParserForCategories(String document) throws Exception {
        document = document.trim();
        XMLEventReader eventReader = parseStringToXMlEventReader(document);
        Map<String, String> categories = new HashMap<>();
        while (eventReader.hasNext()) {
            XMLEvent event = (XMLEvent) eventReader.next();
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                String tagName = startElement.getName().getLocalPart();
                if ("a".equals(tagName)) {
                    Attribute attrHref = startElement.getAttributeByName(new QName("href"));
                    String link = attrHref.getValue();
                    event = (XMLEvent) eventReader.next();
                    Characters characters = event.asCharacters();
                    categories.put(link, characters.getData());
                }
            }
        }
        return categories;
    }
}
