/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benav3;

import data.*;

/**
 *
 * @author Tuan Anh
 */
public class BeNav3 {

    public static void main(String[] args) {
        Triangle t1 = new Triangle(7, 4, 8, "Tung", "Tuan Anh");
        Triangle t2 = new Triangle(3, 3, 4, "Zen", "Hung");

        RightTriangle r1 = new RightTriangle(5, 8, "Cu", "Hai Huy");
        RightTriangle r2 = new RightTriangle(6, 6, "Hy", "Quang Huy");

        t1.paint();
        t2.paint();
        r1.paint();
        Triangle t[] = new Triangle[6];
        t[0] = t1;
        t[2] = t2;
        t[3] = new Triangle(11.0, 12.0, 13.0, "Sehun", "Green");
        t[4] = new RightTriangle(14.0, 15.0, "D.O.", "White");
        t[5] = r1;
        t[1] = r2;

        for (int i = 0; i < t.length - 1; i++) {
            for (int j = i + 1; j < t.length; j++) {
                if (t[i].getArea() > t[j].getArea()) {
                    Triangle tmp = t[i];
                    t[i] = t[j];
                    t[j] = tmp;
                }
            }
        }
        System.out.println("The array after sorting by area ascending");
        for (Triangle x : t) {
            x.paint();
        }
    }
}
