/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.util.Scanner;

/**
 *
 * @author tuana
 */
public class JavaApplication15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        String sc = s.nextLine();
        if(sc.matches("(((\\d{3}\\-){2}\\d{4}\\s{1}(x|ext)\\d{4})|((\\d{3}[\\-\\s\\.]?){2}\\d{4})|(\\(\\d{3}\\)(\\-\\d{3}){2}\\d))")) {
            System.out.println("ngon");
        }
        else System.out.println("rip");
    }
    
}
