/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author tuana
 */
public class CustForm extends org.apache.struts.action.ActionForm {
    
    private String name, fullname;
    

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
    }

    public String getFullname() {
        return fullname;
    }

    /**
     * @return
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     *
     */
    public CustForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */

}
