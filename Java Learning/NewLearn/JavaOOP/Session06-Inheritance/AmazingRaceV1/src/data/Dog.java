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
public class Dog extends Pet implements DeadRacer{
    public static final double MAX_SPEED = 50;

    public Dog(String name, int yob, double weight) {
        super(name, yob, weight);
    }

    @Override
    public double run() {
        Random rd = new Random();
        return MAX_SPEED * rd.nextDouble();
    }

    @Override
    public void showRecord() {
        System.out.printf("|DOG |%-10s|%4d|%4.1f|%4.1f|\n",
                             name, yob, weight, run());
    }

    @Override
    public double runToDead() {
        return run() * 2;
    }

    @Override
    public void showHowToDead() {
        System.out.printf("|DOG-AHUHU |%-10s|%4d|%4.1f|%4.1f|\n",
                             name, yob, weight, runToDead());
    }
    
    
}
