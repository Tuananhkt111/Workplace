/* Copy a file. 
   To use this program, specify the name 
   of the source file and the destination file. 
   For example, to copy a file called FIRST.TXT 
   to a file called SECOND.TXT, use the following 
   command line. 
   java CopyFile FIRST.TXT SECOND.TXT 
*/ 
package copyfile;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CopyFile
{
    public static void main(String[] args)
    {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;
        // First, confirm that both files have been specified.
        if(args.length != 2)
        {
            System.out.println("Usage: CopyFile from to");
            return;
        }
        //Copy file.
        try
        {
            
            // Attempt to open the files.
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);
            do
            {
                i = fin.read();
                if(i != -1) fout.write(i);
            } while(i != -1);
        } catch (IOException ex)
        {
            Logger.getLogger(CopyFile.class.getName()).log(Level.SEVERE, null, ex);
        }   
        finally
        {
            try 
            {
                if(fin == null)
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(CopyFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try 
            {
                if(fout == null)
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(CopyFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}
