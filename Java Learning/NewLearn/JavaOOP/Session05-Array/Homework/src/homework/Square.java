/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

/**
 *
 * @author Tuan Anh
 */
//HV la 1 HCN db, nen duoc thua ke nhung thu dang co cua HCN
//tuc la ko can viet code lai, lam lai cai khuon HV cho nhung phan giong nhau
//ta chi lam phan db, khac biet
public class Square extends Rectangle{
    //rieng HV co ma HCN ko co
    private String smile;

    public Square(double width, double height, String color, String owner, String smile) {
        super(width, height, color, owner);
        this.smile = smile;
    }
    
}
