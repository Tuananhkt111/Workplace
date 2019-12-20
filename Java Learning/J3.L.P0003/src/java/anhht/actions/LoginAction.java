/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.account.AccountDAO;
import anhht.account.AccountDTO;
import anhht.role.RoleDAO;
import anhht.utils.MyUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author tuana
 */
@ResultPath("/")
@Results({
    @Result(name = "error", location = "login.jsp")
    ,
    @Result(name = "admin", location = "SearchAction", type = "redirectAction")
    ,
    @Result(name = "user", location = "SearchAction", type = "redirectAction")})
public class LoginAction {

    private static final Logger LOGGER = Logger.getLogger(LoginAction.class);
    private String txtEmail, txtPassword;
    private String msg;

    public LoginAction() {
    }

    @Action("LoginAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    txtPassword.getBytes(StandardCharsets.UTF_8));
            String passwordHash = MyUtils.bytesToHex(encodedhash);
            AccountDAO dao = new AccountDAO();
            AccountDTO dto = dao.checkLogin(txtEmail, passwordHash);
            if (dto != null) {
                RoleDAO rDAO = new RoleDAO();
                String role = rDAO.loadRoleByID(dto.getRoleID());
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                session.setAttribute("USER", txtEmail);
                session.setAttribute("NAME", dto.getName());
                session.setAttribute("ROLE", role);
                if (role.equals("admin")) {
                    url = "admin";
                } else if(role.equals("user")) {
                    url = "user";
                }
            } else {
                msg = "Invalid Username or Password";
            }
        } catch (NoSuchAlgorithmException | SQLException | NamingException e) {
            LOGGER.error("ERROR at LoginController: " + e.getMessage());
            msg = "ERROR at LoginController";
        }
        return url;
    }

    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
