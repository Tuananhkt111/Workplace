/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0023;

import manager.ShopManager;
import myutil.Menu;
import myutil.MyUtil;

/**
 *
 * @author tuana
 */
public class J1LP0023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyUtil myutil = new MyUtil();
        ShopManager sm = new ShopManager();
        Menu mn = new Menu("-----FRUIT SHOP SYSTEM-----");
        mn.addOption("1. Create Fruit");
        mn.addOption("2. View orders");
        mn.addOption("3. Shopping (for buyer)");
        mn.addOption("4. Exit");
        int choice;
        do {
            mn.showName();
            mn.showMenu();
            choice = myutil.getChoice("Choose option: ", "Please choose a number (1 - 4).", 4);
            sm.perform(choice);
        } while(choice != 4);
        
    }
    
}
