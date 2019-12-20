/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anht.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan Anh
 */
public class Money implements Runnable{
    public Money money = null;
    int salary = 0;
    public synchronized void changeSalary() {
        System.out.println("Salary = " + salary);
        salary++;
    }
    @Override
    public synchronized void run() {
        while(true) {
            try {
                System.out.println("Salary - run = " + salary);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Money.class.getName()).log(Level.SEVERE, null, ex);
            }
            money.changeSalary();
        }
    }
    
}
