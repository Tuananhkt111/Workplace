/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutil;

import java.util.ArrayList;

/**
 *
 * @author tuana
 */
public class Menu {
    private String programName;
    ArrayList<String> list = new ArrayList<>();
    public Menu(String programName) {
        this.programName = programName;
    }
    
    public void addOption(String option) {
        list.add(option);
    }
    
    public void showName() {
        System.out.println(programName);
    }
    
    public void showMenu() {
        for (String string : list) {
            System.out.println(string);
        }
    }
}
