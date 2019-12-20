/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import data.BSTree;
import data.MyLinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author tuana
 */
public class WordManager {

    public BSTree vie_engTree = new BSTree();
    public BSTree eng_vieTree = new BSTree();

    public void addVieEng(String word, MyLinkedList meanings) {
        vie_engTree.insert(word, meanings);
    }

    public void addEngVie(String word, MyLinkedList meanings) {
        eng_vieTree.insert(word, meanings);
    }

    public void readFile() {
        try {
            FileReader fr1 = new FileReader("VIE_ENG.txt");
            FileReader fr2 = new FileReader("ENG_VIE.txt");
            BufferedReader br1 = new BufferedReader(fr1);
            BufferedReader br2 = new BufferedReader(fr2);
            String temp;
            while ((temp = br1.readLine()) != null) {
                if (temp.equals("") || temp.equals("\n")) {
                    continue;
                }
                String[] arr = temp.split(" : ");
                MyLinkedList meaningsList = new MyLinkedList();
                meaningsList.addAll(Arrays.asList(arr[1].split(", ")));
                vie_engTree.insert(arr[0], meaningsList);
            }
            while ((temp = br2.readLine()) != null) {
                if (temp.equals("") || temp.equals("\n")) {
                    continue;
                }
                String[] arr = temp.split(" : ");
                MyLinkedList meaningsList = new MyLinkedList();
                meaningsList.addAll(Arrays.asList(arr[1].split(", ")));
                eng_vieTree.insert(arr[0], meaningsList);
            }
            br1.close();
            br2.close();
            fr1.close();
            fr2.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File ís not found or empty");
        }
    }
}
