/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicstring;

/**
 *
 * @author Tuan Anh
 */
public class BasicString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String msg1 = new String("Hello");//new truc tiep -> ko xai POOl
        String msg3 = "Hello";
        String msg2 = new String("Hello");
        String msg4 = "Hello"; //gan chuoi truc tiep la luc xai POOL
        //String cung la 1 class, rat db
        //1. msg1 vs msg2?
        
        //2. msg1 vs msg3???
        if(msg1.compareTo(msg3) == 0)
            System.out.println("m1 bang m3");
        else if(msg1.compareTo(msg3) < 0)
            System.out.println("m1 nho hon m3");
        else System.out.println("m1 lon hon m3");
        //3. msg1 vs msg3???
        //vi dieu, vi ham tra ve chuoi nen cham tiep, neu tra ve chuoi cham tiep, etc.
        //luu y khong sua chuoi goc, vi String da duoc new thi khong sua duoc nua
        System.out.println("Upper ne: " + msg1.toUpperCase());
        System.out.println("Ban goc ne: " + msg1);
    }
    
}
