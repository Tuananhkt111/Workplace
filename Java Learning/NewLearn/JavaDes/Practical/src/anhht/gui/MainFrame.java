/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.gui;

import anhht.daos.RestaurantDAO;
import anhht.dtos.RestaurantDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuana
 */
public class MainFrame extends javax.swing.JFrame {

    private DefaultTableModel tblModelRestaurant = null;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        tblModelRestaurant = (DefaultTableModel) tblViewRestaurant.getModel();
    }

    private void showRestaurant(List<RestaurantDTO> list) {
        tblModelRestaurant.setRowCount(0);
        for (RestaurantDTO restaurantDTO : list) {
            tblModelRestaurant.addRow(restaurantDTO.toVector());
        }
    }

    private void loadRestaurant(String district) {
        try {
            RestaurantDAO resDAO = new RestaurantDAO();
            List<RestaurantDTO> result = resDAO.findAllByDistrict(district);
            showRestaurant(result);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Not found!");
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

        groupDelete = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblViewRestaurant = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtDistrict = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        rdTrue = new javax.swing.JRadioButton();
        rdFalse = new javax.swing.JRadioButton();
        lblTitle = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblViewRestaurant.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tblViewRestaurant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Restaurant Name", "Address", "District"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblViewRestaurant.setRowHeight(24);
        tblViewRestaurant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewRestaurantMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblViewRestaurant);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 450));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Restaurant ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Restaurant Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setText("Address:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel4.setText("District:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel5.setText("isDelete:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 240, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 240, -1));

        txtDistrict.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel1.add(txtDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 250, -1));

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 330, -1));

        groupDelete.add(rdTrue);
        rdTrue.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        rdTrue.setText("True");
        jPanel1.add(rdTrue, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        groupDelete.add(rdFalse);
        rdFalse.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        rdFalse.setSelected(true);
        rdFalse.setText("False");
        jPanel1.add(rdFalse, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 470, 470));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lblTitle.setText("Restaurant Info");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 690, -1, -1));

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 320, -1));

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        setBounds(0, 0, 1174, 870);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (txtSearch.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter your district!");
        } else {
            loadRestaurant(txtSearch.getText());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblViewRestaurantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewRestaurantMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblViewRestaurant.getSelectedRow();
            String resID = (String) tblModelRestaurant.getValueAt(row, 0);
            RestaurantDAO resDAO = new RestaurantDAO();
            RestaurantDTO resDTO = resDAO.findByPrimaryKey(resID);
            loadInfo(resDTO);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tblViewRestaurantMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String district = txtDistrict.getText();
        boolean isDelete = rdTrue.isSelected();
        if (validate(id, name, address, district)) {
            if (!isDelete) {
                try {
                    RestaurantDAO resDAO = new RestaurantDAO();
                    RestaurantDTO resDTO = new RestaurantDTO(id, name, address, district, isDelete);
                    resDAO.update(resDTO);
                    JOptionPane.showMessageDialog(this, "Update success");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Update failed");
                }
            } else {
                try {
                    RestaurantDAO resDAO = new RestaurantDAO();
                    RestaurantDTO resDTO = resDAO.findByPrimaryKey(id);
                    resDAO.delete(resDTO);
                    loadRestaurant(district);
                    txtID.setText("");
                    txtName.setText("");
                    txtAddress.setText("");
                    txtDistrict.setText("");
                    rdFalse.setSelected(true);
                    JOptionPane.showMessageDialog(this, "Delete success");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Delete failed");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Input wrong format");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed
    private boolean validate(String id, String name, String address, String district) {
        boolean result = true;
        String pattern = "Res\\-(\\w){5}\\-(\\d){5}";
        if (!id.matches(pattern) || name.equals("") || address.equals("") || district.equals("")) {
            result = false;
        }
        return result;
    }

    private void loadInfo(RestaurantDTO resDTO) {
        if (resDTO != null) {
            txtID.setText(resDTO.getId());
            txtName.setText(resDTO.getName());
            txtAddress.setText(resDTO.getAddress());
            txtDistrict.setText(resDTO.getDistrict());
            if (resDTO.isIsDelete()) {
                rdTrue.setSelected(true);
            } else {
                rdFalse.setSelected(true);
            }
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup groupDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton rdFalse;
    private javax.swing.JRadioButton rdTrue;
    private javax.swing.JTable tblViewRestaurant;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtDistrict;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
