package sample2;

import javax.swing.*;

public class Sample2
{
    public static void main(String[] args)
    {
        //Tao frame tren event dispatching thread.
        SwingUtilities.invokeLater(() ->
        {
            Simple simple = new Simple();
        });
    }
    
}
