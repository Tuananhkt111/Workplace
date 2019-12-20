/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import java.util.Scanner;

/**
 *
 * @author Tuan Anh
 */
public class Homework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Enter value of n:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Sum of even numbers from 1 to " + n + ": " + sumEven(n));
        System.out.println("Amount of even numbers from 1 to " + n + ": " + countEven(n));
        if(checkPrime(n) == true)
            System.out.println(n + " is prime");
        else System.out.println(n + " is not prime");
        System.out.println("Factorial of " + n + ": " + factorial(n));
    }
    public static int sumEven(int n){
        int s = 0;
        for (int i = 1; i <= n; i++) 
            if(i % 2 == 0)
                s += i;
        return s;
    }
    public static int countEven(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) 
            if(i % 2 == 0)
                s += 1;
        return s;
    }
    public static boolean checkPrime(int n){ 
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    public static long factorial(int n){
        long s = 1;
        for (int i = 1; i <= n; i++) 
                s *= i;
        return s;
    }
}
