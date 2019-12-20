/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samurai;

import java.util.Scanner;

/**
 *
 * @author Tuan Anh
 */
public class Samurai {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Nhap nam sinh va dia chi tu ban phim roi in ra
        String address;
        int yob;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input yob: ");
                yob = Integer.parseInt(sc.nextLine()); //thang ca chon neu nhap ahihi
                break;
            } catch (Exception e) {
                //e dc new boi Java khi co ca chon xay ra, chua thong tin ve error
                //da co, Java trao quyen giet app hay di tiep cho dev o day
                System.out.println("Do u know how to input integer?");
                yob = 69; //xu li default
            }
            
        }
        System.out.println("Input address: ");
        address = sc.nextLine();
        System.out.println("Your profile: ");
        System.out.println("Address: " + address);
        System.out.println("Yob: " + yob);
    }

}
