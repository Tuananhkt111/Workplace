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
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author tuana
 */
public class LowesEachPageCrawler extends BaseCrawler implements Runnable {

    private String url;
    private BedCatDTO bedCatDTO;

    public LowesEachPageCrawler(String url, BedCatDTO bedCatDTO, ServletContext context) {
        super(context);
        this.url = url;
        this.bedCatDTO = bedCatDTO;
    }

    @Override
    public void run() {
        try (BufferedReader reader = getBufferedreaderFromURL(url)) {
            String line = "";
            String document = "<document>";
            boolean isStart = false, isFound = false;
            int divCounter = 0, divOpen = 0, divClose = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<div class=\"ru7jno-0 jHJUqJ product-list-plgcs\">")) {
                    isFound = true;
                }
                if (isFound && line.contains("<div data-col")) {
                    isStart = true;
                }
                if (isStart) {
                    if (line.contains("<div data-selector=\"splp-show-wrp\"")) {
                        document += "</document>";
                        break;
                    } else {
                        document += line.trim();
                    }
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
        String imgLink = "", productName = "";
        boolean isFound = false;
        int spanCounter = 0;
        while (eventReader.hasNext()) {
            String tagName = "";
            XMLEvent event = (XMLEvent) eventReader.next();
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                tagName = startElement.getName().getLocalPart();
                if ("img".equals(tagName)) {
                    startElement = event.asStartElement();
                    Attribute attrSrc = startElement.getAttributeByName(new QName("src"));
                    imgLink = attrSrc == null ? "" : attrSrc == null ? "" : attrSrc.getValue();
                    isFound = true;
                }
                if ("span".equals(tagName) && isFound) {
                    spanCounter++;
                    if (spanCounter == 3) {
                        eventReader.next();
                        eventReader.next();
                        event = (XMLEvent) eventReader.next();
                        Characters characters = event.asCharacters();
                        productName = characters.getData();
                        spanCounter = 0;
                        isFound = false;
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
}
