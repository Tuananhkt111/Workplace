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
public class RightTriangle extends Triangle{

    public RightTriangle(double edge1, double edge2, String owner, String color) {
        super(edge1, edge2, Math.sqrt(Math.pow(edge1, 2) + Math.pow(edge2, 2)),owner, color);
    }    
    @Override
    public void paint(){
    
        System.out.printf("|R.TRIANG|%-10s|%-10S|%4.1f|%4.1f|%6.2f|\n", owner, color,
                            edge1, edge2, getArea());
    }
}
