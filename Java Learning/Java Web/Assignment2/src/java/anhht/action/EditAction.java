/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.action;

import anhht.dao.AccessoryDAO;
import anhht.dto.AccessoryDTO;
import anhht.dto.AccessoryErrorObject;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author tuana
 */
public class EditAction {

    private String id;
    private AccessoryDTO dto;
    private String searchValue;
    private AccessoryErrorObject errorObj;
    private static final String SUCCESS = "success";

    public EditAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        errorObj = (AccessoryErrorObject) req.getAttribute("INVALID");
        AccessoryDAO dao = new AccessoryDAO();
        dto = dao.findByPrimaryKey(id);
        return SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccessoryErrorObject getErrorObj() {
        return errorObj;
    }

    public void setErrorObj(AccessoryErrorObject errorObj) {
        this.errorObj = errorObj;
    }

    public AccessoryDTO getDto() {
        return dto;
    }

    public void setDto(AccessoryDTO dto) {
        this.dto = dto;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

}
