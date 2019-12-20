/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.util.*;

/**
 *
 * @author Tuan Anh
 */
//pham cai gi chua 1 danh sach lua chon, cho ta chon, thi goi la Menu
//mot Menu bat ki luon co 1 danh sach lua chon options/items
public class Menu {
    private String appName; //ten app, ten nha hang, ko can thiet phai co dac tinh nay 
    private ArrayList<String> items = new ArrayList();
    //item.add(???) do mon vao, ta se ko do het luc duc obj Menu ma choi tro
    //set tu tu
    //ta se lam constructor khac moi ngay 1 ti: do name nhu bt, chua do mon an
    //mua san to giay trang, items, gio de tu tu nhet mon , viet ten mon vao
    
    public Menu (String appName) {
        this.appName = appName;
    } //da co tn nha hang, da co san to giay trang items cho ghi ten mon
    
    //ham nay giong set() dua mon vao gio, dua 1 mon thoi, ta se add vao gio
    //gio da add bao lan, ta co bay nhieu mon
    public void addItem(String option) {
        items.add(option); //add mon vao gio, ghi ten mon vao danh sach 
                            //ben mang se la items[???] = option; count++;
    }
    //gia bo coi nhu co mon r, thi in mon ra xem sao
    public void printMenu() {
        System.out.println("Welcome to " + appName);
        System.out.println("Choose the following items to play with");
        for(String x : items) {
            System.out.println(x);
        }
    }
    //mot menu co qua nhieu lua chon, minh bay mon ra roi, phai cho nguoi xai
    //co hoi go mon an vao
    //ta se oi ve lua chon la 1 con so nam trong dam mon an
    public int getChoice() {
        //return MyToys.getAnIntegerInRange("???", "???", 1, items.size());
        int n;
        //dua vao vong do while... ep nhap tu 1...size -> tot nhat la xai MyToys cho gon code
        //chong troi lenh, try catch
        System.out.println("Choose 1.." + items.size() + ": ");
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine()); //chong troi lenh
        return n;
        //return Integer.parseInt(sc.nextLine());
                //ko them xai bien con tro Scanner, xai vung new Scanner()
                //mot lan roi bo luon
        
        
    }
}
