package sample;
import javax.swing.*;
public class Sample
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame(); // Create instance of jframe
        JButton b = new JButton("click"); //Create instance of JButton
        b.setBounds(130, 100, 100, 40); // Truc x, truc y, do rong, chieu cao
        f.add(b); //Them button vao trong JFrame
        f. setSize(400, 500); //Do rong, chieu cao
        f.setLayout(null);// khong su dung layout manager
        f.setVisible(true);// Tao frame co the nhin thay duoc
    }
    
}
