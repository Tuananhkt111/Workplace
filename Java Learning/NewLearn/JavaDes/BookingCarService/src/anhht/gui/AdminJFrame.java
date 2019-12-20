/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.gui;

import anhht.gui.admin.CustomerPanel;
import anhht.gui.admin.CarCategoryPanel;
import anhht.gui.admin.CarPanel;
import anhht.gui.admin.EmployeePanel;
import anhht.gui.admin.PromotionPanel;
import anhht.gui.admin.TransactionPanel;
import anhht.gui.admin.TravelPricePanel;
import java.awt.CardLayout;
import java.awt.Color;

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
        btnCustomer.doClick();
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
        btnCustomer = new javax.swing.JButton();
        btnCarCategory = new javax.swing.JButton();
        btnCar = new javax.swing.JButton();
        btnTravelPrice = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnPromotion = new javax.swing.JButton();
        btnTransaction = new javax.swing.JButton();
        pnlView = new javax.swing.JPanel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 51, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Saigon Booking Travel Car");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        btnCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomer.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnCustomer.setForeground(new java.awt.Color(255, 0, 0));
        btnCustomer.setText("Customer");
        btnCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });
        getContentPane().add(btnCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 211, 40));

        btnCarCategory.setBackground(new java.awt.Color(255, 255, 255));
        btnCarCategory.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnCarCategory.setForeground(new java.awt.Color(255, 0, 0));
        btnCarCategory.setText("Car Category");
        btnCarCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 211, 40));

        btnCar.setBackground(new java.awt.Color(255, 255, 255));
        btnCar.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnCar.setForeground(new java.awt.Color(255, 0, 0));
        btnCar.setText("Car");
        btnCar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 211, 40));

        btnTravelPrice.setBackground(new java.awt.Color(255, 255, 255));
        btnTravelPrice.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnTravelPrice.setForeground(new java.awt.Color(255, 0, 0));
        btnTravelPrice.setText("Travel Price");
        btnTravelPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTravelPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTravelPriceActionPerformed(evt);
            }
        });
        getContentPane().add(btnTravelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 211, 40));

        btnEmployee.setBackground(new java.awt.Color(255, 255, 255));
        btnEmployee.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnEmployee.setForeground(new java.awt.Color(255, 0, 0));
        btnEmployee.setText("Employee");
        btnEmployee.setToolTipText("");
        btnEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 211, 40));

        btnPromotion.setBackground(new java.awt.Color(255, 255, 255));
        btnPromotion.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnPromotion.setForeground(new java.awt.Color(255, 0, 0));
        btnPromotion.setText("Promotion");
        btnPromotion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPromotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromotionActionPerformed(evt);
            }
        });
        getContentPane().add(btnPromotion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 70, 211, 40));

        btnTransaction.setBackground(new java.awt.Color(255, 255, 255));
        btnTransaction.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnTransaction.setForeground(new java.awt.Color(255, 0, 0));
        btnTransaction.setText("Transaction");
        btnTransaction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransactionActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 70, 211, 40));

        pnlView.setBackground(new java.awt.Color(255, 255, 255));
        pnlView.setLayout(new java.awt.CardLayout());
        getContentPane().add(pnlView, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1470, 760));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/y1ostvqnr4711.jpg"))); // NOI18N
        lblBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1570, 982));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) pnlView.getLayout();
        CustomerPanel cusPanel = new CustomerPanel();
        pnlView.removeAll();
        pnlView.add(cusPanel, "card1");
        pnlView.updateUI();
        cl.show(pnlView, "card1");
        btnCustomer.setBackground(new Color(204, 255, 255));
        btnCustomer.setForeground(new Color(51, 51, 255));
        btnCar.setBackground(Color.white);
        btnCar.setForeground(new Color(255, 0, 0));
        btnCarCategory.setBackground(Color.white);
        btnCarCategory.setForeground(new Color(255, 0, 0));
        btnEmployee.setBackground(Color.white);
        btnEmployee.setForeground(new Color(255, 0, 0));
        btnPromotion.setBackground(Color.white);
        btnPromotion.setForeground(new Color(255, 0, 0));
        btnTransaction.setBackground(Color.white);
        btnTransaction.setForeground(new Color(255, 0, 0));
        btnTravelPrice.setBackground(Color.white);
        btnTravelPrice.setForeground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnCarCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarCategoryActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) pnlView.getLayout();
        CarCategoryPanel carCatPanel = new CarCategoryPanel();
        pnlView.removeAll();
        pnlView.add(carCatPanel, "card1");
        pnlView.updateUI();
        cl.show(pnlView, "card1");
        btnCarCategory.setBackground(new Color(204, 255, 255));
        btnCarCategory.setForeground(new Color(51, 51, 255));
        btnCar.setBackground(Color.white);
        btnCar.setForeground(new Color(255, 0, 0));
        btnCustomer.setBackground(Color.white);
        btnCustomer.setForeground(new Color(255, 0, 0));
        btnEmployee.setBackground(Color.white);
        btnEmployee.setForeground(new Color(255, 0, 0));
        btnPromotion.setBackground(Color.white);
        btnPromotion.setForeground(new Color(255, 0, 0));
        btnTransaction.setBackground(Color.white);
        btnTransaction.setForeground(new Color(255, 0, 0));
        btnTravelPrice.setBackground(Color.white);
        btnTravelPrice.setForeground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnCarCategoryActionPerformed

    private void btnTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) pnlView.getLayout();
        TransactionPanel transPanel = new TransactionPanel();
        pnlView.removeAll();
        pnlView.add(transPanel, "card1");
        pnlView.updateUI();
        cl.show(pnlView, "card1");
        btnTransaction.setBackground(new Color(204, 255, 255));
        btnTransaction.setForeground(new Color(51, 51, 255));
        btnCar.setBackground(Color.white);
        btnCar.setForeground(new Color(255, 0, 0));
        btnCustomer.setBackground(Color.white);
        btnCustomer.setForeground(new Color(255, 0, 0));
        btnEmployee.setBackground(Color.white);
        btnEmployee.setForeground(new Color(255, 0, 0));
        btnPromotion.setBackground(Color.white);
        btnPromotion.setForeground(new Color(255, 0, 0));
        btnCarCategory.setBackground(Color.white);
        btnCarCategory.setForeground(new Color(255, 0, 0));
        btnTravelPrice.setBackground(Color.white);
        btnTravelPrice.setForeground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnTransactionActionPerformed

    private void btnCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) pnlView.getLayout();
        CarPanel carPanel = new CarPanel();
        pnlView.removeAll();
        pnlView.add(carPanel, "card1");
        pnlView.updateUI();
        cl.show(pnlView, "card1");
        btnCar.setBackground(new Color(204, 255, 255));
        btnCar.setForeground(new Color(51, 51, 255));
        btnTransaction.setBackground(Color.white);
        btnTransaction.setForeground(new Color(255, 0, 0));
        btnCustomer.setBackground(Color.white);
        btnCustomer.setForeground(new Color(255, 0, 0));
        btnEmployee.setBackground(Color.white);
        btnEmployee.setForeground(new Color(255, 0, 0));
        btnPromotion.setBackground(Color.white);
        btnPromotion.setForeground(new Color(255, 0, 0));
        btnCarCategory.setBackground(Color.white);
        btnCarCategory.setForeground(new Color(255, 0, 0));
        btnTravelPrice.setBackground(Color.white);
        btnTravelPrice.setForeground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnCarActionPerformed

    private void btnTravelPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTravelPriceActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) pnlView.getLayout();
        TravelPricePanel tpPanel = new TravelPricePanel();
        pnlView.removeAll();
        pnlView.add(tpPanel, "card1");
        pnlView.updateUI();
        cl.show(pnlView, "card1");
        btnTravelPrice.setBackground(new Color(204, 255, 255));
        btnTravelPrice.setForeground(new Color(51, 51, 255));
        btnTransaction.setBackground(Color.white);
        btnTransaction.setForeground(new Color(255, 0, 0));
        btnCustomer.setBackground(Color.white);
        btnCustomer.setForeground(new Color(255, 0, 0));
        btnEmployee.setBackground(Color.white);
        btnEmployee.setForeground(new Color(255, 0, 0));
        btnPromotion.setBackground(Color.white);
        btnPromotion.setForeground(new Color(255, 0, 0));
        btnCarCategory.setBackground(Color.white);
        btnCarCategory.setForeground(new Color(255, 0, 0));
        btnCar.setBackground(Color.white);
        btnCar.setForeground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnTravelPriceActionPerformed

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) pnlView.getLayout();
        EmployeePanel empPanel = new EmployeePanel();
        pnlView.removeAll();
        pnlView.add(empPanel, "card1");
        pnlView.updateUI();
        cl.show(pnlView, "card1");
        btnEmployee.setBackground(new Color(204, 255, 255));
        btnEmployee.setForeground(new Color(51, 51, 255));
        btnTransaction.setBackground(Color.white);
        btnTransaction.setForeground(new Color(255, 0, 0));
        btnCustomer.setBackground(Color.white);
        btnCustomer.setForeground(new Color(255, 0, 0));
        btnTravelPrice.setBackground(Color.white);
        btnTravelPrice.setForeground(new Color(255, 0, 0));
        btnPromotion.setBackground(Color.white);
        btnPromotion.setForeground(new Color(255, 0, 0));
        btnCarCategory.setBackground(Color.white);
        btnCarCategory.setForeground(new Color(255, 0, 0));
        btnCar.setBackground(Color.white);
        btnCar.setForeground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnPromotionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromotionActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) pnlView.getLayout();
        PromotionPanel pPanel = new PromotionPanel();
        pnlView.removeAll();
        pnlView.add(pPanel, "card1");
        pnlView.updateUI();
        cl.show(pnlView, "card1");
        btnPromotion.setBackground(new Color(204, 255, 255));
        btnPromotion.setForeground(new Color(51, 51, 255));
        btnTransaction.setBackground(Color.white);
        btnTransaction.setForeground(new Color(255, 0, 0));
        btnCustomer.setBackground(Color.white);
        btnCustomer.setForeground(new Color(255, 0, 0));
        btnTravelPrice.setBackground(Color.white);
        btnTravelPrice.setForeground(new Color(255, 0, 0));
        btnEmployee.setBackground(Color.white);
        btnEmployee.setForeground(new Color(255, 0, 0));
        btnCarCategory.setBackground(Color.white);
        btnCarCategory.setForeground(new Color(255, 0, 0));
        btnCar.setBackground(Color.white);
        btnCar.setForeground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnPromotionActionPerformed

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
    private javax.swing.JButton btnCar;
    private javax.swing.JButton btnCarCategory;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnPromotion;
    private javax.swing.JButton btnTransaction;
    private javax.swing.JButton btnTravelPrice;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlView;
    // End of variables declaration//GEN-END:variables
}
