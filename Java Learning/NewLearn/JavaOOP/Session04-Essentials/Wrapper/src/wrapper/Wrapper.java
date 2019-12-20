/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrapper;

/**
 *
 * @author Tuan Anh
 */
public class Wrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        playWithIntegers();
    }
    public static void playWithIntegers() {
        int n1 = 100;
        Integer n2 = new Integer("100"); //bien obj, dong goi value
        Integer n3 = new Integer(100); //100 thanh q1 hop bu, loi~ la 100 primitive
        Integer n4 = 100; //tu nhien, new ngam
        //n2, n3, n4: bien obj, tro den vung new
        //n1: chua value truc tiep
        //4 bien deu cos value nhu nhau, la 100
        System.out.println("n1: " + n1);
        System.out.println("n2: " + n2);
        System.out.println("n3: " + n3);
        System.out.println("n4: " + n4);
        //luu y truong hop sau:
        Integer n5 = 1000;
        Integer n6 = 1000; //hai bien tro toi 2 vung new, nhung cung value
        //hoi n5 bang n6 khong???
        //khong bang vi day la 2 bien con tro tro toi hai dia chi khac nhau
        boolean result = (n5 == n6); //phep so sanh
        System.out.println("result 1: " + result);
        //summary: khong so sanh hai obj bang toan tu so sanh
        //vay lam sao so sanh hai bien obj, goi ham, tim vao sau ben trong
        //vung new ma so sanh, vi ta can value thuc su
        //chiHu vs. ngaoDa ko so dc
        //can phai so cai gi: can nang, mau long, nam sinh, hung du, chieu cao...
        //chi ra dac tinh can so
        //chiHu. so sanh ve can nang(vs. voi ngaoDa)
        System.out.println("n5 vs n6: " + n5.compareTo(n6));
        //cac ham so sanh obj tra ve 3 trang thai:
        //0: to bang cau
        //<0: to thua cau
        //>0: to thang cau
        if(n5.compareTo(n6) == 0)
            System.out.println("Equals");
        else if(n5.compareTo(n6) < 0)
            System.out.println("n5 < n6");
        else System.out.println("n5 > n6");
        //neu so sanh primitive, xai truc tiep >, <, ...
        //bien obj tro den 1 vung khac co value thuc su de so sanh
    }
}
