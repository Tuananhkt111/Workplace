/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Admin
 */
public abstract class Pet {
    protected String name;
    protected int yob;
    protected double weight;

    public Pet(String name, int yob, double weight) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    // phàm đã là thú thì biết chạy, vấn đề chạy kiểu nào cũng tùy từng Con
    // nhưng đều gọi chung là chạy, vậy chạy là abstract;
    
    
    //in bảng thành tích cùng là abstract vì mỗi cháu thí sinh có thể có
    // các thông tin in ra khác nhau. do cách lấy thành tích khác nhau
    public abstract double run();
    public abstract void showRecord();
}
