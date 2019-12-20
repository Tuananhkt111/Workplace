package eventsample;
import javax.swing.*;
public class EventSample
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
           EventDemo ev = new EventDemo(); 
        });
    }
    
}
