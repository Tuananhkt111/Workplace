/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01_threaddemo;

import anhth.demo.FirstThread;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan Anh
 */
public class Day01_ThreadDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main");
        FirstThread threadObj = new FirstThread();
        Thread t1 = new Thread(threadObj);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Day01_ThreadDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("End");
    }
    
}
