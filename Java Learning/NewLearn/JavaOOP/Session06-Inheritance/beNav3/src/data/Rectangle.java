/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Hoang Dung
 */
public class Rectangle extends Shape{
    protected double width;
    protected double length;

    public Rectangle(double width, double length, String owner, String color) {
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
    public double getArea() {
        return width * length;
    }

    @Override
    public void paint() {
        System.out.printf("|RECT |%-10s|%-10S|%4.1f|%4.1f|%6.2f|\n", owner, color,
                width, length, getArea());
    }
        
}
