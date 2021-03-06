/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.gui;

import anhht.gui.admin.AccountPanel;
import anhht.gui.admin.CarCategoryPanel;
import anhht.gui.admin.CarPanel;
import anhht.gui.admin.EmployeePanel;
import anhht.gui.admin.TravelPricePanel;
import java.awt.Font;

/**
 *
 * @author tuana
 */
public class AdminJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminJFrame
     */
    public AdminJFrame() {
        initComponents();
        myInIt();
    }
    public void myInIt() {
        pnlView.setFont(new Font("Tahoma", Font.PLAIN, 22));
        addAccPanel();
        addCarPanel();
        addCarCatPanel();
        addEmpPanel();
        addTravelPanel();
    }
    
    private void addAccPanel() {
        AccountPanel accPanel = new AccountPanel();
        pnlView.addTab("Account", accPanel);
    }
    
    private void addCarPanel() {
        CarPanel carPanel = new CarPanel();
        pnlView.addTab("Car", carPanel);
    }
    
    private void addCarCatPanel() {
        CarCategoryPanel carCatPanel = new CarCategoryPanel();
        pnlView.addTab("Car Category", carCatPanel);
    }
    
    private void addEmpPanel() {
        EmployeePanel empPanel = new EmployeePanel();
        pnlView.addTab("Employee", empPanel);
    }
    
    private void addTravelPanel() {
        TravelPricePanel tpPanel = new TravelPricePanel();
        pnlView.addTab("Travel Price", tpPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        pnlView = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Administrator Tools");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));
        getContentPane().add(pnlView, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1497, 735));

        setSize(new java.awt.Dimension(1559, 894));
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTabbedPane pnlView;
    // End of variables declaration//GEN-END:variables
}
