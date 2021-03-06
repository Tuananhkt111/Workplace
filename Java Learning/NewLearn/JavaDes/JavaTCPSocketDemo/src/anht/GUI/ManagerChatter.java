/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anht.GUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author tuana
 */
public class ManagerChatter extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form ManagerChatter
     */
    ServerSocket svrSocket = null;
    BufferedReader br = null;
    Thread t = null; //thread for exploring connections from staffs
    public ManagerChatter() {
        initComponents();
        this.setSize(600,300);
        int serverPort = Integer.parseInt(this.txtServerPort.getText());
        try {
            svrSocket = new ServerSocket(serverPort);
            this.lblMessage.setText("Mng. Server is running at the port ");
        } catch (Exception e) {
        }
        t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        while(true) {
            try { //wait for client
                Socket aStaffSocket = svrSocket.accept();
                if(aStaffSocket != null) { //if there is a connection 
                    //Get staffname
                    //when a staff inits a connection, he/she sends his/her name first
                    br = new BufferedReader(new InputStreamReader(aStaffSocket.getInputStream()));
                    String s = br.readLine();
                    int pos = s.indexOf(":"); //Format: "Staff:Hoa"
                    String staffName = s.substring(pos + 1); //getname
                    //create a tab of connection
                    ChatPanel p = new ChatPanel(aStaffSocket, "Manager", staffName);
                    jTabbedPane1.add(staffName, p);
                    p.updateUI();
                }
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        txtServerPort = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout());

        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMessage.setText("Manage port:  ");
        jPanel1.add(lblMessage);

        txtServerPort.setText("12340");
        jPanel1.add(txtServerPort);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerChatter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTextField txtServerPort;
    // End of variables declaration//GEN-END:variables

}
