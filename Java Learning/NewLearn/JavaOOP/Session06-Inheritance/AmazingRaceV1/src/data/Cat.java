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
public class Cat extends Pet {

    public static final double MAX_SPEED = 40.0;
    private String ribbon;

    public Cat(String name, String ribbon, int yob, double weight) {
        super(name, yob, weight);
        this.ribbon = ribbon;
    }

    @Override
    public double run() {
        // cho con mèo chạy tốc độ random
        // khác nhau cho mỗi con
        Random rd = new Random();
        // máy tạo số ngẫu nhiên, chính là object
        // mỗi lần yêu cầu thì sẽ tạo 1 con số thực nằm trong khoảng từ 0.......1
        return MAX_SPEED * rd.nextDouble();
    }

    @Override
    public void showRecord() {
        System.out.printf("|CAT |%-10s|%4d|%4.1f|%3s|%4.1f|\n",
                             name, yob, weight, ribbon, run());
    }

}
