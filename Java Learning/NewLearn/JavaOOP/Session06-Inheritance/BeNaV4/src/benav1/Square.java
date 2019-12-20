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
//HV luon la 1 HCN db nen dc thua ke
//tuc la ko can viet code lai, lam lai cai khuon HV cho nhung phan giong nhau
//ta chi lam phan db, khac biet
public class Square extends Rectangle{
    private String smile;
    //rieng HV co ma HCN ko co

    public Square(String owner, String color, String smile, double edge) {
        super(owner, color, edge, edge); //new goi cst, goi pheu cua Rectangle
        // tao vung nho nen maf ngay xau cau rieng con , nay gui cho cha giu
        //ton tron cst goc cua con
        //HV la HCN dac biet voi 2 canh bang nhau
        this.smile = smile;
    }
    // can dieu chinh tham so cho phu hop 
    // ve ly thuyet ko can lam ham tinh dien tichs, cu the ma sai cua HCN
    // goi la ke thua, INHERIT/INHERITANCE
    @Override
    public String toString() {
        return "Square{" + "smile=" + smile + '}';
    }
    
    public void sPaint(){
        System.out.println("Square");
    }
    
    @Override // Cha Con co chung ten ham, y chang nhau 100% ve ten
    // giong kieu tra ve, giong ve tham so 
    public void paint(){
        System.out.printf("|SQUARE   |%-10s|%-10s|%4.1f|%4.1f|%6.2f|\n", owner,
                color, width, length, getArea());
    }
}
