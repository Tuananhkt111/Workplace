/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.book;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tuana
 */
public class BookDTO implements Serializable {
    private String bookID, title, catID, author, description, image, status, catName;
    private float price;
    private int quantity;
    Date importDate;

    public BookDTO(String bookID, String title, String catID, String author, String description, String image, String status, String catName, float price, int quantity, Date importDate) {
        this.bookID = bookID;
        this.title = title;
        this.catID = catID;
        this.author = author;
        this.description = description;
        this.image = image;
        this.status = status;
        this.catName = catName;
        this.price = price;
        this.quantity = quantity;
        this.importDate = importDate;
    }

    

    public BookDTO(String bookID, String title, String catID, String author, String description, String image, String status, float price, int quantity, Date importDate) {
        this.bookID = bookID;
        this.title = title;
        this.catID = catID;
        this.author = author;
        this.description = description;
        this.image = image;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.importDate = importDate;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
    
    
}
