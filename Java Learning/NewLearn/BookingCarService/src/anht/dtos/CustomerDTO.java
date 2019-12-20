/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anht.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author tuana
 */
public class CustomerDTO implements Serializable{
    private String id, password, name, phone, role;
    private boolean sex;
    private int age;

    public CustomerDTO(String id, String password, String name, String phone, boolean sex, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.role = "Customer";
        this.sex = sex;
        this.age = age;
    }

    public CustomerDTO(String id, String password, String name, String phone, String role, boolean sex, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.role = role;
        this.sex = sex;
        this.age = age;
    }

    public CustomerDTO(String id, String password, String role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }   
    
    public String getSex() {
        if(sex) {
            return "Male";
        } else {
            return "Female";
        }
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(id);
        v.add(password);
        v.add(name);
        v.add(getSex());
        v.add(age);        
        v.add(phone);                     
        return v;
    }
}
