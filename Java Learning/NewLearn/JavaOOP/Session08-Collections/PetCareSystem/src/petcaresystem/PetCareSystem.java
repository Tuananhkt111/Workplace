/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petcaresystem;
import data.*;
import ui.Menu;

/**
 *
 * @author Tuan Anh
 */
public class PetCareSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu quaPhe = new Menu("Qua Phe Restaurant");
        quaPhe.addItem("1.Xoai thuoc lac");
        quaPhe.addItem("2. Goi la ngon");
        quaPhe.addItem("3. Canh la rau can");
        quaPhe.addItem("4. Bill, please"); //thoat, di ve
        Menu pS = new Menu("Pet Care System");
        pS.addItem("1. Add a new dog profile");
        pS.addItem("2. Search a dog by id");
        pS.addItem("3. Print the dog list");
        pS.addItem("4. Update the dog info by id");
        pS.addItem("5. Remove a dog by id");
        pS.addItem("6. Sort the dog list by id");
        pS.addItem("7. Sort the dog list by name");
        pS.addItem("8. Quit");
        //quaPhe.printMenu();
        pS.printMenu();
        //moi ban an mon, chung nao chua goi Quit, Bill please, tuc la chua muon thoat
        //thi con moi an tiep
        int choice;
        //mua tu de dung
        Cabinet tu = new Cabinet();
        //ham add dc goi thi moi nhap... --> new 
        do {
            pS.printMenu(); //in mon
            choice = pS.getChoice(); //chon mon
            //nhieu if qua thi dung switch
            switch(choice) {
                case 1: System.out.println("You choose 1. Add a new dog profile");
                tu.addDog();
                break;
                case 2: System.out.println("You choose 2. Goi la ngon"); break;
                case 8: System.out.println("Bye bye, see you next season!");
                tu.printDogList();
                break;
                default: System.out.println("Muon choi thi nhap tu te, 1...8"); break;
            }
        } while(choice != 8); //neu chon mon cuoi thi dung
    }
    
}
