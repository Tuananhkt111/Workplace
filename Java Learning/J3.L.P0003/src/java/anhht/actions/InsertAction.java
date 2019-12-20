/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.actions;

import anhht.account.AccountDAO;
import anhht.account.AccountDTO;
import anhht.utils.MyUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.SQLException;
import javax.naming.NamingException;
import org.apache.log4j.Logger;
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
    @Result(name = "error", location = "error.jsp")
    ,
    @Result(name = "success", location = "SearchAction", type = "redirectAction")
    ,
    @Result(name = "failed", location = "InsertUserPageAction", type = "chain")})
public class InsertAction {

    private static final Logger LOGGER = Logger.getLogger(InsertAction.class);
    private String txtEmail, txtUsername, txtPassword, txtPhone, txtAddress, cbRole;
    private String msg;

    public InsertAction() {
    }

    @Action("InsertAction")
    public String execute() throws Exception {
        String url = "error";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    txtPassword.getBytes(StandardCharsets.UTF_8));
            String passwordHash = MyUtils.bytesToHex(encodedhash);
            AccountDAO dao = new AccountDAO();
            AccountDTO dto = new AccountDTO(txtEmail, txtUsername, cbRole, passwordHash, txtPhone, txtAddress);
            if (dao.insert(dto)) {
                msg = "Insert account success";
                url = "success";
            } else {
                msg = "Insert account fail";
                url = "failed";
            }
        } catch (SQLException | NamingException e) {
            if (e.getMessage().contains("duplicate")) {
                msg = "Email existed";
                url = "failed";
            } else {
                LOGGER.error("ERROR at InsertAction: " + e.getMessage());
                msg = "ERROR at InsertAction";
            }
        }
        return url;
    }

    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public String getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public String getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(String txtPhone) {
        this.txtPhone = txtPhone;
    }

    public String getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(String txtAddress) {
        this.txtAddress = txtAddress;
    }

    public String getCbRole() {
        return cbRole;
    }

    public void setCbRole(String cbRole) {
        this.cbRole = cbRole;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
