/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueorder1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuana
 */
public class QueueOrder1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                MyQueue st1 = new MyQueue();
        st1.enqueue(12);
        st1.enqueue(1);
        st1.enqueue(14);
        st1.enqueue(23);
        st1.enqueue(6);
        st1.enqueue(34);
        st1.enqueue(7);
        st1.sort();
        while (!st1.isEmpty()) {            
                    try {
                        System.out.print(st1.dequeue() + " ");
                    } catch (Exception ex) {
                        Logger.getLogger(QueueOrder1.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }
    
}
