/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6;

import data.MyStack;

/**
 *
 * @author Nguyen Quang Huy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyStack st1 = new MyStack();
        st1.push(12);
        st1.push(12);
        st1.push(1);
        st1.push(14);
        st1.push(23);
        st1.push(6);
        MyStack st2 = st1.transfer();
        while (!st2.isEmpty()) {            
            System.out.print(st2.pop() + " ");
        }
        System.out.println("");
        
        st1.push(15);
        st1.push(12);
        st1.push(1);
        st1.push(14);
        st2 = st1.transfer1();
        while (!st2.isEmpty()) {            
            System.out.print(st2.pop() + " ");
        }
    }
    
}
