/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benav1;

/**
 *
 * @author Admin
 */
public class BeNaV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle("Tias", "Pink", 7.0, 2.0);
        Rectangle r2 = new Rectangle("Ma", "Pink", 2.0, 3.0);
        Rectangle r3 = new Rectangle("A.Hai", "Red", 10.0, 11.0);
        Rectangle r4 = new Rectangle("GA.Hai", "Green",11.0 ,11.0);
        
        Square s1 = new Square("Ma", "white", "smile", 5);
        Square s2 = new Square("C.Hai", "Pink", "smile", 4.5);
        Square s3 = new Square("GC.Hai", "Rainbow", "cry", 4.0);
        Square s4 = new Square("G.Be Na", "Rainbow", "cry", 5.0);
        
//        r1.paint();
//        r2.paint();
//        r3.paint();
//        r4.paint();
//        s1.paint();
//        s2.paint();
//        s3.paint();
//        s4.paint();
        
        Rectangle r[] = new Rectangle[8];
        r[0] = r1;
        r[1] = r2;
        r[2] = r3;
        r[3] = r4;

        // bé Na dư giấy, cắt dúng 1 hình có vẻ giống Sao Biển, nhưng ko chắc lắm
        // nhưng chắc chắn là nhỏ thoy, và sẽ sort đc với V, CN, T, TG...
        //hình chắc chắn là Shape, ko biết nhóm, vậy thì sao mà new đc khi 
        // không có khuôn, ta xài mượn gió bẻ măng , mượn Shape tạo object, vì Shape sẽ 
        // sẽ chỉ là nên thoymaf
        // trong vùng new Rect có Shape
        // trong cùng new Disk có Shape
        // 2 vùng new này extends mở rộng để chứa hàm có code cho abstract method
        // ta cũng new Shape() và thêm phần gõ code cho 2 hàm abs thì có vẻ giống
        //Rect DISK, nếu làm khuôn như thường
        Shape saoBien = new Shape("Thay", "Pink") {
            @Override
            public double getArea() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public void paint() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }; // VIP
        
    }
    
}
