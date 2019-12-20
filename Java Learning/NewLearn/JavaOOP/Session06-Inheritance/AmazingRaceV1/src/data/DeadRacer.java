/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Tuan Anh
 */
//day la hoi nhom, tu tap nhung ke chung li tuong, hanh dong
//la 1 class Cha dac biet, chi gom chung hanh dong, ko care ve dac diem
//ko can quan tam pheu, constructor
//no la 1 dang abstract class, vi la tu tap thi moi dua tu choi theo cach cua minh
//mien la choi, do do cac hanh vi trong class la abstract
public interface DeadRacer {
    public double runToDead(); //ko can keyword abstract (default)
    public void showHowToDead(); //in ra thanh tich dua cua moi dua thu
                                   //moi dua thu phai IMPLEMENT cho ham abstract o interface
    //constructor tao ngam, mot constructor rong/default (TBA)
}
