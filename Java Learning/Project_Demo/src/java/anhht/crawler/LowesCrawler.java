/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.crawler;

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
public class LowesCrawler extends BaseCrawler implements Runnable {

    private String url;
    private String categoryName;
    protected BedCatDTO bedCatDTO = null;

    public LowesCrawler(String url, String categoryName, ServletContext context) {
        super(context);
        this.url = url;
        this.categoryName = categoryName;
    }

    @Override
    public void run() {
        //categoryDTO = createCategory(categoryName);
        if (categoryDTO == null) {
            System.out.println("Error: Category null");
            return;
        }
        Thread pageCrawlingThread = new Thread(new BurpeeEachPageCrawler(pageUrl, categoryDTO, context));
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
}
