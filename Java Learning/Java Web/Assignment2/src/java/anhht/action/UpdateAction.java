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
public class UpdateAction {

    private String id, name, brand, description, searchValue;
    private float price;
    private boolean isDelete;
    private AccessoryDTO dto;
    private AccessoryErrorObject errorObj;
    private static final String FAIL = "fail";
    private static final String SUCCESS = "success";
    private static final String INVALID = "invalid";
    private static final String ASSS = "a";

    public UpdateAction() {
    }

    public String execute() throws Exception {
        boolean valid = true;
        errorObj = new AccessoryErrorObject();
        if (name.length() == 0) {
            errorObj.setNameError("Name cannot be blank");
            valid = false;
        }
        if (brand.length() == 0) {
            errorObj.setBrandError("Brand cannot be blank");
            valid = false;
        }
        if (description.length() == 0) {
            errorObj.setDesError("Description cannot be blank");
            valid = false;
        }
        if (valid) {
            AccessoryDAO dao = new AccessoryDAO();
            dto = new AccessoryDTO(id, name, brand, description, price, isDelete);
            if (dao.update(dto)) {
                return SUCCESS;
            } else {
                HttpServletRequest req = ServletActionContext.getRequest();
                req.setAttribute("ERROR", "Update failed");
                return FAIL;
            }
        } else {
            return ASSS;
//            HttpServletRequest req = ServletActionContext.getRequest();
//            req.setAttribute("INVALID", errorObj);
//            return INVALID;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public AccessoryDTO getDto() {
        return dto;
    }

    public void setDto(AccessoryDTO dto) {
        this.dto = dto;
    }

    public AccessoryErrorObject getErrorObj() {
        return errorObj;
    }

    public void setErrorObj(AccessoryErrorObject errorObj) {
        this.errorObj = errorObj;
    }

}
