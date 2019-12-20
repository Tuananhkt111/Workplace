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
public class Rectangle {
    protected String color;
    protected String owner;
    protected double width;
    protected double height;

    public Rectangle(String color, String owner, double width, double height) {
        this.color = color;
        this.owner = owner;
        this.width = width;
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

    @Override
    public String toString() {
        return "Rectangle{" + "color=" + color + ", owner=" + owner + ", width=" + width + ", height=" + height + '}';
    }
    public double getArea()
    {
        return width*height;
    }
    public void paint()
    {
        System.out.printf("|RECT  |%-10s|%-10s|%4.1f|%4.1f|%6.2f|\n",
                owner, color, width, height, getArea());
    }
}
