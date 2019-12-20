/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.dto;

import java.io.Serializable;

/**
 *
 * @author tuana
 */
public class AccessoryErrorObject implements Serializable {
    private String idError, nameError, brandError, desError, priceError, isDeleteError;

    public AccessoryErrorObject() {
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getBrandError() {
        return brandError;
    }

    public void setBrandError(String brandError) {
        this.brandError = brandError;
    }

    public String getDesError() {
        return desError;
    }

    public void setDesError(String desError) {
        this.desError = desError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getIsDeleteError() {
        return isDeleteError;
    }

    public void setIsDeleteError(String isDeleteError) {
        this.isDeleteError = isDeleteError;
    }
    
}
