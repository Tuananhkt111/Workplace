/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.util.Scanner;

/**
 *
 * @author Tuan Anh
 */
public class Homework2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("1", "Hoang Tuan Anh", "0913202392", "cu@gmail.com", 2000000);
        acc1.deposit(200000);
        System.out.println("Balance:" + acc1.getBalance());
        acc1.withdraw(1000000000);
        System.out.println("Balance:" + acc1.getBalance());
        BankAccount acc2 = new BankAccount("2", "Cu Ba", "097326846283", "Cuba@gmail.com", 10000000);
        acc2.deposit(200000);
        System.out.println("Balance:" + acc2.getBalance());
        acc2.withdraw(1000000000);
        System.out.println("Balance:" + acc2.getBalance());
    }
}
