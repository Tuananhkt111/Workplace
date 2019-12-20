/* This version of the ShowFile program uses a try-with-resources 
   statement to automatically close a file after it is no longer needed. 
   Note: This code requires JDK 7 or later. 
*/ 
package showfile2;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ShowFile2
{
    public static void main(String[] args)
    {
        int i;        
        // First, confirm that a filename has been specified.
        if(args.length != 1)
        {
            System.out.println("Usage: ShowFile filename");
            return;
        }
        try(FileInputStream fin = new FileInputStream(args[0]))
        {
            // The following code uses a try-with-resources statement to open
            // a file and then automatically close it when the try block is left.
            do
            {
                i = fin.read();
                if(i != -1) System.out.print((char)i);
            } while(i != -1);
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(ShowFile2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(ShowFile2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
