//Use a BufferedReader to read characters from the console.
package bufferreader;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BufferReader
{
    public static void main(String[] args)
    {
        char c = ' ';
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter characters, 'q' to quit.");
        //read characters
        do
        {
            try
            {
                c = (char) br.read();
                System.out.println(c);
            } catch (IOException ex)
            {
                Logger.getLogger(BufferReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (c != 'q');
    }
}
