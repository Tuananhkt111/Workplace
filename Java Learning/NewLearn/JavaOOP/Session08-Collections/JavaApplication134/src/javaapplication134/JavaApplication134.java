/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication134;

/**
 *
 * @author Tuan Anh
 */
public class JavaApplication134 {
        public static void main(String[] A) {
            int m=5, n=0;
try{
          m /=n; }

catch (Exception e) {
         System.out.println("AA");
        }

    }
class A {

        int x = 5;
    }

    class B {

        int y = 6;

        public void m(A obj) {
            System.out.print(obj.x + this.y);
        }
    }
