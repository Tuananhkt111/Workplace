/* A version of CopyFile that uses try-with-resources. 
   It demonstrates two resources (in this case files) being 
   managed by a single try statement. 
*/ 
package copyfile2;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CopyFile2
{
    public static void main(String[] args)
    {
        int i;
        // First, confirm that both files have been specified.
        if(args.length != 2)
        {
            System.out.println("Usage: CopyFile filename");
            return;
        }
        try(FileInputStream fin = new FileInputStream(args[0]);
                FileOutputStream fout =new FileOutputStream(args[1]))
        {
            // Open and manage two files via the try statement.
            do
            {
                i = fin.read();
                if(i != -1) fout.write(i);
            } while(i != -1);
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(CopyFile2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(CopyFile2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
