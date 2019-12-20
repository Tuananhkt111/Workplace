/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.gui.admin;

import anhht.gui.admin.insert.PromotionInsertFrame;
import anhht.daos.PromotionDAO;
import anhht.dtos.PromotionDTO;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuana
 */
public class PromotionPanel extends javax.swing.JPanel {

    private DefaultTableModel tblModelPromotion = null;

    /**
     * Creates new form PromotionPanel
     */
    public PromotionPanel() {
        initComponents();
        tblModelPromotion = (DefaultTableModel) tblViewPromotion.getModel();
        setDefaultStartTime();
    }

    private void showPromotion(List<PromotionDTO> list) {
        tblModelPromotion.setRowCount(0);
        for (PromotionDTO pDTO : list) {
            tblModelPromotion.addRow(pDTO.toVector());
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

        lblPromotionList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewPromotion = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        lblPromotionInfo = new javax.swing.JLabel();
        pnlCarCatInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        msgDiscount = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spStartTime = new javax.swing.JSpinner();
        spEndTime = new javax.swing.JSpinner();
        msgTime = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        cbSearch = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPromotionList.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblPromotionList.setForeground(new java.awt.Color(255, 0, 0));
        lblPromotionList.setText("Promotion List");
        add(lblPromotionList, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        tblViewPromotion.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tblViewPromotion.setForeground(new java.awt.Color(51, 51, 255));
        tblViewPromotion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PromotionCode", "Discount", "StartTime", "EndTime"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblViewPromotion.setRowHeight(24);
        tblViewPromotion.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tblViewPromotion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewPromotionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblViewPromotion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 680, 410));

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 0, 0));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/searching-2339723_1920.png"))); // NOI18N
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 50, 50));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/cancel.png"))); // NOI18N
        btnDelete.setToolTipText("Remove");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 580, 50, 50));

        btnInsert.setBackground(new java.awt.Color(255, 255, 255));
        btnInsert.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(255, 0, 0));
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/add-1-icon.png"))); // NOI18N
        btnInsert.setToolTipText("Insert");
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, 50, 50));

        lblPromotionInfo.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblPromotionInfo.setForeground(new java.awt.Color(255, 0, 0));
        lblPromotionInfo.setText("Promotion Info");
        add(lblPromotionInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 90, -1, -1));

        pnlCarCatInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlCarCatInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 2, true));
        pnlCarCatInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Code:");
        pnlCarCatInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 27, -1, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Discount:");
        pnlCarCatInfo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 30));

        txtDiscount.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtDiscount.setForeground(new java.awt.Color(51, 51, 255));
        pnlCarCatInfo.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 180, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("%");
        pnlCarCatInfo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, 30));

        msgDiscount.setForeground(new java.awt.Color(255, 0, 0));
        pnlCarCatInfo.add(msgDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 180, 20));

        txtCode.setEditable(false);
        txtCode.setBackground(new java.awt.Color(255, 255, 255));
        txtCode.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtCode.setForeground(new java.awt.Color(51, 51, 255));
        pnlCarCatInfo.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 180, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Start Time:");
        pnlCarCatInfo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("End Time:");
        pnlCarCatInfo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        spStartTime.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        spStartTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1552742958015L), null, null, java.util.Calendar.HOUR));
        spStartTime.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCarCatInfo.add(spStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        spEndTime.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        spEndTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1552742958015L), null, null, java.util.Calendar.HOUR));
        spEndTime.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCarCatInfo.add(spEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, -1));

        msgTime.setForeground(new java.awt.Color(255, 51, 51));
        pnlCarCatInfo.add(msgTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 230, 20));

        add(pnlCarCatInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 490, 350));

        btnReset.setBackground(new java.awt.Color(255, 255, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 0, 0));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/5c8dd48504f17.png"))); // NOI18N
        btnReset.setToolTipText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 510, 50, 50));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 0, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/24b70afe9c.png"))); // NOI18N
        btnUpdate.setToolTipText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 510, 50, 50));

        cbSearch.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        cbSearch.setForeground(new java.awt.Color(255, 0, 0));
        cbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Valid", "Invalid", "In Queue" }));
        cbSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(cbSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, -1, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/y1ostvqnr4711.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -70, 2660, 1220));
    }// </editor-fold>//GEN-END:initComponents

    private void tblViewPromotionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewPromotionMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblViewPromotion.getSelectedRow();
            String code = (String) tblModelPromotion.getValueAt(row, 0);
            loadPromotionInfo(code);
            btnDelete.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select promotion");
        }
    }//GEN-LAST:event_tblViewPromotionMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        PromotionDAO pDAO = new PromotionDAO();
        Timestamp currentTime = new Timestamp(new Date().getTime());
        List<PromotionDTO> result = null;
        switch (cbSearch.getSelectedIndex()) {
            case 0:
                result = pDAO.findAll();
                break;
            case 1:
                result = pDAO.findAllByValid(currentTime);
                break;
            case 2:
                result = pDAO.findAllByInValid(currentTime);
                break;
            case 3:
                result = pDAO.findAllByInQueue(currentTime);
                break;
        }
        if (!result.isEmpty() && result != null) {
            showPromotion(result);
        } else {
            tblModelPromotion.setRowCount(0);
            JOptionPane.showMessageDialog(null, "Not found any promotions.");
        }
        btnDelete.setEnabled(false);
        btnReset.doClick();
        txtCode.setText("");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int row = tblViewPromotion.getSelectedRow();
            String code = (String) tblModelPromotion.getValueAt(row, 0);
            PromotionDAO pDAO = new PromotionDAO();
            int dialogBtn = JOptionPane.showConfirmDialog(null, "Are you sure want to remove?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogBtn == JOptionPane.YES_OPTION) {
                if (pDAO.delete(code)) {
                    JOptionPane.showMessageDialog(null, "Delete success");
                    btnDelete.setEnabled(false);
                    btnReset.doClick();
                    btnSearch.doClick();
                    txtCode.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Delete failed.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select promotion");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        new PromotionInsertFrame(btnDelete, btnReset, cbSearch, txtCode, btnSearch).setVisible(true);
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtDiscount.setText("");
        msgDiscount.setText("");
        msgTime.setText("");
        setDefaultStartTime();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String code = txtCode.getText();
        float discount = 0;
        Timestamp startTime, endTime;
        try {
            int temp = Integer.parseInt(txtDiscount.getText());
            discount = (float) Math.round(temp) / 100;
        } catch (NumberFormatException e) {
        }
        Date StartTime = (Date) spStartTime.getValue();
        Date EndTime = (Date) spEndTime.getValue();
        startTime = new Timestamp(StartTime.getTime());
        endTime = new Timestamp(EndTime.getTime());
        PromotionDAO pDAO = new PromotionDAO();
        if (validate(code, discount, startTime, endTime)) {
            int dialogBtn = JOptionPane.showConfirmDialog(null, "Are you sure want to save changes?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogBtn == JOptionPane.YES_OPTION) {
                if (pDAO.update(new PromotionDTO(code, discount, startTime, endTime))) {
                    JOptionPane.showMessageDialog(null, "Update success");
                    btnSearch.doClick();
                    txtCode.setText("");
                    btnDelete.setEnabled(false);
                    btnReset.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "Update failed");
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void setDefaultStartTime() {
        SpinnerDateModel sdm1 = (SpinnerDateModel) spStartTime.getModel();
        SpinnerDateModel sdm2 = (SpinnerDateModel) spEndTime.getModel();
        Date minDate = new Date(Calendar.getInstance().getTimeInMillis());
        Date currDate = new Date(Calendar.getInstance().getTimeInMillis() + 300000);
        sdm1.setStart(minDate);
        sdm1.setValue(currDate);
        sdm2.setStart(minDate);
        sdm2.setValue(currDate);
        ((JSpinner.DefaultEditor) spStartTime.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) spEndTime.getEditor()).getTextField().setEditable(false);
    }

    private boolean validate(String code, float discount, Timestamp startTime, Timestamp endTime) {
        boolean check = true;
        if (code.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(null, "Please choose promotion");
        } else {
            if (discount <= 1.0f && discount > 0) {
                msgDiscount.setText("");
            } else {
                msgDiscount.setText("Discount is invalid.");
                check = false;
            }
            if (startTime.getTime() >= endTime.getTime()) {
                msgTime.setText("EndTime must be further than StartTime.");
                check = false;
            } else {
                msgTime.setText("");
            }
        }
        return check;
    }

    private void loadPromotionInfo(String code) {
        PromotionDAO pDAO = new PromotionDAO();
        PromotionDTO pDTO = pDAO.findByPrimaryKey(code);
        if (pDTO != null) {
            txtCode.setText(pDTO.getCode());
            txtDiscount.setText(Integer.toString(Math.round(pDTO.getDiscount() * 100)));
            spStartTime.setValue(pDTO.getStartTime());
            spEndTime.setValue(pDTO.getEndTime());
        } else {
            JOptionPane.showMessageDialog(null, "Cannot load promotion information", "System warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPromotionInfo;
    private javax.swing.JLabel lblPromotionList;
    private javax.swing.JLabel msgDiscount;
    private javax.swing.JLabel msgTime;
    private javax.swing.JPanel pnlCarCatInfo;
    private javax.swing.JSpinner spEndTime;
    private javax.swing.JSpinner spStartTime;
    private javax.swing.JTable tblViewPromotion;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDiscount;
    // End of variables declaration//GEN-END:variables
}
