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
public class Book {
    private String id;
    private String title;
    private String author;
    private String type;

    public Book(String id, String title, String author, String type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
    }
    public void inform() {
        System.out.println("Id: " + id  + "\tTitle: " + title + "\tAuthor: " + author + "\tType: " + type);
    }
}
