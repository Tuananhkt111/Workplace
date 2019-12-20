/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicarray;

/**
 *
 * @author Tuan Anh
 */
public class BasicArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        playWithPrimitiveArray();
        playWithObjectArray();
    }

    //mang chua mot dam primitive
    public static void playWithPrimitiveArray() {
        //int a1, a2, a3, a4, a5, a6;
        //o sat nhau nhung khong duoc goi la mang
        int a[] = {1, 3, 5, 7, 9, 2, 6, 1000, 2000};
        //co 7 bien int da dc khai bao, o sat nhau, cung chung ten la a
        //khai bao cung 1 luc
        // ko chi ra kci hthuoc luc khai bao, khac voi C day
        int[] b = {1, 3, 5, 7, 9, 2, 6, 1000, 2000};
        //in mang
        System.out.println("The array has (by using for i): ");
        //In toan bo mang thoe phong cach for each
        for (int i : a) //voi moi i thuoc vao cac gia tri trong a[]
        {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        //tinh tong trong b[]
        int sum = 0;
        for (int i : b) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
        //it xai mang kieu khai bao o tren, vi thuong chua biet truoc value bo vao mang
        //gs ta can luu luong mua trong nam, so biet duoc luong mua cac ngay con lai do chua dien ra
        //the nen se xai cach khai bao sau: khai bao mang truoc, gan value sau
        //gan value sau bang toan hoac Scanner
        int[] c = new int[10]; //xin 10 bien int nhen, cung ten la c
        //nho ngoac vuong la xin so bien , hem phai pheu~ de do, pheu phai (do value vao)
        //nho la mang primitive, nen moi bien[] la bien primitive, chua truc tiep value
        c[0] = 1;
        c[1] = 12;
        c[2] = 2204;
        c[7] = 7508;
        for (int i : c) {
            System.out.print(i + " ");
        }
        System.out.println("");
        //default bien trong mang khong duoc gan gia tri co gia tri mac dinh la 0.
        //cach khai bao mang a, b la new int[] ngam (implicit)
        //cach khai bao mang c goi la khai bao tuong minh (explicit)    
    }

    public static void playWithObjectArray() {
        Cat tom = new Cat("Tom", 1950, 10.0);
        Cat doreamon = new Cat("Doraemon", 1970, 15.0);
        Cat oggy; //khai bao truoc
        oggy = new Cat("Oggy", 2012, 7.0); //lap info sau
        tom.showDetail();
        System.out.println(oggy);
        System.out.println(doreamon);
        //tui muon mua 10 meo
        Cat[] m = new Cat[10]; // co 10 bien meo nhen
        //nhung chua co con meo nao cu the vi chua co pheu
        //tui di mua con meo di hia
        m[0] = new Cat("Kitty", 1970, 0.5);
        m[1] = new Cat("Di Hia", 1950, 15.0);
        m[2] = new Cat("Oggy", 2012, 7.0); //meo moi, hok phai oggy tren dau 
        //vi dieu tap 1
        m[3] = tom;
        //2 chang theo 1 nang, vung new Tom o tren cung co den 2 con tro
        //con tro tom ban dau va con tro m[3]
        m[4] = tom;
        //vi dieu tap 2
        m[5] = m[4];
        //mang obj chua cac bien ma co the tro trung vao vung duoc new
        //tuong duong khai niem thong ke trien lam/phim: so luot khan gia
        //vay trong mang dang co 6 bien duoc gan value
        //nhung thuc ra chi co 4 con meo that, do co 4 nhats new
        //in mang thoi
        for (Cat i : m) {
            if (i != null) {
                i.showDetail();
            }
        }
        // coi chung for het la null
        //chung minh 3 con cuoi la con tom o dau
        tom.setName("Tom Cang");
        for (Cat cat : m) {
            if (cat != null) {
                cat.showDetail();
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (m[i].getYob() < m[j].getYob()) {
                    Cat temp = m[i];
                    m[i] = m[j];
                    m[j] = temp;
                }
            }
        }
        for (Cat i : m) {
            if (i != null) {
                i.showDetail();
            }
        }
        //khi choi voi mang obj, cam khong duoc for het ma phai for den so bien da~ do value
        //vi phan con tro chua duoc gan vung new, hop bi mat chua tro den dau thi ta goi la con tro null
        //ko co code de cham dau -> exception neu rang cham'
//        for (Cat cat : m) {
//            cat.showDetail();
//        }
//        Dog chiHu = new Dog(...);
//        int a = 100;
//        Dog ngaoDa; //vietsub: co bien object, co bien la co vung nho
//        // nhung chua duoc gan gia tri
//        ngaoDa = new Dog(...); //gan value sau, gan dia chi vung new cho bien obj
        //tui muon mua va nuoi con meo
        //gom:name, yob, weight

    }

}
//Java for khong cho qua gioi han trong mang, hoac ban se bi Exception/OutOfBounds

