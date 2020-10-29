package anhht.sax;

import anhht.daos.NewDAO;
import anhht.dtos.NewDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author leehe
 */
public class NewHandler extends DefaultHandler {
    private String currentTag;
    private boolean foundItem;
    private NewDTO dto;
    private NewDAO dao;
    public NewHandler() {
        dao = new NewDAO();
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("item")) {
            foundItem = true;
            dto = new NewDTO();
        }
        currentTag = qName;
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("item")) {
            //gọi insert database
            foundItem = false;
            try {
                dao.insertNew(dto);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        currentTag = "";
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String (ch, start, length);
        if (foundItem) {
            if (currentTag.equals("title")) {
                dto.setTitle(str.trim());
            } else if (currentTag.equals("description")) {
                dto.setDescription(str.trim());
            } else if (currentTag.equals("link")) {
                dto.setLink(str.trim());
            }  else if (currentTag.equals("pubDate")) {
                dto.setPubDate(str.trim());
            }
        }
    }

    
}