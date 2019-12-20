/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benav1;

/**
 *
 * @author Tuan Anh
 */
public class BeNaV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle("pink", "Tia", 1.0, 2.0);
        Rectangle r2 = new Rectangle("pink", "Ma", 2.0, 3.0);
        Rectangle r3 = new Rectangle("red", "A.Hai", 10.0, 12.0);
        Rectangle r4 = new Rectangle("green", "GA.Hai", 11.0, 12.0);

        Square s1 = new Square("C.Hai", "blue","<3", 20.0);
        Square s2 = new Square("GC.Hai", "blue", "<3", 21.0);
        Square s3 = new Square("Be Na", "rainbow", "<3", 20.0);
        Square s4 = new Square("G.Be Na", "blue", "<3", 11.0);
        r1.paint();
        r2.paint();
        r3.paint();
        r4.paint();
        s1.paint();
        s2.paint();
        s3.paint();
        s4.paint();
        //8 lenh nghe rat pain
        //ta nen dua vao mang
        Rectangle[] r = new Rectangle[8];
        r[0] = r1; //2 chang cung xich co 1 nang 
        r[1] = r2;
        r[2] = r3;
        r[3] = r4;
        //Vi dieu ne
        r[4] = s1; //ke thua tu cha, vi V la CN, ne duoc o chung mang CN
        r[5] = s2;
        r[6] = s3;
        r[7] = s4;
        System.out.println("");
        for (Rectangle rectangle : r) {
            if (rectangle != null) {
                rectangle.paint();
            }
        }
        //sort okie
        for (int i = 0; i < r.length - 1; i++) {
            for (int j = i + 1; j < r.length; j++) {
                if (r[i].getArea() > r[j].getArea()) {
                    Rectangle temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                }
            }
        }
        System.out.println("The rect array after sorting:");
        for (Rectangle rectangle : r) {
            if (rectangle != null) {
                rectangle.paint();
            }
        }
        //tui muon sort CN, hinh vuong cung nhau, phai lam sao????
        //cho vao chung mang for
        //r[4] = s1; //cau lenh sai vi mang CN ko chua chap vuong
        //neu vay thi can 2 mang rieng biet moi sort duoc
        //nhung be Na du suc sort duoc
        //Luc runtime, tuy hinh duoc tro la CN hay vuong thi ham paint()
        //tuong ung vung new do se duoc goi
        //Lúc r[i] trỏ CN, paint() CN được gọi
        //Lúc r[i] trỏ vuông, paint() vuông được ưu tiên gọi thay vì paint () CN
        //Ta gọi là đè, phế võ công, kh care hàm paint() cha, ưu tiên con
        //Khi cha con trùng tên hàm -> override
        //Tuy thế nếu con không có hàm paint() thì lấy cha mà chạy
        //Hiện tượng cùng 1 tên hàm (paint()) code khác nhau, lúc chạy tùy cơ ứng biến
        //phù hợp với vùng new, từ 1 có nhiều cách chạy khác nhau
        //Ta gọi là hiện tượng đa ánh xạ, đa sắc thái, đa hình dạng, transformer
        
        //OOP's PRICIPLES
        //1. Abstraction
        //2. Encapsulation: dong goi moi thu lai thanh class, che giau , show ra
        //3. Inheritance: ke thua de re-use
        //4. Polymorphism: cung 1 ten hem nhieu cach code, chay khac nhau luc runtime
        //Extra: Interface
    }

}
