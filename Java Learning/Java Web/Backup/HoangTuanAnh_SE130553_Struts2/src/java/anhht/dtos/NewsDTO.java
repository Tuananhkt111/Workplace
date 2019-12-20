/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author popemkt
 */
public class NewsDTO implements Serializable {
    private String id, title, shortDes, des, author;
    private Date timeOfCreate;
    private boolean isApproved;

    public NewsDTO(String id, String title, String shortDes, String des, String author, boolean isApproved) {
        this.id = id;
        this.title = title;
        this.shortDes = shortDes;
        this.des = des;
        this.author = author;
        this.isApproved = isApproved;
        this.timeOfCreate = new Date();
    }

    public NewsDTO(String id, String title, String shortDes, String des, String author, Date timeOfCreate, boolean isApproved) {
        this.id = id;
        this.title = title;
        this.shortDes = shortDes;
        this.des = des;
        this.author = author;
        this.timeOfCreate = timeOfCreate;
        this.isApproved = isApproved;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTimeOfCreate() {
        return timeOfCreate;
    }

    public void setTimeOfCreate(Date timeOfCreate) {
        this.timeOfCreate = timeOfCreate;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
    
}
