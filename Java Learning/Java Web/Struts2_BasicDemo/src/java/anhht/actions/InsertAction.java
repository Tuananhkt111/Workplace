/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.daos.RegistrationDAO;
import anhht.dtos.RegistrationDTO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author tuana
 */
public class InsertAction extends ActionSupport {
    private String username, password, confirm, emailID, phoneNo;
    public InsertAction() {
    }
    
    public String execute() throws Exception {
        RegistrationDTO dto = new RegistrationDTO(username, emailID, phoneNo);
        dto.setPassword(password);
        RegistrationDAO dao = new RegistrationDAO();
        if(dao.insert(dto)) {
            return "success";
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Insert failed");
            return "fail";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
}
