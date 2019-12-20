/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.util;

/**
 *
 * @author tuana
 */
public class MyToys {

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Can not divivde by 0");
        } else {
            return a / b;
        }
    }

    public static int computeFactorial(int n) {
//        if(n < 0) {
//            throw new IllegalArgumentException("Invalid number");
//        } else if(n == 0 || n == 1) {
//            return 1;
//        } 
//        return n * computeFactorial(n - 1);
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number");
        } else {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }
}
