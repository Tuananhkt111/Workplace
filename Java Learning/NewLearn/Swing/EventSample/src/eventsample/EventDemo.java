package eventsample;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class EventDemo
{
    JLabel jl;
    EventDemo()
    {
        JFrame f = new JFrame("An Event Sample"); //Tao instance cua JFrame
        f.setLayout(new FlowLayout()); //Chon FlowLayout cho Layout Manager
        f.setSize(400, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jbtAlpha = new JButton("Alpha");
        JButton jbtBeta = new JButton("Beta");
        //Add action listener cho Alpha
        jbtAlpha.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                jl.setText("Alpha was pressed.");
            }
        });
        //Add action listener cho Beta
        jbtBeta.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                jl.setText("Beta was pressed.");
            }
        });
        //Add the buttons to the content pane
        f.add(jbtAlpha);
        f.add(jbtBeta);
        //Tao text-based cho label
        jl = new JLabel("Press a button");
        f.add(jl);
        jbtAlpha.setMnemonic(KeyEvent.VK_A);
        jbtAlpha.setToolTipText("Anh yeu em");
        jbtBeta.setMnemonic(KeyEvent.VK_Q);
        f.setVisible(true);
    }
    
}
