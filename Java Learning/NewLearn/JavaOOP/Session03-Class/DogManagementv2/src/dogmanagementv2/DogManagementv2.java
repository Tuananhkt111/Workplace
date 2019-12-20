package dogmanagementv2;
import data.Dog;
import java.util.Scanner;
public class DogManagementv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dog chiHuaHua = new Dog("choVietHung", 1999, 50);
        chiHuaHua.bark();
        chiHuaHua.showDetailed();
        chiHuaHua.setYob(2000);
        chiHuaHua.showDetailed();
        System.out.println("Using toString() function: " + chiHuaHua.toString());
        //dac biet voi ham toString() ko can goi em ra, chi can goi ten bien 
        //la e tu dong goi ten
        System.out.println("Goi tham ten em: " + chiHuaHua);
        //chi toString() moi co quyen nay, con moi ham con lai bat buoc phai goi ham va bat buoc 
        //phai ton tai truoc do
        //nhung neu ko co toString() ma van goi tham thi...
        //java se tu dong bam toan bo info cua obj o thanh 1 con so kieu kex
        //So nay duoc goi la con so bam dai dien cho vung nho goi la hash number
        //Thuat toan bam noi tieng: MD5, SHA1, xai trong blockchain
    }    
}
