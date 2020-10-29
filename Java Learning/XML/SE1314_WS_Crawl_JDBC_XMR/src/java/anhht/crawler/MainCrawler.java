/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.crawler;

import anhht.sax.NewHandler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;

/**
 *
 * @author tuana
 */
public class MainCrawler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            NewHandler handler = new NewHandler();
            MainCrawler crawler = new MainCrawler();
            String url = "https://vnexpress.net/rss/gia-dinh.rss";
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            sp.parse(new InputSource(new StringReader(crawler.readContent(url))), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String readContent(String urlString) throws Exception {
        String content = "";
        try {
            URL url = new URL(urlString);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content += inputLine + "\n";
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
