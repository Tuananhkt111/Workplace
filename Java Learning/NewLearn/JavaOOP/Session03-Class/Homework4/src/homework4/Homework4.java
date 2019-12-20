/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Tuan Anh
 */
public class Homework4 {

    public static double distance(Coordinate p1, Coordinate p2) {
        return sqrt(pow(p1.getX() - p2.getX(), 2) + pow(p1.getY() - p2.getY(), 2));
    }
    public static void main(String[] args) {
        Coordinate a = new Coordinate('A', 1, 2);
        Coordinate b = new Coordinate('B', 1, 6);
        Coordinate c = new Coordinate('C', 2, 4);
        Coordinate d = new Coordinate('D', 7, 3);
        Coordinate e = new Coordinate('E', 9, 1);
        a.inform();
        b.inform();
        c.inform();
        d.inform();
        e.inform();
        System.out.println("Distance between point " + a.getPoint() + " point " + b.getPoint() + " is: " + distance(a, b));
        System.out.println("Distance between point " + a.getPoint() + " point " + b.getPoint() + " is: " + a.distance(b));       
    }
    
}
