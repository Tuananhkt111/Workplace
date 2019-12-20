/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import data.Fruit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import myutil.MyUtil;

/**
 *
 * @author tuana
 */
public class ShopManager {

    MyUtil myutil = new MyUtil();
    ArrayList<Fruit> category = new ArrayList<>();
    Hashtable<String, ArrayList<Fruit>> list = new Hashtable<>();

    public void perform(int choice) {
        switch (choice) {
            case 1:
                System.out.println("-----Adding fruit category-----");
                String cont;
                do {
                    addFruit();
                    cont = myutil.getYesOrNo("Do you want to continue (Y/N)?");
                } while (cont.equalsIgnoreCase("Y"));
                break;
            case 2:
                System.out.println("-----VIEW ORDERS-----");
                showAllOrders();
                break;
            case 3:
                System.out.println("-----SHOPPING-----");
                addOrder();
        }
    }

    public void addFruit() {
        String fruitID;
        do {
            fruitID = myutil.getStringFormat("Fruit ID(Fxxxxx): ", "F\\d{5}", "ID must be Fxxxxx format.");
            if(findExisting(fruitID)) {
                System.out.println("ID existed.");
            }
        } while (findExisting(fruitID));
        String fruitName = myutil.getString("Fruit name: ", "Fruit name cannot be empty.");
        int price = myutil.getPositiveInt("Price: ", "Price is positive integer", "Wrong format integer");
        String origin = myutil.getString("Origin: ", "Origin cannot be empty.");
        category.add(new Fruit(fruitID, fruitName, origin, price));
        System.out.println("Insert success");
    }

    public boolean findExisting(String fruitID) {
        for (Fruit fruit : category) {
            if (fruit.getFruitID().equals(fruitID)) {
                return true;
            }
        }
        return false;
    }

    public void showAllCategories() {
        System.out.println("-----LIST OF FRUITS-----");
        System.out.println("FruitID   Fruit Name        Price     Origin");
        for (Fruit fruit : category) {
            fruit.showCategory();
        }
    }

    public void showShoppingList() {
            System.out.println("List of Fruits:");
            System.out.println("Item  Fruit Name        Origin          Price");
            for (int i = 0; i < category.size(); i++) {
                System.out.printf("%-6d", i + 1);
                category.get(i).showShopping();
            }
    }

    public void addOrder() {
        if (!category.isEmpty()) {
            String cont;
            ArrayList<Fruit> orders = new ArrayList<>();
            do {
                showShoppingList();
                int choice = myutil.getChoice("Choose item: ", "Choose a number (1 - " + category.size() + ").", category.size());
                int quantity = myutil.getPositiveInt("Quantity: ", "Quantity is a positive number", "Wrong integer format");
                Fruit f = category.get(choice - 1);
                orders.add(new Fruit(f.getFruitID(), f.getFruitName(), f.getOrigin(), f.getPrice(), quantity));
                cont = myutil.getYesOrNo("Do you want to order now (Y/N)?");
            } while (cont.equalsIgnoreCase("N"));
            System.out.println("Product               Quantity     Price    Amount");
            for (Fruit order : orders) {
                order.showOrder();
            }
            int total = 0;
            for (Fruit fruit : orders) {
                total += fruit.getPrice() * fruit.getQuantity();
            }
            System.out.println("Total: " + total + "$");
            String customer = myutil.getString("Input your name: ", "Your name cannot be empty");
            list.put(customer, orders);
            System.out.println("Order success");
        } else {
            System.out.println("No fruit founds");
        }
    }

    public void showAllOrders() {
        if (!list.isEmpty()) {
            Set<Map.Entry<String, ArrayList<Fruit>>> set = list.entrySet();
            int count = 1;
            for (Map.Entry<String, ArrayList<Fruit>> entry : set) {
                System.out.println("Customer: " + entry.getKey());
                System.out.println("Product               Quantity     Price     Amount");
                int total = 0;
                for (Fruit order : entry.getValue()) {
                    System.out.print(count + ". ");
                    order.showOrder();
                    total += order.getPrice() * order.getQuantity();
                }
                System.out.println("Total: " + total + "$");
                System.out.println();
                count++;
            }
        } else {
            System.out.println("No orders found");
        }
    }
}
