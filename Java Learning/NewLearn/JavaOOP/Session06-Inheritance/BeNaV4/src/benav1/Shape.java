/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benav1;

/**
 *
 * @author Admin
 */
//class có abstract thì class BẮT BUỘC PHẢI LÀ ABSTRACT
// CẤM NEW NHEN, vì NEW xong lấy code đâu trong hàm mà chạy
//RÁNG NEW THÌ -> .....
public abstract class Shape {
    protected String owner;
    protected String color;
    //Cha là nhân tử trong cho các Con

    public Shape(String owner, String color) {
        this.owner = owner;
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();
    
    public abstract void paint();
}

