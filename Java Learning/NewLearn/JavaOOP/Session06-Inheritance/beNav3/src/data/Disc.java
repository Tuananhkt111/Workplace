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
public class Disc extends Shape {
    protected double radius;
    public Disc(double radius, String owner, String color) {
        super(owner, color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public void paint() {
        System.out.printf("|DISK    |%-10s|%-10S|%4.1f|%6.2f|\n", owner, color,
                            radius, getArea());
    }
}
