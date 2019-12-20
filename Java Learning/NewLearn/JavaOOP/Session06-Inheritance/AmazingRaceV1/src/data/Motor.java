/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;

/**
 *
 * @author Admin
 */
// hem cho nó kế thừa Pet, vì xe máy ko thể là thú cưng
//dau phay phan cach ca CLB, Cong ket noi interface ma ban du dinh tham gia 
//la thanh vien cua...
public class Motor implements DeadRacer{
    public static final double MAX_SPEED = 120.0;
    private String model; //EX, AB, RGV
    private String vin; // số xe, số khung ....
    private int mDate; // năm sản xuáta
    private double volumn; // phân khối
    
    //nếu có kế thừa thì nó phải là Vehicle, Phương tiện giao thông

    public Motor(String model, String vin, int mDate, double volumn) {
        this.model = model;
        this.vin = vin;
        this.mDate = mDate;
        this.volumn = volumn;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getmDate() {
        return mDate;
    }

    public void setmDate(int mDate) {
        this.mDate = mDate;
    }

    public double getVolumn() {
        return volumn;
    }

    public void setVolumn(double volumn) {
        this.volumn = volumn;
    }

    @Override
    public String toString() {
        return "Motor{" + "model=" + model + ", vin=" + vin + ", mDate=" + mDate + ", volumn=" + volumn + '}';
    }
    public double run(){
        Random rd = new Random();
        return MAX_SPEED * rd.nextDouble();
    }
    
    public void showRecord(){
        System.out.printf("|CAT |%-10s|%-11s|%4d|%4.1f|%4.1f|\n",
                             model, vin, mDate, volumn, run());
    }

    @Override
    public double runToDead() {
        return run() * 2; //chay gac kim dong ho
    }

    @Override
    public void showHowToDead() {
        System.out.printf("|MOTOR-AHUHU|%-10s|%-11s|%4d|%4.1f|%4.1f|\n",
                             model, vin, mDate, volumn, runToDead());
    }
}
