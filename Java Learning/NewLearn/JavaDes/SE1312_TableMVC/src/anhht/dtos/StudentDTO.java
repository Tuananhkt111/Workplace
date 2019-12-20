/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author tuana
 */
public class StudentDTO implements Serializable{
    private String id;
    private String name;
    private String gender;
    private float mark;

    public StudentDTO(String id, String name, String gender, float mark) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.mark = mark;
    }

    public StudentDTO() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(gender);
        v.add(mark);
        return v;
    }
}
