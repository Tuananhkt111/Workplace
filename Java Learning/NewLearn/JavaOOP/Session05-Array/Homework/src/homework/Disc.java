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
public class Disc {
    private double radius;
    private String color;
    private String owner;

    public Disc(double radius, String color, String owner) {
        this.radius = radius;
        this.color = color;
        this.owner = owner;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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
        return Math.pow(radius, 2)* Math.PI;
    }

    public void showDetail() {
        System.out.printf("Disc{radius: %-8.2f, color: %-10s, owner: %-10s, area: %-8.2f}\n", radius, color, owner, area());
    }
}
