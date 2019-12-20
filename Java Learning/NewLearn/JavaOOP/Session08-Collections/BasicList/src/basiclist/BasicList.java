/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basiclist;

import data.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import util.Balance;

/**
 *
 * @author Hoang Dung
 */
public class BasicList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //playWithIntegerList();
        //printMenu();
        //sortIntegerList();
        sortStudentList();
    }

    public static void sortIntegerList() {
        //ta can 1 gio chua cac con so nguyen
        List<Integer> bag = new ArrayList();
        //khai bao cha theo con. xai ke thua, do Cha cua ArrayList la List
        //giong nhu khai bao Rectangle s = new Square(...);
        //List la abstract, chua khoang vai chuc ham abstract
        //rang new tuc la dung anomyous
        bag.add(-5);
        bag.add(12);
        bag.add(23);
        bag.add(-34);
        bag.add(100);
        bag.add(30);
        bag.add(-3);
        //in gio
        System.out.println("Before sorting: ");
        for (Integer integer : bag) {
            System.out.print(integer + " ");
        }
        Collections.sort(bag);
        //co 1 ham chua static, ten la Collections
        //no la class phu tro, chua cac do choi static giup minh xao nau
        //tren gio thuoc nhom List
        //vi du no co ham sort()
        //in gio
        System.out.println("After sorting: ");
        for (Integer integer : bag) {
            System.out.print(integer + " ");
        }
        //ham sort so sanh va doi cho
        //ham sort() cua Collections se biet duoc rang trong gio chua toan la so nguyen
        //ma cac so, nguyen san la so sanh duoc, nen ham nay du
        //suc doi cho duoc duoc ca con so nguyen
        //lam sao sort duoc gio dung mot dam Dog???
        //sort theo cai gi???
        //cau hoi: sap xep ds sv trong lop nay
        //1. sap theo tieu chuan nao??? id, name, gt, chieu cao, gpa
        //2. sap tang hay giam
        //bay ham sort() cua Collections no can biet lam sao de so sanh hai 
        //hai ban SV
    }

    public static void sortStudentList() {
        List<Student> bag = new ArrayList();
        bag.add(new Student("SE01", "An Nguyen", 1995, 5.0));
        bag.add(new Student("SE20", "Tan Nguyen", 1989, 2.0));
        bag.add(new Student("SE08", "An Nguyen", 1999, 7.0));
        bag.add(new Student("SE03", "An Nguyen", 2000, 10.0));
        System.out.println("The bag bofore sorting: ");
        for (Student student : bag) {
            student.showDetails();
        }
        System.out.println("");
        Collections.sort(bag);
        //ko biet cach so sanh hai ban SV, ko sort duoc
        //phai chi cho ham sort() cach so sanh hai ban SV
        //phai dam bao hai ban SV nay sure phai so sanh
        //co hai cau hoi so sanh: equals(Student khac)
        //                      compareTo(Student khac)
        //ta cho compareTo de dam bao biet sv nao lon nho bang sv kia
        //thi ta moi biet thu tu
        System.out.println("The bag after sorting: ");
        for (Student student : bag) {
            student.showDetails();
        }
        //tui mun osrt linh hoat, vay toi di mua cai can
        Balance canId = new Balance();
        Collections.sort(bag, canId);
        //phai chac co ham compare() trong cai can
        //tot nhat can ne phai la hang VN CLC, dang ki tieu chuan TCVN
        //tuc la phai gia nhap hoi
        //Can chuan hoa = COMPARATOR
        //phai ra nhap hoi nay, le phi la can implements ham compare()
        System.out.println("After sorting by id by using Comparator");
        for (Student student : bag) {
            student.showDetails();
        }
        //tui muon so sanh ve can nang
        //chuan tao class can moi CanCanNang, co ham compare(), nho implements...
        //y chang cach tren
        //vi dieu: hok le chi tao 1 class chi de c cho go code cho ham compare()
        //phi suc, ta co the tao obj Can thong qua chinh class Comparator
        //co che anonymous
        Comparator<Student> canWeight = new Comparator<Student>()
        {
            @Override
            public int compare(Student t, Student t1) {
                return Double.compare(t.getWeight(), t1.getWeight());
            }
        };
    }

    //Tui mún lưu thử 1 đám món ăn thì sao, thì mua cái giỏ đựng con trỏ String
    public static void printMenu() {
        ArrayList<String> foods = new ArrayList();
        foods.add("1. Xoài thuốc lắc");
        foods.add("2. Gỏi lá ngón");
        foods.add("3. Canh lá đu đủ");
        foods.add("4. Canh lá rau cần");
        System.out.println("Choose to phê, please");
        for (String x : foods) {
            System.out.println(x);
        }
    }

    //Ta mua 1 cái giỏ đựng 1 đống số nguyên (không giới hạn số lượng)
    //Khai báo 1 mảng đựng 1 đống giới hạn số lượng số nguyên
    //Giỏ này dặc d=biệt chỉ đựng con trỏ, không đựng primitive, nếu ráng đưa pri
    //thì sẽ bị boxing thành vùng new, giỏ trỏ vào vùng boxing
    public static void playWithIntegerList() {
        ArrayList<Integer> bag = new ArrayList();   //mua cái giỏ rỗng để nhét đồ vào
        // Integer bag[] = new Integer[20];
        //Bỏ đồ vào giỏ ở vị trí nào thì sẽ nằm im ở vị trí đó
        bag.add(100);   //boxing, giỏ sinh ra ngay 1 con trỏ móc vào vùng new Integer
        // x[0] = 100;
        //mún lấy con số ra, bên mảng là sout(x[0]), giỏ sẽ là sout(bag.get(0))
        bag.add(-100);
        bag.add(100);
        bag.add(10);
        bag.add(1000);
        bag.add(1000);
        bag.add(-5);
        bag.add(-5);
        //Cú add vào giỏ là trong giỏ sinh ra ngay con trỏ trỏ vùng new...
        //Không care giỏ đầy hay khoogn như bên mảng
        //Không care bij null pointer khi chưa gán value cho biến mảng
        //Vì giỏ này sẽ không có adđ con trỏ trừ hao, add đến đâu cấp đến đó

        //Hỏi: Giỏ có bao nhiêu con trỏ???
        System.out.println("Bag count: " + bag.size());     //~.length

        //Giỏ có gì???
        System.out.println("The bag has: ");
        for (int i = 0; i < bag.size(); i++) {
            System.out.print(bag.get(i) + " ");     //Lôi ra con trỏ thứ i, gọi thầm tên em 
        }            //toString()

        System.out.println("\nThe bag has for each");
        for (Integer x : bag) {
            System.out.print(x + " ");    //Gọi thầm tên em
        }
        //Làm biếng, gọi luôn toString() của bag

        System.out.println("\nGọi thầm cái giỏ");
        System.out.println(bag);
        //bag là con trỏ, trỏ vào 1 giỏ, trong giỏ lại đựng 1 đống con trỏ trỏ vùng new
        //bag.toString() là biến mọi thứ trong giỏ thành chuỗi, mà trong giỏ chỉ có 1 con trỏ
        //nên bắn cái tiếp cho từng con trỏ gọi toString() của Integer
    }
}
