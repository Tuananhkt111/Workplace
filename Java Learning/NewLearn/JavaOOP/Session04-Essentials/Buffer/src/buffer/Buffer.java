/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

import java.util.Scanner;

/**
 *
 * @author Tuan Anh
 */
public class Buffer {
    public static void main(String[] args) {
        //viet app nhap thong tin ca nhan: ten, nam sinh, dia chi
        String name, address;
        int yob;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name: ");
        name = sc.nextLine();
        System.out.println("Input yob: ");     
        //yob = sc.nextInt();
        //ADP's solution, loi dung lenh nextLine() hot sach buffer t goi 1 lenh chay khong de xoa bo dem
        //sc.nextLine();
        //chinh dao's solution: xai 1 ham static cua class Integer, ham nay se lam chuc nang y chang ham nextInt()
        //tuc la convert String thanh number
        //ham nay khac ham nextInt() o cho nextInt() vao buffer lay chuoi de lai rac 
        //ham nay thi ko vao buffer, ma cho ai do dua chuoi de convert
        yob = Integer.parseInt(sc.nextLine()); //cau lenh phuc hop
        System.out.println("Input address: ");
        address = sc.nextLine();
        System.out.println("Here is your profile");
        System.out.println("Name: " + name);
        System.out.println("Yob: " + yob);
        System.out.println("Address: " + address);
    }
    
}
