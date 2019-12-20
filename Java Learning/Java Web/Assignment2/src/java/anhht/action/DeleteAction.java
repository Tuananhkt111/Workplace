/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.action;

import anhht.dao.AccessoryDAO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author tuana
 */
public class DeleteAction {

    private String id;
    private String searchValue;
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    public DeleteAction() {
    }

    public String execute() throws Exception {
        AccessoryDAO dao = new AccessoryDAO();
        if (dao.delete(id)) {
            return SUCCESS;
        } else {
            HttpServletRequest req = ServletActionContext.getRequest();
            req.setAttribute("ERROR", "Delete failed.");
            return ERROR;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

}
