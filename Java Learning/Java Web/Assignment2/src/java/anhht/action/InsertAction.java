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
public class InsertAction {

    private String id, name, brand, description;
    private float price;
    private boolean isDelete;
    private AccessoryDTO dto;
    private AccessoryErrorObject errorObj;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private static final String INVALID = "invalid";

    public InsertAction() {
    }

    public String execute() throws Exception {
        errorObj = new AccessoryErrorObject();
        boolean valid = true;
        if (id.length() == 0) {
            errorObj.setIdError("Id cannot be blank");
            valid = false;
        } else {
            AccessoryDAO dao = new AccessoryDAO();
            dto = dao.findByPrimaryKey(id);
            if (dto != null) {
                errorObj.setIdError("Id existed");
                valid = false;
            }
        }
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
            if (dao.insert(dto)) {
                return SUCCESS;
            } else {
                HttpServletRequest req = ServletActionContext.getRequest();
                req.setAttribute("ERROR", "Insert failed.");
                return FAIL;
            }
        } else {
            return INVALID;
        }
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

    public boolean getDefaultIsDeleteListValue() {
        return true;
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

}
