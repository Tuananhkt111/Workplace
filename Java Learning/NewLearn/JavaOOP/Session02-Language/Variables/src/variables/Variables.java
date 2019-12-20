/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

/**
 *
 * @author Tuan Anh
 */
public class Variables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printIntegerList();
        playWithStrings();
        playWithNumbers();
    }
    //Java cung cap du lieu moi String luu 1 choi ki tu
    public static void playWithStrings() {
        String name = "Hieu Nguyen Thanh";
        System.out.println("name: " + name.toUpperCase());
        System.out.println("name: " + name);
        System.out.println("name: " + name.concat("anh"));
    }
    public static void printIntegerList() {
        System.out.println("The list of 100 first integers");
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println("\nSum: " + sum);
    }
    //Java cung cap ca kieu du lieu so y chang C: int, long, float, double
    public static void playWithNumbers()
    {
        int n1= 1_000_000_000; //_phan cach phan ngan cho de doc
        //khi in ra thi bo _
        System.out.println("n1:" + n1);
        //mac dinh tat ca cac con so nguyen viet trong code thi dc xem la int
        //Java khoai choi voi int hon la long
//        int co tam tu -2ty1 den 2ty1
        long n2 = 3_000_000_000L; //L hay l hieu rang day la so kieu long
                                  //suffix nay bat buoc phai co khi choi long > int
        System.out.println("n2: " + n2);
        int n3 = 0xFA; //0x goi la prefix, tien to, hieu rang ta dang noi con so dem theo he 16
        System.out.println("n3: " + n3);
        int n4 = 070; //0 goi la prefix, hieu rang ta dang noi con so trong he 8 
        System.out.println("n4: " + n4);
        //mac dinh java thich choi voi double (8) hon float (4)
        double n5 = 12.34;
        float n6 = 4.14f; //F hay f bao hieu so thuc nho
        System.out.println("n6: " + n6);
        int a = 10, b = 3;
        int result = a / b;
        double result2 =(double) a / b;
        System.out.println("result: " + result);
        System.out.println("result2: " + result2);
    }
}
