/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazingracev1;

import data.*;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class AmazingRaceV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dog chiHu = new Dog("chi Hu Hu", 2018, 0.5);
        //chiHu. show ra racer thoi, thieu ham cua Dog run(), showRecord(), tu tu se hoc
        DeadRacer ex = new Motor("Exciter", "58F8-2204", 2016, 125.5);
        //ex va chiHu o chung mang racer, vi chung minh cunng la dua thu
        //vi dieu
        //Mi nhan ngu cua CTT 2014 bong nhien thay dua vui, dat vao kenhNhieu Loc dua cung
        //het suc luu y: ho nha Mermaid thi ko di dua, ho nha NNN di an thit thuy thu
        //BTVN 1:
        //viet doan code nay ra giay rieng
        DeadRacer MNN = new DeadRacer() {
            @Override
            public double runToDead() {
                double MAX_SPEED = 40;
                Random rd = new Random();
                return MAX_SPEED * rd.nextDouble();
            }
            @Override
            public void showHowToDead() {
                System.out.printf("|MNN  |%4.1f|\n", runToDead());
            }
        };
        //BTVN 2:
        //gg search java collection framework -> Images -> chon hinh ma chu MAP
        //ve, in ra giay
        //BTVN 3:
        //chuan bi giay va but kt 5p
    }
}
