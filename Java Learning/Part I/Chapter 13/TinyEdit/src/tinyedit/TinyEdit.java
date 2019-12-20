//A tiny editor
package tinyedit;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TinyEdit
{
    public static void main(String[] args)
    {
        String str[] = new String[100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter lines to text.");
        System.out.println("Enter 'stop to quit.");
        for(int i = 0; i < 100; i++)
        {
            try
            {
                str[i] = br.readLine();
            } catch (IOException ex)
            {
                Logger.getLogger(TinyEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(str[i].equals("stop")) break;
        }
        System.out.println("Here is your file:");
        //display the lines
        for(int i = 0; i < 100; i++)
        {
            if(str[i].equals("stop")) break;
            System.out.println(str[i]);
        }
    }
}
