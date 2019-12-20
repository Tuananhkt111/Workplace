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
public class Rectangle extends Shape{

    protected double width;
    protected double length;

    public Rectangle(String owner, String color, double width, double length) {
        super(owner, color);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "width=" + width + ", length=" + length + '}';
    }
    
    @Override
    public double getArea(){
        return width * length;
    }
    
    @Override
    public void paint(){
        System.out.printf("|RECT     |%-10s|%-10s|%4.1f|%4.1f|%6.2f|\n", owner,
                color, width, length, getArea());
    }
}