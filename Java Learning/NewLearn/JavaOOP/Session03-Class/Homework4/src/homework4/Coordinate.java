/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Coordinate {
    private char point;
    private double x;
    private double y;
    public Coordinate(char point, double x, double y) {
        this.point = point;
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public char getPoint() {
        return point;
    }   
    public void inform() {
        System.out.println("Point " + point + " has coordinate (x,y) = (" + x + ", " + y + ")");
    }
    public double distance(Coordinate p) {
        return sqrt(pow(this.getY() - p.getY(), 2) + pow(this.getX() - p.getX(), 2));
    }
}
