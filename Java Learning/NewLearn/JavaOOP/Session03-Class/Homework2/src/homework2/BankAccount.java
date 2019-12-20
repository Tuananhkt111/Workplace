/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 *
 * @author Tuan Anh
 */
public class BankAccount {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private double balance;
    public BankAccount(String id, String name, String phoneNumber, String email, int balance) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = balance;
    }
    public void withdraw(double money) {
        if((balance - money) < 50000)
            System.out.println("You can't withdraw money from account " + name);
        else {
            balance -= money;
            System.out.println("You withdraw successfully.");
        }
    }
    public void deposit(double money) {
        if(money <= 0)
            System.out.println("You can't deposit negative money.");
        else {
            balance += money;
            System.out.println("You deposit successfully.");
        }
    }
    public double getBalance() {
        return balance;
    }    
}
