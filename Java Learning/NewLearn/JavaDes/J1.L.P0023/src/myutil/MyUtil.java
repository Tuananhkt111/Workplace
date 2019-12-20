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
    Scanner sc = new Scanner(System.in);
    public String getStringFormat(String msg, String format, String error) {
        String result = null;
        while (true) {
            System.out.println(msg);
            result = sc.nextLine().trim();
            if (!result.matches(format)) {
                System.out.println(error);
            } else {
                return result;
            }
        }
    }
    
    public String getString(String msg, String error) {
        String result = null;
        while (true) {
            System.out.println(msg);
            result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println(error);
            } else {
                return result;
            }
        }
    }
    
    public String getYesOrNo(String msg) {
        String result = null;
        while (true) {
            System.out.println(msg);
            result = sc.nextLine().trim();
            if (!result.equalsIgnoreCase("Y") && !result.equalsIgnoreCase("N")) {
                System.out.println("Y/N only");
            } else {
                return result;
            }
        }
    }
    
    public int getPositiveInt(String msg, String warning, String error) {
        int result;
        while(true) {
            try {
                System.out.println(msg);
                result = Integer.parseInt(sc.nextLine());
                if(result > 0) {
                    return result;
                } else {
                    System.out.println(warning);
                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }
    
    public int getChoice(String msg, String error, int maxChoice) {
        int result;
        while(true) {
            try {
                System.out.println(msg);
                result = Integer.parseInt(sc.nextLine());
                if(result >= 1 && result <= maxChoice) {
                    return result;
                } else {
                    System.out.println(error);
                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }
}
