/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.gui.admin.insert;

import anht.daos.CarCategoryDAO;
import anht.daos.TravelPriceDAO;
import anht.dtos.CarCategoryDTO;
import anht.dtos.TravelPriceDTO;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author tuana
 */
public class TravelPriceInsertFrame extends javax.swing.JFrame {
    
    private JButton btnSearchMain = null;
    private JButton btnDeleteMain = null;
    private JButton btnResetMain = null;
    private JTextField txtSearchMain = null;
    private JTextField txtTravelIDMain = null;

    /**
     * Creates new form TravelPriceInsertFrame
     */
    public TravelPriceInsertFrame() {
        initComponents();
    }
    
    public TravelPriceInsertFrame(JButton btnSearchMain, JButton btnDeleteMain, JButton btnResetMain, JTextField txtSearchMain, JTextField txtTravelIDMain) {
        initComponents();
        this.btnSearchMain = btnSearchMain;
        this.btnDeleteMain = btnDeleteMain;
        this.btnResetMain = btnResetMain;
        this.txtSearchMain = txtSearchMain;
        this.txtTravelIDMain = txtTravelIDMain;
        loadCbCarCategory();
        ((JSpinner.DefaultEditor) spDistance.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) spLimitTime.getEditor()).getTextField().setEditable(false);
    }

    private void loadCbCarCategory() {
        CarCategoryDAO carCateDAO = new CarCategoryDAO();
        List<CarCategoryDTO> result = carCateDAO.findAll();
        for (CarCategoryDTO carCategoryDTO : result) {
            cbSeats.addItem(Integer.toString(carCategoryDTO.getNumberOfSeats()));
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

        lblCarInfo = new javax.swing.JLabel();
        pnlTravelPriceInfo = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtTravelID = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        msgDes = new javax.swing.JLabel();
        msgPrice = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        spLimitTime = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        cbSeats = new javax.swing.JComboBox<>();
        spDistance = new javax.swing.JSpinner();
        txtDestination = new javax.swing.JTextField();
        btnGenerate = new javax.swing.JButton();
        msgTravelID = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCarInfo.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblCarInfo.setText("Travel Price Info");
        getContentPane().add(lblCarInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        pnlTravelPriceInfo.setBackground(new java.awt.Color(204, 255, 153));
        pnlTravelPriceInfo.setForeground(new java.awt.Color(255, 51, 51));
        pnlTravelPriceInfo.setPreferredSize(new java.awt.Dimension(51, 20));
        pnlTravelPriceInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblUsername.setText("TravelID:");
        pnlTravelPriceInfo.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 31, -1, 30));

        txtTravelID.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtTravelID.setForeground(new java.awt.Color(51, 255, 51));
        txtTravelID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pnlTravelPriceInfo.add(txtTravelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 160, -1));

        lblPass.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblPass.setText("Destination:");
        pnlTravelPriceInfo.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 109, 120, 28));

        lblSex.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblSex.setText("Est. Distance:");
        pnlTravelPriceInfo.add(lblSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 257, -1, 50));

        lblAge.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblAge.setText("Number Of Seats:");
        pnlTravelPriceInfo.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 365, -1, 28));

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblPhone.setText("Price:");
        pnlTravelPriceInfo.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 451, -1, 28));

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(51, 255, 51));
        txtPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pnlTravelPriceInfo.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 449, 170, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblName.setText("Limit Time:");
        pnlTravelPriceInfo.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 186, -1, 28));

        msgDes.setForeground(new java.awt.Color(255, 51, 51));
        pnlTravelPriceInfo.add(msgDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 149, 386, 20));

        msgPrice.setForeground(new java.awt.Color(255, 51, 51));
        pnlTravelPriceInfo.add(msgPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 491, 183, 14));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Km");
        pnlTravelPriceInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, 30));

        spLimitTime.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        spLimitTime.setModel(new javax.swing.SpinnerNumberModel(1, 1, 120, 1));
        pnlTravelPriceInfo.add(spLimitTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("VND");
        pnlTravelPriceInfo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, -1, 30));

        cbSeats.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        pnlTravelPriceInfo.add(cbSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        spDistance.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        spDistance.setModel(new javax.swing.SpinnerNumberModel(10, 10, 1000, 10));
        pnlTravelPriceInfo.add(spDistance, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        txtDestination.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        pnlTravelPriceInfo.add(txtDestination, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 360, -1));

        btnGenerate.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });
        pnlTravelPriceInfo.add(btnGenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 130, -1));

        msgTravelID.setForeground(new java.awt.Color(255, 51, 51));
        pnlTravelPriceInfo.add(msgTravelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 320, 20));

        getContentPane().add(pnlTravelPriceInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 660, 530));

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 640, 120, -1));

        btnInsert.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 640, 120, -1));

        setSize(new java.awt.Dimension(875, 764));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:
        String NumericString = "0123456789";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(5);
        TravelPriceDAO tpDAO = new TravelPriceDAO();
        String result = null;
        do {
            for (int i = 0; i < 5; i++) {
                // generate a random number between
                // 0 to NumericString variable length
                int index = (int) (NumericString.length() * Math.random());
                // add Character one by one in end of sb
                sb.append(NumericString.charAt(index));
            }
            result = "T" + sb.toString();
        } while (tpDAO.findExisting(result));
        txtTravelID.setText(result);
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtTravelID.setText("");
        msgTravelID.setText("");
        txtDestination.setText("");
        msgDes.setText("");
        spLimitTime.setValue(1);
        spDistance.setValue(10);
        cbSeats.setSelectedIndex(0);
        txtPrice.setText("");
        msgPrice.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String travelID = txtTravelID.getText();
        String des = txtDestination.getText();
        int limitTime = (Integer) spLimitTime.getValue();
        int distance = (Integer) spDistance.getValue();
        int seats = Integer.parseInt((String) cbSeats.getSelectedItem());
        int price = 0;
        try {
            price = Integer.parseInt(txtPrice.getText());
        } catch (NumberFormatException e) {
        }        
        TravelPriceDAO tpDAO = new TravelPriceDAO();
        if (validate(travelID, des, price)) {
            if (tpDAO.insert(new TravelPriceDTO(travelID, des, limitTime, distance, seats, price))) {
                JOptionPane.showMessageDialog(null, "Insert success");
                btnDeleteMain.setEnabled(false);
                txtSearchMain.setText("");
                btnSearchMain.doClick();
                btnResetMain.doClick();
                txtTravelIDMain.setText("");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Insert failed");
            }
            
        }
    }//GEN-LAST:event_btnInsertActionPerformed
    
    private boolean validate(String travelID, String destination, int price) {
        boolean check = true;
        if (travelID.equals("")) {
            check = false;
            msgTravelID.setText("Press Generate button to get an ID");
        } else {
            msgTravelID.setText("");
        }
        if (destination.equals("Destination is not empty")) {
            msgDes.setText("");
            check = false;
        } else {
            msgDes.setText("");
        }
        if (price < 1) {
            msgPrice.setText("Price is a positive number");
            check = false;
        } else {
            msgPrice.setText("");
        }
        return check;
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
            java.util.logging.Logger.getLogger(TravelPriceInsertFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TravelPriceInsertFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TravelPriceInsertFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TravelPriceInsertFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TravelPriceInsertFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbSeats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCarInfo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel msgDes;
    private javax.swing.JLabel msgPrice;
    private javax.swing.JLabel msgTravelID;
    private javax.swing.JPanel pnlTravelPriceInfo;
    private javax.swing.JSpinner spDistance;
    private javax.swing.JSpinner spLimitTime;
    private javax.swing.JTextField txtDestination;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTravelID;
    // End of variables declaration//GEN-END:variables
}
