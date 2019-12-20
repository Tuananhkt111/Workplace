package sample3;
import javax.swing.*;
public class Simple extends JFrame
{
    JFrame f;
    Simple()
    {
        JButton b = new JButton("click"); //Tao instance cua JButton
        b.setBounds(130, 100, 100, 100);
        add(b);
        setSize(400,500);
        setLayout(null);
        setVisible(true);
    }
}
