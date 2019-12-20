/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dequy;

/**
 *
 * @author tuana
 */
public class Dequy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long a[] = {10, 2, 6, 4, 5};
        System.out.println(factorial(5));
        System.out.println(Fib(6));
        System.out.println(power(2, 5));
        System.out.println(harmonic(5));
        System.out.println(sum(5));
        print4a(4);
        print4b(4);
        System.out.println(intToStr(1001));
        System.out.println(reverse("concu"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(maxElementInArray(a, 5));
    }

    public static long factorial(long n) {
        if (n == 0) {
            return 1;
        } else {
            long result = n * factorial(n - 1);
            return result;
        }
    }

    public static String intToStr(long n) {
        if (n == 0) {
            return "";
        } else {
            return intToStr(n / 10) + Long.toString(n % 10);
        }
    }

    public static String reverse(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        } else {
            return reverse(s.substring(1)) + s.charAt(0);
        }
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }  else {
            return (isPalindrome(s.substring(1, s.length() - 1))) && (s.charAt(0) == s.charAt(s.length() - 1));
        }
    }
    
    public static long maxElementInArray(long a[], int n) {
        if (n == 1) {
            return a[0];
        }  else {
            long temp = maxElementInArray(a, n - 1);
            return temp >= a[n - 1] ? temp : a[n - 1];
        }
    }

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double result = x * power(x, n - 1);
            return result;
        }
    }

    public static long sum(long n) {
        if (n == 0) {
            return 0;
        } else {
            long result = n + sum(n - 1);
            return result;
        }
    }

    public static void print4a(int n) {
        if (n > 2) {
            print4a(n - 1);
            System.out.println(n);
        }
    }

    public static void print4b(int n) {
        if (n > 2) {
            System.out.println(n - 1);
            print4b(n - 1);
        }
    }

    public static double harmonic(long n) {
        if (n == 1) {
            return 1;
        } else {
            double result = (double) 1 / n + harmonic(n - 1);
            return result;
        }
    }

    static long Fib(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long result = Fib(n - 1) + Fib(n - 2);
            return result;
        }
    }

}
