package dogmanagementv3;

import data.Dog;

public class DogManagementv3 {

    public static void main(String[] args) {
        Dog chiHuaHua = new Dog("choVietHung", 1999, 50);
        Dog ngaoDa = new Dog("ngaoDa", 12, 13);
        Dog ngaoCo = new Dog("ngaoCo", 1998, 80);
        chiHuaHua.showDetailed();
        ngaoDa.showDetailed();
        ngaoCo.showDetailed();
        ngaoCo.yob = 2020; //public cho ta tac dong truc tiep info hay ham
        System.out.println("NC name: " + ngaoCo.name);
        System.out.println("CH name: " + chiHuaHua.name);
        // nho la name xai chung cho ca ho Dog
        //the nen chiHu.name, ngaoCo.name, ai do cham name deu cung value
        //goi la ten chung cua Dog, do do nen viet la Dog.name;
        System.out.println("Dog name: " + Dog.name);
        //so static qua ten class cham la hop li, chuan com
    }
}
