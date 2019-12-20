/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunkunn.util;

import java.util.Scanner;

/**
 *
 * @author Tuan Anh
 */
public class MyToys {
    //trong class nay se luu tru, chua dung nhung do xai chug, dung chung cho moi thu
    // moi viec, moi object
    //do dung chung nen ta se dat cac dac tinh va hanh vi nay la static
    //vi static, xai chung, nen se chang can luu rieng cho tung obj ne ta cung 
    // chang can do pheu lam gi, ko can pheu
    //ham nay se tra ve mot con so nguyen nhap tu ban phim
    // chong troi lenh
    //chui neu ca chon
    //ham nay xai o nhieu noi, va vi la ham static nen ko can phai new, xai truc tiep qua ten class
    private static Scanner sc = new Scanner(System.in); //khai bao bien va gan value, duoc truyen
    public static int getAnInteger(String msg) {
        int n; //bien de luu con n tam nhap
        while(true) {
            try {
                System.out.println(msg);
                n = Integer.parseInt(sc.nextLine()); //chong troi lenh
                return n; //nhap dung thi tra ve va thoat vong lap
            } catch (Exception e) {
                System.out.println("Input type is INTEGER");
            }
        }
    }
}
