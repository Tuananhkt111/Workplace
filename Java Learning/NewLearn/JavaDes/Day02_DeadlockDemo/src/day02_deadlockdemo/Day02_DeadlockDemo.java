/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02_deadlockdemo;

import anht.demo.Money;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan Anh
 */
public class Day02_DeadlockDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Money person1 = new Money();
        Money person2 = new Money();

        person1.money = person2;
        person2.money = person1;
        Thread t1 = new Thread(person1);
        Thread t2 = new Thread(person2);

        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Day02_DeadlockDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
