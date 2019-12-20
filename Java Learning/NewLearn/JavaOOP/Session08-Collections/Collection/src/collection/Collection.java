/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Tuan Anh
 */
public class Collection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<Integer> bag = new TreeSet(); //va TreeSet
        bag.add(-5); //new ngam
        bag.add(3);
        bag.add(10);
        bag.add(5);
        bag.add(100);
        bag.add(200);
        //hoi gio co gi???
        System.out.println("bag has " + bag); //goi tham ten em
        //gio HashSet se cho con tro lon xon ko theo thu tu nhu ben gio ArrayList
        //gio TreeSet sort tu dong du lieu bo vao
        //mun lam dieu nay thi obj bo vao gio phai la Comparable
        //Luu y: 
        //Gia su ta co Sutdent an = new Student("an", 2000);
        //the thi bag.add(an); bag.add(an) trong gio co may con tro??? mot thoy,
        //con tro an truoc do bi remove. Neu gio la ArrayList thi co 2 con tro + con tro an
        //Neu xai TreeSet thi Student phai Comparable
        //va se sort theo compareTo()
        //ta sang gio vi dieu, gio Map
        //moi lan add vao gio, ta can add theo cap: 1 cai key kem con tro data
        //key de giup lay ra con tro cho nhanh
        //phan data, con tro can lay goi la value
        Map<Integer, String> dict = new HashMap(); 
        //Map<String, Watch> bag = new HashMap();
        //lay cai ma dong ho se new de bo vao gio de lam key
        dict.put(1, "So mot");
        dict.put(2, "So hai");
        dict.put(10, "So muoi");
        dict.put(3, "So ba");
        System.out.println("Dict: " + dict);
        //tui muon biet nghia cua 10
        System.out.println("10 means " + dict.get(10));
        //tui muon biet so 100 co khong?
        System.out.println("100? " + dict.containsKey(100));
    }
    
}
