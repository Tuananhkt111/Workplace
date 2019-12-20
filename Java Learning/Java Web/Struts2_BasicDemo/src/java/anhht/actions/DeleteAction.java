/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.daos.RegistrationDAO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author tuana
 */
public class DeleteAction {
    private String id, lastSearchValue;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    public DeleteAction() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        if(dao.delete(id)) {
            return SUCCESS;
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Delete Failed");
            return ERROR;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
}
