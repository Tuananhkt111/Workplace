/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.htmlutils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class HTMLSymbolClarifier {
    private static final HashMap<String, String> encodeChars = new HashMap<>();

    static {
        encodeChars.put("&#8211;", "-");
        encodeChars.put("&#232;", "è");
        encodeChars.put("&euro;", "€");
        encodeChars.put("&nbsp;", " ");
        encodeChars.put("&#193;", "Á");
        encodeChars.put("&#225;", "á");
        encodeChars.put("&#194;", "Â");
        encodeChars.put("&#226;", "â");
        encodeChars.put("&#180;", "´");
        encodeChars.put("&AElig;", "Æ");
        encodeChars.put("&aelig;", "æ");
        encodeChars.put("&#192;", "À");
        encodeChars.put("&#224;", "à");
        encodeChars.put("&#197;", "Å");
        encodeChars.put("&#195;", "Ã");
        encodeChars.put("&#229;", "å");
        encodeChars.put("&#227;", "ã");
        encodeChars.put("&#196;", "Ä");
        encodeChars.put("&#228;", "ä");
        encodeChars.put("&brvbar;", "¦");
        encodeChars.put("&Ccedil;", "Ç");
        encodeChars.put("&ccedil;", "ç");
        encodeChars.put("&cedil;", "¸");
        encodeChars.put("&cent;", "¢");
        encodeChars.put("&circ;", "ˆ");
        encodeChars.put("&copy;", "©");
        encodeChars.put("&curren;", "¤");
        encodeChars.put("&deg;", "°");
        encodeChars.put("&divide;", "÷");
        encodeChars.put("&#201;", "É");
        encodeChars.put("&#233;", "é");
        encodeChars.put("&#202;", "Ê");
        encodeChars.put("&#234;", "ê");
        encodeChars.put("&#200;", "È");
        encodeChars.put("&#200;", "è");
        encodeChars.put("&#208;", "Ð");
        encodeChars.put("&#208;", "ð");
        encodeChars.put("&#235;", "Ë");
        encodeChars.put("&#235;", "ë");
        encodeChars.put("&euro;", "€");
        encodeChars.put("&fnof;", "ƒ");
        encodeChars.put("&frac12;", "½");
        encodeChars.put("&frac14;", "¼");
        encodeChars.put("&frac34;", "¾");
        encodeChars.put("&#205;", "Í");
        encodeChars.put("&#237;", "í");
        encodeChars.put("&Icirc;", "Î");
        encodeChars.put("&icirc;", "î");
        encodeChars.put("&#161;", "¡");
        encodeChars.put("&#204;", "Ì");
        encodeChars.put("&#236;", "ì");
        encodeChars.put("&iquest;", "¿");
        encodeChars.put("&Iuml;", "Ï");
        encodeChars.put("&iuml;", "ï");
        encodeChars.put("&laquo;", "«");
        encodeChars.put("&macr;", "¯");
        encodeChars.put("&micro;", "µ");
        encodeChars.put("&middot;", "¬");
        encodeChars.put("&Ntilde;", "Ñ");
        encodeChars.put("&ntilde;", "ñ");
        encodeChars.put("&#211;", "Ó");
        encodeChars.put("&#243;", "ó");
        encodeChars.put("&#212;", "Ô");
        encodeChars.put("&#244;", "ô");
        encodeChars.put("&OElig;", "Œ");
        encodeChars.put("&oelig;", "œ");
        encodeChars.put("&#210;", "Ò");
        encodeChars.put("&#242;", "ò");
        encodeChars.put("&ordf;", "ª");
        encodeChars.put("&ordm;", "º");
        encodeChars.put("&Oslash;", "Ø");
        encodeChars.put("&oslash;", "ø");
        encodeChars.put("&Otilde;", "Õ");
        encodeChars.put("&otilde;", "õ");
        encodeChars.put("&Ouml;", "Ö");
        encodeChars.put("&ouml;", "ö");
        encodeChars.put("&para;", "¶");
        encodeChars.put("&plusmn;", "±");
        encodeChars.put("&pound;", "£");
        encodeChars.put("&raquo;", "»");
        encodeChars.put("&reg;", "®");
        encodeChars.put("&Scaron;", "Š");
        encodeChars.put("&scaron;", "š");
        encodeChars.put("&sect;", "§");
        encodeChars.put("&sup1;", "¹");
        encodeChars.put("&sup2;", "²");
        encodeChars.put("&sup3;", "³");
        encodeChars.put("&szlig;", "ß");
        encodeChars.put("&THORN;", "Þ");
        encodeChars.put("&thorn;", "þ");
        encodeChars.put("&tilde;", "˜");
        encodeChars.put("&times;", "×");
        encodeChars.put("&#218;", "Ú");
        encodeChars.put("&#250;", "ú");
        encodeChars.put("&Ucirc;", "Û");
        encodeChars.put("&ucirc;", "û");
        encodeChars.put("&#217;", "Ù");
        encodeChars.put("&#249;", "ù");
        encodeChars.put("&uml;", "¨");
        encodeChars.put("&#221;", "Ý");
        encodeChars.put("&#253;", "ý");
        encodeChars.put("&yen;", "¥");
        encodeChars.put("&ndash;", "–");
        encodeChars.put("&mdash;", "—");
        encodeChars.put("&lsquo;", "‘");
        encodeChars.put("&rsquo;", "’");
        encodeChars.put("&sbquo;", "‚");
        encodeChars.put("&ldquo;", "“");
        encodeChars.put("&rdquo;", "”");
        encodeChars.put("&lsaquo;", "‹");
        encodeChars.put("&rsaquo;", "›");
        encodeChars.put("&bull;", "•");
        encodeChars.put("&hellip;", "…");
        encodeChars.put("&oline;", "‾");
        encodeChars.put("&frasl;", "⁄");
        encodeChars.put("", "");
        encodeChars.put("&apos;", "");
        encodeChars.put("&quote;", "");

    }
    
     private HTMLSymbolClarifier() {
    }


    public static String encodeHTML(String htmlString) {
        if (htmlString ==null) {
            return null;
        }
        return encode(htmlString, encodeChars);
    }

    private static String encode(String htmlString, HashMap<String, String> encodeChars) {
        for (Map.Entry<String, String> entry : encodeChars.entrySet()) {
            String key = entry.getKey();
            if (htmlString.contains(key)) {
                htmlString = htmlString.replace(entry.getKey(), entry.getValue());
            }
        }
        return htmlString;
    }

}
