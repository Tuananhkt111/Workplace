/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.gui.admin.insert;

import anht.daos.EmpDAO;
import anht.dtos.EmployeeDTO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author tuana
 */
public class EmpInsertFrame extends javax.swing.JFrame {

    private JButton btnSearchMain = null;
    private JButton btnDeleteMain = null;
    private JButton btnResetMain = null;
    private JTextField txtSearchMain = null;
    private JTextField txtEmpIDMain = null;

    /**
     * Creates new form EmpInsertFrame
     */
    public EmpInsertFrame() {
        initComponents();
    }

    public EmpInsertFrame(JButton btnSearchMain, JButton btnDeleteMain, JButton btnResetMain, JTextField txtSearchMain, JTextField txtEmpIDMain) {
        initComponents();
        this.btnSearchMain = btnSearchMain;
        this.btnDeleteMain = btnDeleteMain;
        this.btnResetMain = btnResetMain;
        this.txtSearchMain = txtSearchMain;
        this.txtEmpIDMain = txtEmpIDMain;
        ((JSpinner.DefaultEditor) spCertificate.getEditor()).getTextField().setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupSex = new javax.swing.ButtonGroup();
        groupAvailable = new javax.swing.ButtonGroup();
        pnlEmpInfo = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtEmpID = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        msgName = new javax.swing.JLabel();
        msgAge = new javax.swing.JLabel();
        msgPhone = new javax.swing.JLabel();
        rdTrue = new javax.swing.JRadioButton();
        rdFalse = new javax.swing.JRadioButton();
        btnGenerate = new javax.swing.JButton();
        msgEmpID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        spCertificate = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        lblCarInfo = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlEmpInfo.setBackground(new java.awt.Color(204, 255, 153));
        pnlEmpInfo.setForeground(new java.awt.Color(255, 51, 51));
        pnlEmpInfo.setPreferredSize(new java.awt.Dimension(51, 20));
        pnlEmpInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblUsername.setText("EmpID:");
        pnlEmpInfo.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 31, -1, 30));

        txtEmpID.setEditable(false);
        txtEmpID.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtEmpID.setForeground(new java.awt.Color(51, 255, 51));
        txtEmpID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pnlEmpInfo.add(txtEmpID, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 30, 190, -1));

        lblPass.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblPass.setText("Fullname:");
        pnlEmpInfo.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 109, 106, 28));

        lblSex.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblSex.setText("Age:");
        pnlEmpInfo.add(lblSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 270, -1, 50));

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtAge.setForeground(new java.awt.Color(51, 255, 51));
        txtAge.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pnlEmpInfo.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 90, -1));

        lblAge.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblAge.setText("Phone:");
        pnlEmpInfo.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 365, -1, 28));

        rdMale.setBackground(new java.awt.Color(204, 255, 153));
        groupSex.add(rdMale);
        rdMale.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        rdMale.setSelected(true);
        rdMale.setText("Male");
        pnlEmpInfo.add(rdMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        rdFemale.setBackground(new java.awt.Color(204, 255, 153));
        groupSex.add(rdFemale);
        rdFemale.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        rdFemale.setText("Female");
        pnlEmpInfo.add(rdFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblPhone.setText("Available:");
        pnlEmpInfo.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 451, -1, 28));

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(51, 255, 51));
        txtPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pnlEmpInfo.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 190, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblName.setText("Sex:");
        pnlEmpInfo.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 186, -1, 40));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtName.setForeground(new java.awt.Color(51, 255, 51));
        txtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pnlEmpInfo.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 390, -1));

        msgName.setForeground(new java.awt.Color(255, 51, 51));
        pnlEmpInfo.add(msgName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 390, 17));

        msgAge.setForeground(new java.awt.Color(255, 51, 51));
        pnlEmpInfo.add(msgAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 390, 17));

        msgPhone.setForeground(new java.awt.Color(255, 51, 51));
        pnlEmpInfo.add(msgPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 390, 14));

        rdTrue.setBackground(new java.awt.Color(204, 255, 153));
        groupAvailable.add(rdTrue);
        rdTrue.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        rdTrue.setSelected(true);
        rdTrue.setText("True");
        pnlEmpInfo.add(rdTrue, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, -1, -1));

        rdFalse.setBackground(new java.awt.Color(204, 255, 153));
        groupAvailable.add(rdFalse);
        rdFalse.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        rdFalse.setText("False");
        pnlEmpInfo.add(rdFalse, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, -1, -1));

        btnGenerate.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });
        pnlEmpInfo.add(btnGenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 130, -1));

        msgEmpID.setForeground(new java.awt.Color(255, 51, 51));
        pnlEmpInfo.add(msgEmpID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 320, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Certificate:");
        pnlEmpInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, 50));

        spCertificate.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        spCertificate.setModel(new javax.swing.SpinnerNumberModel(2, 2, 100, 1));
        pnlEmpInfo.add(spCertificate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("MaxSeats");
        pnlEmpInfo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, 50));

        getContentPane().add(pnlEmpInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 660, 590));

        lblCarInfo.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblCarInfo.setText("Employee Info");
        getContentPane().add(lblCarInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 690, 120, -1));

        btnInsert.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 690, 120, -1));

        setSize(new java.awt.Dimension(906, 858));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtEmpID.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtAge.setText("");
        rdMale.setSelected(true);
        msgEmpID.setText("");
        msgName.setText("");
        msgPhone.setText("");
        msgAge.setText("");
        rdTrue.setSelected(true);
        spCertificate.setValue(2);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String empID = txtEmpID.getText();
        String fullname = txtName.getText();
        String phone = txtPhone.getText();
        boolean sex = rdMale.isSelected();
        boolean available = rdTrue.isSelected();
        int age = 0;
        int certificate = 0;
        try {
            age = Integer.parseInt(txtAge.getText());
        } catch (NumberFormatException e) {
        }
        try {
            certificate = (Integer) spCertificate.getValue();
        } catch (NumberFormatException e) {
        }
        EmpDAO empDAO = new EmpDAO();
        if (validate(empID, fullname, phone, age)) {
            if (empDAO.insert(new EmployeeDTO(empID, fullname, phone, sex, available, age, certificate))) {
                JOptionPane.showMessageDialog(null, "Insert success");
                btnDeleteMain.setEnabled(false);
                txtSearchMain.setText("");
                btnSearchMain.doClick();
                btnResetMain.doClick();
                txtEmpIDMain.setText("");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Insert failed");
            }

        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:
        String NumericString = "0123456789";
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(5);
        EmpDAO empDAO = new EmpDAO();
        String result = null;
        do {
            for (int i = 0; i < 5; i++) {
                // generate a random number between 
                // 0 to NumericString variable length 
                int index = (int) (NumericString.length() * Math.random());
                // add Character one by one in end of sb 
                sb.append(NumericString.charAt(index));
            }
            result ="E" + sb.toString();
        } while(empDAO.findExisting(result));
        txtEmpID.setText(result);
    }//GEN-LAST:event_btnGenerateActionPerformed

    private boolean validate(String empID, String fullname, String phone, int age) {
        boolean check = true;
        String phonePattern = "\\d{10}";
        if(empID.equals("")) {
            msgEmpID.setText("Press Generate button to get an ID.");
            check = false;
        } else {
            msgEmpID.setText("");
        }
        if (fullname.equals("")) {
            msgName.setText("Full name is not empty.");
            check = false;
        } else {
            msgName.setText("");
        }
        if (!phone.matches(phonePattern)) {
            msgPhone.setText("Phone is the sequence of 10 digits.");
            check = false;
        } else {
            msgPhone.setText("");
        }

        if (age < 1) {
            msgAge.setText("Age is a positive number");
            check = false;
        } else {
            msgAge.setText("");
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
            java.util.logging.Logger.getLogger(EmpInsertFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpInsertFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpInsertFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpInsertFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpInsertFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.ButtonGroup groupAvailable;
    private javax.swing.ButtonGroup groupSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCarInfo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel msgAge;
    private javax.swing.JLabel msgEmpID;
    private javax.swing.JLabel msgName;
    private javax.swing.JLabel msgPhone;
    private javax.swing.JPanel pnlEmpInfo;
    private javax.swing.JRadioButton rdFalse;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JRadioButton rdTrue;
    private javax.swing.JSpinner spCertificate;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmpID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
