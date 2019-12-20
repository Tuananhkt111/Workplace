/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author tuana
 */
//Thread presents received messages automatically
public class OutputThread extends Thread{
    Socket socket; //socket is joining to the communication
    JTextArea txt; //text-area contains communicated messages
    BufferedReader br; //input buffer of socket
    String sender;
    String receiver;

    public OutputThread(Socket socket, JTextArea txt, String sender, String receiver) {
        super();
        this.socket = socket;
        this.txt = txt;
        this.sender = sender;
        this.receiver = receiver;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Network Error");
            System.exit(0);
        }
    }
    @Override
    public void run() {
        while(true) {
            try {
                if(socket != null) {
                    String msg = ""; //get data from input
                    if((msg = br.readLine()) != null && msg.length() > 0) {
                        txt.append("\n" + receiver + ": " + msg);
                    }
                    sleep(1000);
                }
            } catch (Exception e) {
            }
        }
    }
}
