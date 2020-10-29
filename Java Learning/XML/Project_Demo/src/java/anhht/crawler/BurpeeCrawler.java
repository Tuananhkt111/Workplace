/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.crawler;

import anhht.entity.VegetableCategory;
import anhht.thread.BaseThread;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletContext;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author tuana
 */
public class BurpeeCrawler extends BaseCrawler implements Runnable {

    private String url;
    private String categoryName;
    protected VegetableCategory vegetableCategory = null;

    public BurpeeCrawler(String url, String categoryName, ServletContext context) {
        super(context);
        this.url = url;
        this.categoryName = categoryName;
    }

    @Override
    public void run() {
//        categoryDTO = createCategory(categoryName);
        if (vegetableCategory == null) {
            System.out.println("Error: Category null");
            return;
        }
        try (BufferedReader reader = getBufferedreaderFromURL(url)) {
            String line = "", document = "";
            boolean isStart = false, isEnding = false;
            int divCounter = 0, divOpen = 0, divClose = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<div class=\"b-filters-results_hits\">")) {
                    isStart = true;
                }
                if (isStart) {
                    document += line.trim();
                    System.out.println(line.trim() + "\n");
                }
                if (isStart && line.contains("</div>")) {
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
            int lastPage = getLastPage(document);
            for (int i = 0; i < lastPage; i++) {
                String pageUrl = url + "#start=" + (i*12) + "&sz=12&type=grid";
                Thread pageCrawlingThread = new Thread(new BurpeeEachPageCrawler(pageUrl, vegetableCategory, this.getContext()));
                pageCrawlingThread.start();
                try {
                    synchronized (BaseThread.getInstance()) {
                    while (BaseThread.isSuspended()) {
                        BaseThread.getInstance().wait();
                    }
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getLastPage(String document) throws Exception {
        document = document.trim();
        XMLEventReader eventReader = parseStringToXMlEventReader(document);
        String tagName = "";
        String numOfProductsText = "";
        while (eventReader.hasNext()) {            
            XMLEvent event = (XMLEvent) eventReader.next();
            if(event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                tagName = startElement.getName().getLocalPart();
                if("div".equals(tagName)) {
                    event = (XMLEvent) eventReader.next();
                    Characters characters = event.asCharacters();
                    numOfProductsText = characters.getData();
                }
            }
        }
        if(numOfProductsText != null && !numOfProductsText.isEmpty()) {
            String regex = "[0-9]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(numOfProductsText);
            if(matcher.find()) {
                String result = matcher.group();
                try {
                    int number = Integer.parseInt(result);
                    return number/12 + 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return 1;
    }
}
