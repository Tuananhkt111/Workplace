package sample2;
import javax.swing.*;
public class Simple
{
    JFrame f;
    Simple()
    {
        f = new JFrame("A simple Swing Application"); //Tao instance cua JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l = new JLabel("Swing means powerful GUIs.");
        f.add(l);
        f.setSize(400, 500);
        f.setVisible(true);
    }
}
