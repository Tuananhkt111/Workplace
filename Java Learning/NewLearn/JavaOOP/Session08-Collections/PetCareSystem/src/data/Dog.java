/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Tuan Anh
 */
//mun extends Pet thi tuy, ra nhap hoi dua Racer thi tuy

public class Dog {
    
    private String name;
    private String id;
    private int yob;
    private double weight;

    public Dog(String name, String id, int yob, double weight) {
        this.name = name;
        this.id = id;
        this.yob = yob;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

//    public void setId(String id) {
//        this.id = id;
//    } //ko cho sua ma benh nhan, vi de phong bi trung

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
    public void showDetails() {
        System.out.println("|%8s|%-20s|%|");
    }
}
