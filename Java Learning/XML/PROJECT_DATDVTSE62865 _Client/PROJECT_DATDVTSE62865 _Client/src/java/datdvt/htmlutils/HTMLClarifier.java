/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.htmlutils;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class HTMLClarifier {

    public static boolean getXMLToFile(String url, String filePath) {
        try {
            String xmlString = getXML(url);
//            FileWriter fileWriter = new FileWriter(filePath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), Charset.forName("UTF-8"));
//            PrintWriter printWriter = new PrintWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);
            printWriter.print(xmlString);
            printWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(HTMLClarifier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static String getXML(String url) throws IOException {
        //Get Connection
        URLConnection conn = getConnection(url);
        //Get html String
        InputStream inputStream = conn.getInputStream();
        String htmlString = getHTMLString(inputStream);
        //Encode Character in HTML String
        String encodeHTMLString = HTMLSymbolClarifier.encodeHTML(htmlString);
        //Get only <body> tags
        String bodyHTMLString = getHTMLBody(encodeHTMLString);
        //Get usable tags and remove miscellaneous tags
        String usableTag = getUsableTags(bodyHTMLString);
        HTMLWellformer wellform = new HTMLWellformer();
        String wellformedHtml = wellform.check(usableTag);
//        String addXML="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"+wellformedHtml;
        return wellformedHtml;
    }

    private static URLConnection getConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setReadTimeout(30 * 1000);
        connection.setConnectTimeout(9 * 1000);
        connection.addRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("content-type", "application/xml");

        return connection;
    }

    private static String getHTMLString(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private static String getHTMLBody(String src) {
        String result = src;
        String expression = "<body.*?</body>";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(result);
        if (matcher.find()) {
            result = matcher.group(0);
        }
        return result;

    }

    private static String getUsableTags(String src) {
        String result = src;
        String expression = "<script.*?</script>";
        result = result.replaceAll(expression, "");

        expression = "<!--.*?-->";
        result = result.replaceAll(expression, "");

        expression = "&nbsp;?";
        result = result.replaceAll(expression, "");

        expression = "<br>";
        result = result.replaceAll(expression, "");

        expression = "<div class=\"fb-customerchat\".*?</div>";
        result = result.replaceAll(expression, "");
        return result;

    }

    public static String post(String url, String content) {
        OutputStream os = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("content-type", "application/xml");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            os = connection.getOutputStream();
            os.write(content.getBytes("UTF-8"));
            os.flush();

            is = connection.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String line;
            String response = "";
            while ((line = br.readLine()) != null) {
                response += line.trim();
            }

            connection.disconnect();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


}
