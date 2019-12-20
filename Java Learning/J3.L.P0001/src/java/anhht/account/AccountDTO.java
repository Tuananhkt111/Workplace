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

    private String userID, username, password, email, phone, role, status;
    private byte[] photo;
    private String base64Img;

    public AccountDTO(String userID, String username, String password, String email, String phone, String role, byte[] photo) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.photo = photo;
    }

    public AccountDTO(String userID, String username, String password, String email, String phone, String role, String status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.status = status;
    }

    public AccountDTO(String userID, String username, String password, String email, String phone, String role, String status, byte[] photo) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.status = status;
        this.photo = photo;
    }

    public AccountDTO(String userID, String username, String password, String email, String phone, String role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public AccountDTO(String userID, String username, String email, String phone, String role) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public AccountDTO() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBase64Img() {
        return base64Img;
    }

    public void setBase64Img(String base64Img) {
        this.base64Img = base64Img;
    }

}
