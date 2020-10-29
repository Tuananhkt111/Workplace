/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.thread;

import anhht.crawler.BurpeeCategoriesCrawler;
import anhht.crawler.BurpeeCrawler;
import anhht.utils.AppConstant;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContext;

/**
 *
 * @author tuana
 */
public class BurpeeThread extends BaseThread implements Runnable {

    private ServletContext context;

    public BurpeeThread(ServletContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (true) {
            try {
                BurpeeCategoriesCrawler burpeeCategoriesCrawler = new BurpeeCategoriesCrawler(context);
                Map<String, String> categories = burpeeCategoriesCrawler.getCategories(AppConstant.URL_BURPEE);
                for (Map.Entry<String, String> entry : categories.entrySet()) {
                    Thread crawlingThread = new Thread(new BurpeeCrawler(entry.getKey(), entry.getValue(), context));
                    crawlingThread.start();
                    synchronized (BaseThread.getInstance()) {
                        while (BaseThread.isSuspended()) {
                            BaseThread.getInstance().wait();
                        }
                    }
                }
                BurpeeThread.sleep(TimeUnit.DAYS.toMillis(AppConstant.BREAK_TIME_CRAWLING));
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
}
