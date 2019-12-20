/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import myutil.MyUtil;

/**
 *
 * @author tuana
 */
public class ReadFile {

    public static ArrayList<String> inputFile() {
        MyUtil myutil = new MyUtil();                 
        while (true) {
            try {
                ArrayList<String> result = new ArrayList<>();
                String filename = myutil.getHTMLFile("Enter your HTML filename:", ".html extension format");
                File f = new File(filename);
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String temp;
                while ((temp = br.readLine()) != null) {
                    result.add(temp);
                }
                try {
                    fr.close();
                } catch (IOException ex) {
                    System.out.println("Close file failed!");
                }
                return result;
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            } catch (IOException e) {
                System.out.println("Read file failed!");
            }
        }
    }

}
