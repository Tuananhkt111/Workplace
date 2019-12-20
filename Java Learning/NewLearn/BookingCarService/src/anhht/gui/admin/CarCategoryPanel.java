/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.gui.admin;

import anhht.gui.admin.insert.CarCatInsertFrame;
import anht.daos.CarCategoryDAO;
import anht.dtos.CarCategoryDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuana
 */
public class CarCategoryPanel extends javax.swing.JPanel {

    private DefaultTableModel tblModelCarCategory = null;

    /**
     * Creates new form CarCategoryPanel
     */
    public CarCategoryPanel() {
        initComponents();
        tblModelCarCategory = (DefaultTableModel) tblViewCarCategory.getModel();
        spSeats.setEnabled(false);
        ((JSpinner.DefaultEditor) spSearch.getEditor()).getTextField().setEditable(false);
    }

    private void showCarCategory(List<CarCategoryDTO> list) {
        tblModelCarCategory.setRowCount(0);
        for (CarCategoryDTO carCategoryDTO : list) {
            tblModelCarCategory.addRow(carCategoryDTO.toVector());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewCarCategory = new javax.swing.JTable();
        lblCarList = new javax.swing.JLabel();
        lblCarInfo = new javax.swing.JLabel();
        pnlCarCatInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spSeats = new javax.swing.JSpinner();
        txtSurcharge = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        msgSurcharge = new javax.swing.JLabel();
        msgDiscount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        spSearch = new javax.swing.JSpinner();
        btnshowAll = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblViewCarCategory.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tblViewCarCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number Of Seats", "SurchargeHr", "Discount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblViewCarCategory.setRowHeight(24);
        tblViewCarCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewCarCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblViewCarCategory);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 590, 410));

        lblCarList.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblCarList.setText("Car Category List");
        add(lblCarList, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        lblCarInfo.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblCarInfo.setText("Car Category Info");
        add(lblCarInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 80, -1, -1));

        pnlCarCatInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Seats:");
        pnlCarCatInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 27, -1, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("SurchargeHr:");
        pnlCarCatInfo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setText("Discount:");
        pnlCarCatInfo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 30));

        spSeats.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        spSeats.setModel(new javax.swing.SpinnerNumberModel(2, 2, 100, 1));
        pnlCarCatInfo.add(spSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        txtSurcharge.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        pnlCarCatInfo.add(txtSurcharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 180, -1));

        txtDiscount.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        pnlCarCatInfo.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel4.setText("VND");
        pnlCarCatInfo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 117, -1, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel5.setText("%");
        pnlCarCatInfo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, 30));

        msgSurcharge.setForeground(new java.awt.Color(255, 0, 0));
        pnlCarCatInfo.add(msgSurcharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 180, 20));

        msgDiscount.setForeground(new java.awt.Color(255, 0, 0));
        pnlCarCatInfo.add(msgDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 180, 20));

        add(pnlCarCatInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 490, 300));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel8.setText("Seats:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, -1, 40));

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, -1, 40));

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnDelete.setText("Remove");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 580, -1, 40));

        btnInsert.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 110, 40));

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 480, 100, 40));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 480, -1, 40));

        spSearch.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        spSearch.setModel(new javax.swing.SpinnerNumberModel(2, 2, 100, 1));
        add(spSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, -1, 40));

        btnshowAll.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnshowAll.setText("Show All");
        btnshowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowAllActionPerformed(evt);
            }
        });
        add(btnshowAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int seats = (Integer) spSeats.getValue();
        int surchargeHr = 0;
        float discount = 0;
        try {
            surchargeHr = Integer.parseInt(txtSurcharge.getText());
        } catch (NumberFormatException e) {
        }
        try {
            int temp = Integer.parseInt(txtDiscount.getText());
            discount = (float) Math.round(temp) / 100;
        } catch (NumberFormatException e) {
        }
        CarCategoryDAO carCatDAO = new CarCategoryDAO();
        if (validate(seats, surchargeHr, discount)) {
            if (carCatDAO.update(new CarCategoryDTO(seats, surchargeHr, discount))) {
                JOptionPane.showMessageDialog(null, "Update success");
                int search = (Integer) spSearch.getValue();
                if (search == seats) {
                    btnSearch.doClick();
                } else {
                    btnshowAll.doClick();
                }
                spSeats.setValue(2);
                btnDelete.setEnabled(false);
                btnReset.doClick();
            } else {
                JOptionPane.showMessageDialog(null, "Update failed");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtDiscount.setText("");
        txtSurcharge.setText("");
        msgDiscount.setText("");
        msgSurcharge.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        CarCategoryDAO carCatDAO = new CarCategoryDAO();
        List<CarCategoryDTO> result = null;
        int seats = (Integer) spSearch.getValue();
        CarCategoryDTO carCatDTO = carCatDAO.findByPrimaryKey(seats);
        if (carCatDTO != null) {
            result = new ArrayList<>();
            result.add(carCatDTO);
        }
        if (result != null) {
            showCarCategory(result);
        } else {
            JOptionPane.showMessageDialog(null, "Not Found!");
            tblModelCarCategory.setRowCount(0);
        }
        btnDelete.setEnabled(false);
        btnReset.doClick();
        spSeats.setValue(2);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnshowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowAllActionPerformed
        // TODO add your handling code here:
        CarCategoryDAO carCatDAO = new CarCategoryDAO();
        List<CarCategoryDTO> result = carCatDAO.findAll();
        if (result != null) {
            showCarCategory(result);
        } else {
            JOptionPane.showMessageDialog(null, "Not Found!");
            tblModelCarCategory.setRowCount(0);
        }
        btnDelete.setEnabled(false);
        btnReset.doClick();
        spSeats.setValue(2);
    }//GEN-LAST:event_btnshowAllActionPerformed

    private void tblViewCarCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewCarCategoryMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblViewCarCategory.getSelectedRow();
            int seats = (Integer) tblModelCarCategory.getValueAt(row, 0);
            loadCarCategoryInfo(seats);
            btnDelete.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select category");
        }
    }//GEN-LAST:event_tblViewCarCategoryMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int row = tblViewCarCategory.getSelectedRow();
            int seats = (Integer) tblModelCarCategory.getValueAt(row, 0);
            CarCategoryDAO ccDAO = new CarCategoryDAO();
            if (ccDAO.delete(seats)) {
                JOptionPane.showMessageDialog(null, "Delete success");
                btnDelete.setEnabled(false);
                btnReset.doClick();
                spSeats.setValue(2);
                int search = (Integer) spSearch.getValue();
                if (search != seats) {
                    btnshowAll.doClick();
                } else {
                    tblModelCarCategory.setRowCount(0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Delete failed. There "
                        + "may be cars or travel price in this category.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select category");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        new CarCatInsertFrame(btnshowAll, btnDelete, btnReset, spSearch, spSeats).setVisible(true);
    }//GEN-LAST:event_btnInsertActionPerformed

    private boolean validate(int seats, int surchargeHr, float discount) {
        boolean check = true;
        CarCategoryDAO ccDAO = new CarCategoryDAO();
        CarCategoryDTO ccDTO = ccDAO.findByPrimaryKey(seats);
        if (ccDTO == null) {
            check = false;
            JOptionPane.showMessageDialog(null, "Please choose category");
        } else {
            if (surchargeHr < 1) {
                msgSurcharge.setText("Sucharge is number format.");
                check = false;
            } else {
                msgSurcharge.setText("");
            }
            if (discount <= 1.0f && discount > 0) {
                msgDiscount.setText("");
            } else {
                msgDiscount.setText("Discount is invalid.");
                check = false;
            }
        }
        return check;
    }

    private void loadCarCategoryInfo(int accID) {
        CarCategoryDAO ccDAO = new CarCategoryDAO();
        CarCategoryDTO ccDTO = ccDAO.findByPrimaryKey(accID);
        if (ccDTO != null) {
            spSeats.setValue(ccDTO.getNumberOfSeats());
            txtSurcharge.setText(Integer.toString(ccDTO.getSurchargeHr()));
            txtDiscount.setText(Integer.toString(Math.round(ccDTO.getDiscount() * 100)));
        } else {
            JOptionPane.showMessageDialog(null, "Cannot load car category information", "System warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnshowAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCarInfo;
    private javax.swing.JLabel lblCarList;
    private javax.swing.JLabel msgDiscount;
    private javax.swing.JLabel msgSurcharge;
    private javax.swing.JPanel pnlCarCatInfo;
    private javax.swing.JSpinner spSearch;
    private javax.swing.JSpinner spSeats;
    private javax.swing.JTable tblViewCarCategory;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtSurcharge;
    // End of variables declaration//GEN-END:variables

}
