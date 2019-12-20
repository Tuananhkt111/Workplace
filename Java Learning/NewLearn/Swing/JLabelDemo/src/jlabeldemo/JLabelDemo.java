package jlabeldemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JLabelDemo
{
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    public JLabelDemo()
    {
        prepareGUI();
    }
    public static void main(String[] args)
    {
        JLabelDemo swingcontroldemo = new JLabelDemo();
        swingcontroldemo.showLabelDemo();
    }
    private void prepareGUI()
    {
        mainFrame = new JFrame("Vi du label Java Swing");
        mainFrame.setSize(400, 500);
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350,100);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(statusLabel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }
    private void showLabelDemo()
    {
        headerLabel.setText("Control in action: JLabel");
        JLabel jlabel = new JLabel("", JLabel.CENTER);
        jlabel.setText("Chao mung ban den voi bai huong dan Java Swing");
        jlabel.setOpaque(true);
        jlabel.setBackground(Color.GRAY);
        jlabel.setForeground(Color.WHITE);
        controlPanel.add(jlabel);
        mainFrame.setVisible(true);
    }
    
}
