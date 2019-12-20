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
public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private int dob;
    private double weight; //gia tien: int

    public Student(String id, String name, int dob, double weight) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void showDetails() {
        System.out.printf("|%-8s|%-20s|%4d|%4.1f|\n", id, name, dob, weight);
    }
    //ta chi cho ham sort() biet cach so sanh 2 sv
    //mun so sanh obj phai cham vao trong vung new
    //ko duoc so sanh hai bien con tro
    //vay so sanh 2 obj la phai lam ham trong vung new de lay duoc data
    //co 1 ham soSanhVoi(dua con tro vung new Student khac, goi la ban that) 
    //la ta biet 2 sv this so voi that
    public int soSanhVoi(Student that) {
        return this.id.compareToIgnoreCase(that.id);
//        if(this.id.compareToIgnoreCase(that.id) > 0) {
//            return 1; //tui lon hon ban
//        }
//        else if(this.id.equalsIgnoreCase(that.id)) {
//            return 0; //tui bang ban
//        }
//        else return -1;
    }
    @Override
    public int compareTo(Student t) {
        //return this.id.compareToIgnoreCase(t.id);
        //sort theo nam ma van hoi compareTo()
//        if(this.dob < t.dob)
//            return -1;
//        else if(this.dob > t.dob)
//            return 1;
//        else return 0;
    return this.dob - t.dob;
    //phai xai Double.compare(so1, so2) neu so sanh double
    }
    //neu tui muon sort theo nam sinh, can nang, tui phai sua lai code
    //cua ham compareTo()
    //hi sinh viec sort truoc
    //neu xai app co menu, co show list theo nhieu goc: id, name, yob
    //khong the thoa man cung 1 luc nhieu kieu sort ma ko phai sua code
    //day la luc dung Comparator
}
