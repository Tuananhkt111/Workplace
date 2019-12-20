/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3;
public class Homework3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle c1 = new Circle(1, 1.5);
        System.out.println("Area of " + c1.getSerial() + ": " + c1.getArea());
        Circle c2 = new Circle(2, 3.12);
        System.out.println("Area of " + c2.getSerial() + ": " + c2.getArea());    
    }
    
}
