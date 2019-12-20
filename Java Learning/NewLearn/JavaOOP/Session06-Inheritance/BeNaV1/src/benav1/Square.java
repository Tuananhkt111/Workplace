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
public class Square extends Rectangle {
    private String smile;
    //day la phan ma HV co rieng, HCN ko co, bien di, extends, mo rong

    public Square(String smile, String color, String owner, double edge) {
        super(color, owner, edge, edge);
        //HV la HCN dac biet co hai canh bang nhau
        //super(...) chinh la new Rectangle de chuan bi nho Rect de chua duoc cac vat lieu cho hinh vuong
        //HCN giu gium info HV
        //super() phai la cau lenh dau tien trong pheu
        this.smile = smile;
    }
    //dam bao constructor go cua con van la con khi choi ke thua
    //ve ly thuyet khong can ham tinh S, ham paint() vi HV la HCN
    //ta goi la INHERITANCE

    public String getSmile() {
        return smile;
    }

    public void setSmile(String smile) {
        this.smile = smile;
    }
    //phe vo cong cua cha
    @Override //cha con co chung ten y chang nhau 100%
    public void paint() {
        System.out.printf("|SQUARE|%-10s|%-10s|%4.1f|%4.1f|%6.2f|\n",
                owner, color, width, height, getArea());        
    }
}
