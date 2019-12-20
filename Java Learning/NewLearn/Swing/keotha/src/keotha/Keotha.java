/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keotha;

/**
 *
 * @author Tuan Anh
 */
public class Keotha
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        NewJFrame j = new NewJFrame();
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new NewJFrame().setVisible(true);
            }
        });
    }
    
}
