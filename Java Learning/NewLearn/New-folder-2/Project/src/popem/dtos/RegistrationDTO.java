/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.dtos;

import java.io.Serializable;

/**
 *
 * @author popem
 */
public class RegistrationDTO implements Serializable{
    private String username, password;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String username, String password) {
        this.username = username;
        this.password = password;
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
    
    
}
