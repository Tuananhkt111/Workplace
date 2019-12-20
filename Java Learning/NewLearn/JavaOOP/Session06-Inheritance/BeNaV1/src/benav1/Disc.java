/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benav1;

/**
 *
 * @author Tuan Anh
 */
public class Disc {
    public static final double PI = 3.14;
    //public: be mian() choi ngoai class Disc so Pi truc tiep khong can get()
    //static: so ma khong can new, Dsik.PI
    //final: bien hang, 1 bien, 1 vung ram khong cho thay doi value tru luc khai bao
    //Quy uoc ten hang chu hoa toan tap, shift gach chan phan cach ca phan tu
    private String owner;
    private String color;
    private double radius;

    public Disc(String owner, String color, double radius) {
        this.owner = owner;
        this.color = color;
        this.radius = radius;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Disc{" + "owner=" + owner + ", color=" + color + ", radius=" + radius + '}';
    }
    
    public double getArea() {
        //return 3.14 *r*r;
        return Math.PI*radius*radius;
    }
    public void paint()
    {
        System.out.printf("|DISC|%-10s|%-10s|%4.1f|%6.2f|\n", owner, color, radius, getArea());
    }
}
