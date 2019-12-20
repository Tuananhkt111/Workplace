/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;
import util.MyToys;

/**
 *
 * @author Tuan Anh
 */
public class Cabinet {

    //dac tinh cua tu: mau son, hang sx, chat lieu, dung ho so loai nao...
    //tam tam thoi ko care o bai toan nay
    //quan trong nhat cua moi tu: dung danh sach cac obj nao do
    //Menu -> dung danh sach ho so/obj
    //Phong hoc -> danh sach sv theo hoc
    ArrayList<Dog> list = new ArrayList();

    //moi mua tu ve chua co ho so Dog nao dc bo vo
    //tu tu ai den kham thi ho so, obj dc add vao
    //qua ham add(), y chang ben Menu add mon
    //constructor rong, default, van new mot cai tu ma chua sua bien mang bien list rong
    //cho add mon, add ho so, add dog vao
    public Cabinet() {

    }

    public void addDog() {
        //ta sẽ nhập từng miếng thông tin của Dog ở đây qua lệnh Scanner
        String id, name;
        int yob;
        double weight;
        System.out.println("Input the dog #" + (list.size() + 1));
        id = MyToys.getID("Input dog id(DXXXXX): ",
                "The format of id is DXXXXX (X stands for a digit)", "^[D|d]\\d{5}$");
//        name = MyToys.getString("Input dog name: ", "The dog name is required!");
//        yob = MyToys.getAnInteger("Input dog yob (2000..2018): ", "Yob is from 2000..2018!", 2000, 2018);
//        weight = MyToys.getADouble("Input dog weight (0.1->99.0): ", "Weight is from 0.1 to 99.0!", 0.1, 99.0);
        int pos; //vi tri tim thay id
        do {
            System.out.println("Input id: ");
            id = sc.nextLine().trim().toUpperCase();
            pos = searchDogByPos(id);
            if(pos != -1) {
                System.out.println("Sorry, the id is duplicated. Input another one");
            }
        } while(pos != -1); //van con search thay tuc la chua ra -1
        
        System.out.println("Input name: ");
        name = sc.nextLine().trim().toUpperCase();
        System.out.println("Input yob: ");
        yob = Integer.parseInt(sc.nextLine().trim());
        System.out.println("Input weight: ");
        weight = Double.parseDouble(sc.nextLine().trim());
        list.add(new Dog(id, name, yob, weight));
        System.out.println("A dog profile is added sucessfully");
    }
    //Dog da duoc bo vao gio
    public void printDogList() {
        if(list.isEmpty()) {
            System.out.println("Ther is no dog. Nothing to print. Choose menu 1 firstly.");
            return; //thoat luon neu gio khong co ho so Dog nao
        }
        System.out.println("There is/are " + list.size() + " dog(s) in the list.");
        for (Dog dog : list) {
            //System.out.println(dog); //goi tham ten em toString()
            dog.showDetails();
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).showDetails();
        }
    }
    //ta di tim con Dog theo id vao, tra ve 
    //vi tri tim thay trong gio tinh tu 0, neu khong thay tra ve
    //tra ve dia chi cua vung RAM chua id do, goi la ham tra ve con tro, tra ve kieu Dog
    public int searchDogByPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }  
        }
        return -1;
    }
    public void doSearch() {
        String keyword;
        System.out.println("Input the id that you want search: ");
        keyword = sc.nextLine().trim().toUpperCase();
        Dog x= searchDogByPos(keyword);
        if(x == null) {
            System.out.println("");
        }
    }
    public void addDog(String id, String name, int yob, double weight) {

    }
    public void addDog(Dog x) {
        //gio rong oi, co 1 con dog ne
        list.add(x); //x new o dau do, dang tro vung new
    }
    //hien tuong trong 1 class bat ki co cac ham trung ten nhau nhung khac datatype tham so
    //hien tuong trung nay duoc goi la OVERLOAD, OVERLOADING, qua tai ham
    private Scanner sc = new Scanner(System.in);
    //bien nay xai chung cho cac ham o trong khuon tu
    //de de o day luon, do mat cong new cho tung ham, neu ban thich van co the lam dieu nay
}
