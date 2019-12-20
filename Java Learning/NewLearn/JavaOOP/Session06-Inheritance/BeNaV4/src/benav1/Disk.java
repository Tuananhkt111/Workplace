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
public class Disk extends Shape{
    public static final double PI = 3.14;
    private double radius;

    public Disk(String owner, String color, double radius ) {
        super(owner, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    

    @Override
    public String toString() {
        return "Disk{" + "owner=" + owner + ", color=" + color + ", radius=" + radius + '}';
    }
    
    @Override
    public double getArea(){
        return PI * Math.pow(radius, 2);
    }
    
    @Override
    public void paint(){
        System.out.printf("|DISK   |%-10s|%-10s|%4.1f|%6.2f|\n", owner,
                color, radius, getArea());
    }
}
