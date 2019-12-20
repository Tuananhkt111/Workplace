/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.daos.NewsDAO;
import anhht.dtos.NewsDTO;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author popemkt
 */

public class AddNewsAction extends ActionSupport {
    private String id, title, shortDes, des, author, msg;
    private boolean isApproved;
    public AddNewsAction() {
    }
    
    public String execute() throws Exception {
        NewsDTO dto = new NewsDTO(id, title, shortDes, des, author, isApproved);
        NewsDAO dao = new NewsDAO();
        if(dao.insert(dto)) {
            msg = "SUCCESS";
            return "success";
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Add news failed");
            return "fail";
        }
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

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
