//Read a string from console by BufferedReader
package readline;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Readline
{    
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines to text.");
        System.out.println("Enter 'stop' to quit.");
        try
            {
                do
        {
            
            str = br.readLine();
            System.out.println(str);
        } while(!str.equals("stop"));
            } catch (IOException ex)
            {
                Logger.getLogger(Readline.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
