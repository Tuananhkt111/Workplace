/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author tuana
 */
public class StudentHandler  extends DefaultHandler {
    private String username, password;
    private boolean foundUsername, foundPassword;
    private boolean found;
    private String fullname;
    private String currentTagName;

    public StudentHandler(String username, String password) {
        this.username = username;
        this.password = password;
        this.found = false;
        this.fullname = "";
        this.currentTagName = "";
        this.foundUsername = false;
        this.foundPassword = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(!found) {
            if(qName.equals("student")) {
                String id = attributes.getValue("id");
                if(id.equals(username)) {
                    this.foundUsername = true;
                }
            }
            this.currentTagName = qName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("student")) {
            this.foundPassword = false;
            this.foundUsername = false;
        }
        this.currentTagName = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(!found) {
            if(foundUsername) {
                if(this.currentTagName.equals("lastname")) {
                    String str = new String(ch, start, length);
                    this.fullname = str.trim();
                } else if(this.currentTagName.equals("middlename")) {
                    String str = new String(ch, start, length);
                    this.fullname += " " + str.trim();
                } else if(this.currentTagName.equals("firstname")) {
                    String str = new String(ch, start, length);
                    this.fullname += " " + str.trim();
                } else if(this.currentTagName.equals("password")) {
                    String str = new String(ch, start, length);
                    if(str.trim().equals(password))
                        this.foundPassword = true;
                }
            }
            if(foundPassword) {
                if(this.currentTagName.equals("status")) {
                    String str = new String(ch, start, length);
                    if(!str.trim().equals("dropout")) {
                        this.found = true;
                    }
                }
            }
        }
    }

    public boolean isFound() {
        return found;
    }

    public String getFullname() {
        return fullname;
    }
    
}
