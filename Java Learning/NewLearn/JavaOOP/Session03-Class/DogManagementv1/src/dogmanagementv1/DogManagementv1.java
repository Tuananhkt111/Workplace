package dogmanagementv1;

import data.Dog;
import java.util.Scanner;

public class DogManagementv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dog chiHuaHua = new Dog("choVietHung", 1999, 50);
        chiHuaHua.bark();
        chiHuaHua.showDetailed();
        chiHuaHua.setYob(2000);
        chiHuaHua.showDetailed();
    }    
}
