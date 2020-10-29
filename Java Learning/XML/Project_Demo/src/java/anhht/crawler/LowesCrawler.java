/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.crawler;

import anhht.entity.BedCategory;
import anhht.thread.BaseThread;
import javax.servlet.ServletContext;

/**
 *
 * @author tuana
 */
public class LowesCrawler extends BaseCrawler implements Runnable {

    private String url;
    private String categoryName;
    protected BedCategory bedCategory = null;

    public LowesCrawler(String url, String categoryName, ServletContext context) {
        super(context);
        this.url = url;
        this.categoryName = categoryName;
    }

    @Override
    public void run() {
        //categoryDTO = createCategory(categoryName);
        if (bedCategory == null) {
            System.out.println("Error: Category null");
            return;
        }
        Thread pageCrawlingThread = new Thread(new LowesEachPageCrawler(url, bedCategory, this.getContext()));
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
