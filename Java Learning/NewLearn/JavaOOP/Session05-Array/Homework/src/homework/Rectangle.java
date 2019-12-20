/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

/**
 *
 * @author Tuan Anh
 */
public class Rectangle {
    private double width;
    private double height;
    private String color;
    private String owner;

    public Rectangle(double width, double height, String color, String owner) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.owner = owner;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public double area() {
        return width*height;
    }
 
    public void showDetail() {
        System.out.printf("Rectangle{width: %-8.2f, height: %-8.2f, color: %-10s, owner: %-10s, area: %-8.2f}\n", width, height, color, owner, area());
    }
    
}
