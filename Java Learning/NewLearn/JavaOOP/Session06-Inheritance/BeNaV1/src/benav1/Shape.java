/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benav1;

/**
 *
 * @author Tuan Anh
 */
public abstract class Shape {
    private String owner;
    private String color;
    //private double radius;
    //private double width; //hok choi nhung field nay nhen vi minh hok
    //mun thay Tron co canh, minh hok mun thay CN co bk do ke thua tu Shape
    //nhung gi khac biet thi de o Con
    //Cha la nhan tu chung cua cac con

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
    abstract public double getArea(); //tinh S sao khi khong co canh, bk, thong tin\
                                    //mun thay Tron co canh, mnih hok mun thay CN co bk do ke thua tu Shape
    //nhung gi khac biet thi de o Con 
}
