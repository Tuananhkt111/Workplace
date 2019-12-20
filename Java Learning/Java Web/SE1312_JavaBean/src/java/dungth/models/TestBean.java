/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.models;

import dungth.dao.RegistrationDAO;
import java.io.Serializable;

/**
 *
 * @author Hoang Dung
 */
public class TestBean implements Serializable{
    private String username, password;

    public TestBean() {
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
    
    public String checkLogin() throws Exception{
        //co the truyen tham so neu muon
        //nhan u va p, du lieu da co san trong bean, khong can truyen
        //1 so framework cu khong chap nhan truyen tham so
        RegistrationDAO dao = new RegistrationDAO();
        return dao.checkLogin(username, password);
    }
}
