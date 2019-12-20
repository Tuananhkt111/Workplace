/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3;

import static java.lang.Math.pow;

public class Circle {
    private int serial;
    private double radius;
    private double area;
    public Circle(int serial, double radius) {
        this.serial = serial;
        this.radius = radius;
    }
    public double getArea() {
        area = pow(radius, 2)*Math.PI;
        return area;
    }

    public int getSerial() {
        return serial;
    }
    
}
