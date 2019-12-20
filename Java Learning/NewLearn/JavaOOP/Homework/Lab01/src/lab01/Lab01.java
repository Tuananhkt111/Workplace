/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;

import java.util.Scanner;
//standard library input/output
/**
 *
 * @author Tuan Anh
 */
public class Lab01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n; //bien luu gia tri nhap
        Scanner banPhimCuaTui = new Scanner(System.in);
        System.out.print("Input a number: ");
        n = banPhimCuaTui.nextInt();
        boolean result = isPrime(n);
        System.out.println("result: " + result);
        printPrimes(n);
    }
    //nhan vao n tra ve t/f
    public static boolean isPrime(int n) {
        if(n < 2) 
            return false;
        if(n == 2)
            return true;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;
        return true;
    }
    //in ra ca so nguyen to tu 1...n
    public static void printPrimes(int n) {
        if (n < 2) {
            System.out.println("Invalid number! Please >= 2");
            return; //return khong gi ca goi la return void
        }
        System.out.println("The list of primes from 2 to " + n + ":");
        for (int i = 2; i <= n; i++)
            if(isPrime(i) == true)
                System.out.print(i + " ");
        
    }
}
