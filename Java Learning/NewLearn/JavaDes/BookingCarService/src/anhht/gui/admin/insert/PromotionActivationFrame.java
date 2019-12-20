/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.gui.admin.insert;

import anhht.daos.CarCategoryDAO;
import anhht.daos.PromotionDAO;
import anhht.daos.TravelPriceDAO;
import anhht.dtos.CarCategoryDTO;
import anhht.dtos.PromotionDTO;
import anhht.dtos.TravelPriceDTO;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import myutil.MyUtil;

/**
 *
 * @author tuana
 */
public class PromotionActivationFrame extends javax.swing.JFrame {
    private DefaultTableModel tblModelTravelPriceMain = null;
    private JLabel lblDiscountMain = null;
    private JTable tblViewTravelPriceMain = null;
    private JSpinner spDurationMain = null;
    private JLabel txtPriceMain = null;

    /**
     * Creates new form GetPromotionFrame
     */
    public PromotionActivationFrame() {
        initComponents();
    }

    public PromotionActivationFrame(JLabel lblDiscountMain, JTable tblViewTravelPriceMain, JSpinner spDurationMain, JLabel txtPriceMain) {
        initComponents();
        this.lblDiscountMain = lblDiscountMain;
        this.tblViewTravelPriceMain = tblViewTravelPriceMain;
        tblModelTravelPriceMain = (DefaultTableModel) tblViewTravelPriceMain.getModel();
        this.spDurationMain = spDurationMain;
        this.txtPriceMain = txtPriceMain;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPromotion = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        btnActivate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPromotion.setBackground(new java.awt.Color(255, 255, 255));
        lblPromotion.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblPromotion.setForeground(new java.awt.Color(255, 0, 0));
        lblPromotion.setText("Promotion Code:");
        getContentPane().add(lblPromotion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        txtCode.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtCode.setForeground(new java.awt.Color(51, 51, 255));
        getContentPane().add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 270, -1));

        btnActivate.setBackground(new java.awt.Color(255, 255, 255));
        btnActivate.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnActivate.setForeground(new java.awt.Color(255, 0, 0));
        btnActivate.setText("Activate");
        btnActivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateActionPerformed(evt);
            }
        });
        getContentPane().add(btnActivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/y1ostvqnr4711.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -70, 2660, 1220));

        setSize(new java.awt.Dimension(398, 320));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateActionPerformed
        // TODO add your handling code here:
        if (!txtCode.getText().equals("")) {
            PromotionDAO pDAO = new PromotionDAO();
            Timestamp currentTime = new Timestamp(new Date().getTime());
            PromotionDTO pDTO = pDAO.findByPrimaryKeyValid(txtCode.getText(), currentTime);
            if(pDTO != null) {
                lblDiscountMain.setText("Discount: " + Integer.toString(Math.round(pDTO.getDiscount() * 100)) + "%");
                changePrice();
                pDAO.delete(pDTO.getCode());
                JOptionPane.showMessageDialog(null, "Activate code success");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid code");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter code");
        }

    }//GEN-LAST:event_btnActivateActionPerformed

    private void changePrice() {
        try {
            int result;
            int row = tblViewTravelPriceMain.getSelectedRow();
            int duration = (Integer) spDurationMain.getValue();
            float discount = 0;
            if (!lblDiscountMain.getText().equals("")) {
                try {
                    discount = Float.parseFloat(lblDiscountMain.getText().substring(10, lblDiscountMain.getText().length() - 1)) / 100;
                } catch (NumberFormatException e) {
                }
            }
            String travelID = (String) tblModelTravelPriceMain.getValueAt(row, 0);
            TravelPriceDAO tpDAO = new TravelPriceDAO();
            TravelPriceDTO tpDTO = tpDAO.findByPrimaryKey(travelID);
            CarCategoryDAO ccDAO = new CarCategoryDAO();
            CarCategoryDTO ccDTO = ccDAO.findByPrimaryKey(tpDTO.getNumberOfSeats());
            result = MyUtil.countPrice(tpDTO.getPrice(), tpDTO.getLimitTime(), duration, ccDTO.getSurchargeHr(), discount);
            txtPriceMain.setText(Integer.toString(result));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
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
            java.util.logging.Logger.getLogger(PromotionActivationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PromotionActivationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PromotionActivationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PromotionActivationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PromotionActivationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivate;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblPromotion;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
