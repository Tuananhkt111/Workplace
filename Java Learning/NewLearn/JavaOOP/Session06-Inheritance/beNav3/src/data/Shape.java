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
//class co ham abstract thi class bat buoc phai la ABSTRACT
//Cấm new vì new xong lấy code đâu mà chạy
//Ráng new thì ANONYMOUS CLASS
public abstract class Shape {

    protected String owner;
    protected String color;
    //private double radius;
    //private double width; hong chơi những field này nha 
    //vì mìn mún thấy tròn có cạnh, mìn hem mún thấy CN có bán kình
    //do kế thừa từ Shape những gì khác biệt thì để ở con
    //Cha là nhân tử chung của các con

    public Shape(String owner, String color) {
        this.owner = owner;
        this.color = color;
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

    public abstract double getArea();
    
    //Tính S như nào khi kh có cạnh,...
    //Tính thế nào tùy hình cụ thể
    //Việc đó đám con lo
    
    public abstract void paint();
}
