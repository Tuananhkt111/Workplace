/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.daos.RegistrationDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author tuana
 */
public class LoginAction extends ActionSupport {
    private String username, password, role;
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String ERROR = "error";
    public LoginAction() {
    }

    @Override
    public void validate() {
        if(username.length() == 0) {
            addFieldError("username", "Username can't be blank");
        }
        if(password.length() == 0) {
            addFieldError("password", "Password can't be blank");
        }
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        RegistrationDAO dao  = new RegistrationDAO();
        role = dao.checkLogin(username, password);
        HttpServletRequest request = ServletActionContext.getRequest();
        if(role.equals("failed")) {
            request.setAttribute("ERROR", "Invalid username or password");
        } else {
            Map session = ActionContext.getContext().getSession();
            session.put("USER", username);
            if(role.equals("admin")) {
                url = ADMIN;
            } else if(role.equals("user")) {
                url = USER;
            } else {
                request.setAttribute("ERROR", "Your role is not supported");
            }
        }
        return url;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
