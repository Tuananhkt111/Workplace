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
public class SearchErrorObject implements Serializable {
    private String minMaxError;

    public SearchErrorObject() {
    }

    public String getMinMaxError() {
        return minMaxError;
    }

    public void setMinMaxError(String minMaxError) {
        this.minMaxError = minMaxError;
    }
    
}