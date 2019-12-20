/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_practical;

import data.SingleLinkedList;
import java.util.Scanner;

/**
 *
 * @author tuana
 */
public class CSD_Practical {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SingleLinkedList sll = new SingleLinkedList();
        String cont;
        Scanner sc = new Scanner(System.in);
        do {
            int temp;
            System.out.println("Enter next node:");
            temp = sc.nextInt();
            sll.add(temp);
            sc.nextLine();
            System.out.print("Press Y if you want to add more, press any others keys if you want to cancel: ");
            cont = sc.nextLine();
        } while(cont.equalsIgnoreCase("Y"));
        System.out.println("The smallest positive number missing in the list: " + sll.findSmallest());
        System.out.println("Is sorted: " + sll.isSorted());
        System.out.println("The list before removing duplicated: ");
        sll.traverse();
        sll.removeDuplicates();
        System.out.print("The list after removing duplicated: ");
        sll.traverse();
    }
    
}
