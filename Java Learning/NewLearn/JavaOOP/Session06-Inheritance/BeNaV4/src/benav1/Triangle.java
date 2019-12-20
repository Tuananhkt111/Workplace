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
public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(String owner, String color, double a, double b, double c) {
        super(owner, color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public void paint() {
        System.out.printf("|Triangle |%-10s|%-10s|%4.1f|%4.1f|%4.1f|%6.2f|\n", owner,
                color, a, b, c, getArea());
    }

    @Override
    public double getArea() {
        double p = ((a + b + c) / 2);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return "Triangle{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
    
    
}
