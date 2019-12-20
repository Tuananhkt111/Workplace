/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhth.demo;

/**
 *
 * @author Tuan Anh
 */
public class FirstThread implements Runnable {

    @Override
    public void run() {
        System.out.println("This is my child thread!");
    }
    
}
