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
    private String email, name, roleID, password, phone, address;

    public AccountDTO(String email, String name, String roleID, String password, String phone, String address) {
        this.email = email;
        this.name = name;
        this.roleID = roleID;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

 
    public AccountDTO(String email, String name, String roleID, String password) {
        this.email = email;
        this.name = name;
        this.roleID = roleID;
        this.password = password;
    }

    public AccountDTO() {
    }
    
}
