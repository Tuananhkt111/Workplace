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
public class RoundTriangle extends Shape {

    private double a;
    private double b;
    private double c;

    public RoundTriangle(String owner, String color, double a, double b) {
        super(owner, color);
        this.a = a;
        this.b = b;
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
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    @Override
    public void paint() {
        System.out.printf("|RTriangle|%-10s|%-10s|%4.1f|%4.1f|%4.1f|%6.2f|\n", owner,
                color, a, b, getC(), getArea());
    }

    @Override
    public double getArea() {
        return (a * b)/2;
    }
}
