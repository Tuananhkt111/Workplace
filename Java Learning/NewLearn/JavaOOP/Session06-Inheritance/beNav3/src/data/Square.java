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
public class Square extends Rectangle {

    public Square(double side, String owner, String color) {
        super(side, side, owner, color);
    }
    
    @Override
    public void paint() {
        System.out.printf("|SQUARE|%-10s|%-10S|%4.1f|%6.2f|\n", owner, color,
                width, getArea());
    }
}
