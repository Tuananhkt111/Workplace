/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.thread;

import anhht.crawler.LowesCategoriesCrawler;
import anhht.utils.AppConstant;
import java.util.Map;
import javax.servlet.ServletContext;

/**
 *
 * @author tuana
 */
public class LowesThread extends BaseThread implements Runnable {
    private ServletContext context;

    public LowesThread(ServletContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        while(true) {
            try {
                LowesCategoriesCrawler categoriesCrawler = new LowesCategoriesCrawler(context);
                Map<String, String> categories = categoriesCrawler.getCategories(AppConstant.URL_LOWES_PLANTER_BOXES);
                for (Map.Entry<String, String> entry : categories.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    
                }
            } catch (Exception e) {
            }
        }
    }
}
