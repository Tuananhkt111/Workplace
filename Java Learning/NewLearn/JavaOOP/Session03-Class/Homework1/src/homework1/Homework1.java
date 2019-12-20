/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

/**
 *
 * @author Tuan Anh
 */
public class Homework1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book book1 = new Book("1300553", "Anh Yeu Em", "Tuan Anh", "Tieu thuyet");
        book1.inform();
        Book book2 = new Book("130554", "Never Eat Alone", "Blah", "Truyen Tranh");
        book2.inform();
    }
    
}
