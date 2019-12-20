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
public class EmployeeDTO implements Serializable{
    private String id, name, phone;
    private boolean sex, isAvailable;
    private int age, certificate;

    public EmployeeDTO(String id, String name, String phone, boolean sex, boolean isAvailable, int age, int certificate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.isAvailable = isAvailable;
        this.age = age;
        this.certificate = certificate;
    }

    public int getCertificate() {
        return certificate;
    }

    public void setCertificate(int certificate) {
        this.certificate = certificate;
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getAge() {
        return age;
    }
    
    public String getSex() {
        return isSex() == true ? "Male" : "Female";
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(getSex());
        v.add(age);        
        v.add(phone);
        v.add(certificate);
        v.add(isAvailable);        
        return v;
    }
}
