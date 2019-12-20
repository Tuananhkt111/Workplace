/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortascstack;

/**
 *
 * @author tuana
 */
public class SortAscStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyStack st1 = new MyStack();
        st1.push(12);
        st1.push(1);
        st1.push(14);
        st1.push(23);
        st1.push(6);
        st1.sort();
        
        while (!st1.isEmpty()) {            
            System.out.print(st1.pop() + " ");
        }
    }
    
}
