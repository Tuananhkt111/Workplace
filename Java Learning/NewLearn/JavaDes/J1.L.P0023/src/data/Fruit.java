/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author tuana
 */
public class Fruit {
    private String fruitID, fruitName, origin;
    private int price, quantity;

    public Fruit(String fruitID, String fruitName, String origin, int price) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.origin = origin;
        this.price = price;
        this.quantity = 0;
    }

    public Fruit(String fruitID, String fruitName, String origin, int price, int quantity) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
    }

    
    
    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
    public void showCategory() {
        System.out.printf("%-10s%-18s%10d$%-10s\n", fruitID, fruitName, price, origin);
    }
    
    public void showShopping() {
        System.out.printf("%-18s%-10s%10d$\n", fruitName, origin, price);
    }
    public void showOrder() {
        System.out.printf("%-18s %10d%10d$%10d$\n", fruitName, quantity, price, price*quantity);
    }
}
