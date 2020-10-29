/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.crawler;

import anhht.thread.BaseThread;
import anhht.utils.AppConstant;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author tuana
 */
public class BurpeeEachPageCrawler extends BaseCrawler implements Runnable {

    private String url;
    private CategoryDTO categoryDTO;

    public BurpeeEachPageCrawler(String url, CategoryDTO categoryDTO, ServletContext context) {
        super(context);
        this.url = url;
        this.categoryDTO = categoryDTO;
    }

    @Override
    public void run() {
        try (BufferedReader reader = getBufferedreaderFromURL(url)) {
            String line = "";
            String document = "<document>";
            boolean isStart = false, isEnding = false;
            int divCounter = 0, divOpen = 0, divClose = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<ul id=\"search-result-items\" class=\"l-product_tiles hide-compare \">")) {
                    isStart = true;
                }
                if (isStart) {
                    document += line.trim();
                    System.out.println(line.trim() + "\n");
                }
                if (isStart && line.contains("</ul>")) {
                    break;
                }
            }
            try {
                synchronized (BaseThread.getInstance()) {
                    while (BaseThread.isSuspended()) {
                        BaseThread.getInstance().wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            stAXParserForEachPage(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void stAXParserForEachPage(String document) throws Exception {
        document = document.trim();
        XMLEventReader eventReader = parseStringToXMlEventReader(document);
        Map<String, String> categories = new HashMap<>();
        String detailLink = "", imgLink = "", price = "", productName = "";
        boolean isStart = false, isFound = false;
        while(eventReader.hasNext()) {
            String tagName = "";
            XMLEvent event = (XMLEvent) eventReader.next();
            if(event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                tagName = startElement.getName().getLocalPart();
                if("li".equals(tagName)) {
                    isFound = true;
                } else if("div".equals(tagName) && isFound) {
                    isStart = true;
                } else if("a".equals(tagName) && isStart) {
                    startElement = event.asStartElement();
                    Attribute attrHref = startElement.getAttributeByName(new QName("href"));
                    detailLink = attrHref == null ? "" : (AppConstant.URL_BURPEE + attrHref.getValue());
                    eventReader.next();
                    eventReader.next();
                    startElement = event.asStartElement();
                    Attribute attrSrc = startElement.getAttributeByName(new QName("src"));
                    imgLink = attrSrc == null ? "" : (AppConstant.URL_BURPEE + attrSrc.getValue());
                    isFound = isStart = false;
                    try {
//                        VegetableDTO dto = new
                        //insert when crawling
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
