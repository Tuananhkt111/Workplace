/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.account;

import java.io.Serializable;

/**
 *
 * @author tuana
 */
public class AccountDTO implements Serializable {
    private String userID, username, roleID, password, email, phone, address;

    public AccountDTO(String userID, String username, String roleID, String password, String email, String phone, String address) {
        this.userID = userID;
        this.username = username;
        this.roleID = roleID;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountDTO(String userID, String username, String roleID, String password) {
        this.userID = userID;
        this.username = username;
        this.roleID = roleID;
        this.password = password;
    }

    public AccountDTO() {
    }
    
}
