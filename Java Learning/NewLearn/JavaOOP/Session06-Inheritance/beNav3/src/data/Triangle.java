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
public class Triangle extends Shape{
    protected double edge1;
    protected double edge2;
    protected double edge3;
    public Triangle(double edge1, double edge2, double edge3, String owner, String color) {
        super(owner, color);
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
    }

    public double getEdge1() {
        return edge1;
    }

    public void setEdge1(double edge1) {
        this.edge1 = edge1;
    }

    public double getEdge2() {
        return edge2;
    }

    public void setEdge2(double edge2) {
        this.edge2 = edge2;
    }

    public double getEdge3() {
        return edge3;
    }

    public void setEdge3(double edge3) {
        this.edge3 = edge3;
    }

    public double getPerimeter(){
        return (edge1 + edge2 + edge3)/2;
    }
    
    @Override
    public double getArea() {
        double p = getPerimeter();
        double tmp = p*(p - edge1)*(p - edge2)*(p - edge3);
        return Math.sqrt(tmp);
    }

    @Override
    public void paint() {
        System.out.printf("|TRIANGLE|%-10s|%-10S|%4.1f|%4.1f|%4.1f|%6.2f|\n", owner, color,
                            edge1, edge2, edge3, getArea());
}
}