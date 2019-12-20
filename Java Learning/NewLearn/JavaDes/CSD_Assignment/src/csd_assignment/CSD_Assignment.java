/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_assignment;

import data.ReadFile;
import java.util.ArrayList;
import myutil.MyUtil;
import validator.ValidatorHTML;

/**
 *
 * @author tuana
 */
public class CSD_Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cont;
        MyUtil myutil = new MyUtil();
        do {
            ValidatorHTML vh = new ValidatorHTML();
            ArrayList<String> str = ReadFile.inputFile();
            vh.validateHTML(str);
            cont = myutil.getYesOrNo("Do you want to continue(Y/N):", "Y/N only");
        } while (cont.equalsIgnoreCase("y"));
    }

}
