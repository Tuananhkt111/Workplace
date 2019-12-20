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
public class Homework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Disc[] d = new Disc[3];
        Square[] s = new Square[3];
        Rectangle[] r = new Rectangle[3];
        d[0] = new Disc(1.0, "red", "Papa");
        d[1] = new Disc(2.5, "blue", "Mom");
        d[2] = new Disc(1.5, "yellow", "Sis");
        s[0] = new Square(1.0, "red", "Papa");
        s[1] = new Square(1.5, "blue", "Mom");
        s[2] = new Square(2.5, "yellow", "Sis");
        r[0] = new Rectangle(1.0, 1.5, "red", "Papa");
        r[1] = new Rectangle(2.3, 2.2, "blue", "Mom");
        r[2] = new Rectangle(1.5, 1.2, "yellow", "Sis");
        //Print array
        for (Disc disc : d) {
            if(disc != null)
                disc.showDetail();
        }
        System.out.println("");
        for (Square square : s) {
            if(square != null)
                square.showDetail();
        }      
        System.out.println("");
        for (Rectangle rectangle : r) {
            if(rectangle != null)
                rectangle.showDetail();
        }
    }
    
}
