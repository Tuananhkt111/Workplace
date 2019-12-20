/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poem;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan Anh
 */
public class Poem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        writeAPoem("D:\\poem.txt");
        readAPoem("D:\\poem.txt");
    }
    //day la ham nhan vao ten tap tin, va se ghi bai tho vao tap tin do
    //tap tin nam tren dia cua ban, o 1 folder nao do, cach nhau qua dau phan cach
    //vi du:
    //Windows: D:\Xam\ngoctrinh.txt, trong code C, Java phai go la 
    //                              D:\\Xam\\ngoctrinh.txt
    //Linux, Mac: /urs/..../ngoctrinh.txt
    //Choi voi IO, File, bat buoc phai try = catch
    public static void writeAPoem(String filename) {
        try {
            FileWriter fw = new FileWriter(filename, true); //noi them data
            //class nay lo di tim tap tin tren dia
            //class duoi lo thao tac tren tap tin
            PrintWriter pw = new PrintWriter(fw);
            //san sang de ghi ra tap tin
            //dung vong lap nhap tu ban phim, hay la ghi truc tiep
            pw.println("Anh dang o dau?");
            pw.print("O duoi bien sau");
            pw.close();
            fw.close();
            System.out.println("Write file successfully!");
        } catch (Exception ex) {
            System.out.println("Error when writing the poem");
        }
        
    }
    public static void readAPoem(String filename) {
        try {
            FileReader fr = new FileReader(filename); //tui lo di tim tap tin
            BufferedReader br = new BufferedReader(fr); //thay roi dua cho anh doc di
            //vi dau co biet bao nhieu dong
            //nen ta cu doc miet cho den khi nao het doc duoc thi thoi
            //vay ta xai do while
            //tap tin .txt moi lan doc dc 1 dong, cho den khi cham EOF (end of file)
            String msg;
            do {
                msg = br.readLine();
                System.out.println(msg);
            } while(msg != null);
            System.out.println("------------end-----------");
            br.close();
            fr.close();
        } catch (Exception ex) {
            System.out.println("Error when reading file!");
        }
        
    }
}
