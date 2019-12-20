/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutil;

import java.util.Scanner;

/**
 *
 * @author tuana
 */
public class MyUtil {
    private Scanner sc = new Scanner(System.in);
    public String getYesOrNo(String msg, String error) {
        String result;
        boolean check;
        do {
            System.out.println(msg);
            result = sc.nextLine().trim();
            check = !result.equalsIgnoreCase("y") && !result.equalsIgnoreCase("n");
            if(check)
                System.out.println(error);
        } while(check);
        return result;
    }
    
    public String getHTMLFile(String msg, String error) {
        String result;
        boolean check;
        do {
            System.out.println(msg);
            result = sc.nextLine().trim();
            check = result.matches(".+\\.html");
            if(!check)
                System.out.println(error);
        } while(!check);
        return result;
    }
}
