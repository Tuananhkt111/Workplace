/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.views;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import popem.daos.AccountDAO;
import popem.daos.InventoryDAO;
import popem.daos.RegistrationDAO;
import popem.dtos.AccountDTO;
import popem.dtos.InventoryDTO;

/**
 *
 * @author popem
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        glitch().start();
        glitch2().start();
    }
    
    
    public Thread glitch(){
        return new Thread(){
            @Override
            public void run() {
                white2.setVisible(false);
                white1.setVisible(false);
                while(true){
                    try {
                        gl.setVisible(false);
                        for (int i = 0;i<4;i++){
                            purp.setVisible(true);
                            sleep(90);
                            purp.setVisible(false);  
                            sleep(50);
                            purp1.setVisible(true);
                            sleep(90);
                            purp1.setVisible(false);
                            white2.setVisible(true);
                            sleep(100);
                            white2.setVisible(false);
                            sleep(900);
                            white.setVisible(true);
                            sleep(120);
                            white1.setVisible(true);
                            sleep(70);
                            white.setVisible(false);  
                            white1.setVisible(false);
                            sleep(1200);
                        }
                        purp.setVisible(true);
                        sleep(90);
                        purp.setVisible(false);
                        purp1.setVisible(true);
                        sleep(20);
                        purp1.setVisible(false);
                        white.setVisible(true);
                        sleep(50);
                        white.setVisible(false);
                        white1.setVisible(true);
                        sleep(90);
                        white1.setVisible(false);
                        gl.setVisible(true);
                        white2.setVisible(true);
                        sleep(120);
                        white2.setVisible(false);
                        gl.setVisible(false);
                            
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
    }
    public Thread glitch2(){
        return new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        for(int i = 0; i< 3; i++){
                            gl2.setVisible(true);
                            sleep(150);
                            gl2.setVisible(false);
                            sleep(2000);
                        }
                        sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnRegister2 = new javax.swing.JButton();
        btnRegister1 = new javax.swing.JButton();
        purp = new javax.swing.JLabel();
        white = new javax.swing.JLabel();
        white2 = new javax.swing.JLabel();
        white1 = new javax.swing.JLabel();
        purp1 = new javax.swing.JLabel();
        gl = new javax.swing.JLabel();
        gl2 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("X");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 50, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtUsername.setOpaque(false);
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtUsernameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtUsernameMouseExited(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 260, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 20));

        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 260, -1));

        btnRegister2.setBackground(new java.awt.Color(51, 51, 51));
        btnRegister2.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        btnRegister2.setForeground(new java.awt.Color(204, 204, 204));
        btnRegister2.setText("Sign in");
        btnRegister2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 2), javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new javax.swing.ImageIcon(getClass().getResource("/popem/img/Border.png"))))); // NOI18N
        btnRegister2.setContentAreaFilled(false);
        btnRegister2.setMargin(new java.awt.Insets(20, 14, 20, 14));
        btnRegister2.setOpaque(true);
        btnRegister2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegister2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegister2MouseExited(evt);
            }
        });
        btnRegister2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegister2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 90, 30));

        btnRegister1.setBackground(new java.awt.Color(51, 51, 51));
        btnRegister1.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        btnRegister1.setForeground(new java.awt.Color(153, 153, 153));
        btnRegister1.setText("Register");
        btnRegister1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 2), javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new javax.swing.ImageIcon(getClass().getResource("/popem/img/Border.png"))))); // NOI18N
        btnRegister1.setContentAreaFilled(false);
        btnRegister1.setMargin(new java.awt.Insets(20, 14, 20, 14));
        btnRegister1.setOpaque(true);
        btnRegister1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegister1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegister1MouseExited(evt);
            }
        });
        btnRegister1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegister1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 90, 30));

        purp.setBackground(new java.awt.Color(204, 102, 255));
        purp.setOpaque(true);
        getContentPane().add(purp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 30, 10));

        white.setBackground(new java.awt.Color(255, 255, 255));
        white.setOpaque(true);
        getContentPane().add(white, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 210, 4));

        white2.setBackground(new java.awt.Color(255, 255, 255));
        white2.setOpaque(true);
        getContentPane().add(white2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 110, 2));

        white1.setBackground(new java.awt.Color(255, 255, 255));
        white1.setOpaque(true);
        getContentPane().add(white1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 3));

        purp1.setBackground(new java.awt.Color(204, 102, 255));
        purp1.setOpaque(true);
        getContentPane().add(purp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 100, 5));

        gl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/popem/img/gl.png"))); // NOI18N
        getContentPane().add(gl, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 80, -1, 20));

        gl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/popem/img/gl2.png"))); // NOI18N
        gl2.setText("jLabel1");
        gl2.setAlignmentY(0.0F);
        getContentPane().add(gl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 110, -1, -1));

        background.setFont(new java.awt.Font("Sylfaen", 2, 11)); // NOI18N
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/popem/img/Untitled-1.png"))); // NOI18N
        background.setMaximumSize(new java.awt.Dimension(398, 330));
        background.setMinimumSize(new java.awt.Dimension(398, 330));
        background.setPreferredSize(new java.awt.Dimension(398, 330));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameMouseEntered

    private void txtUsernameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameMouseExited

    private void btnRegister1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegister1MouseEntered
        // TODO add your handling code here:
        btnRegister1.setBackground(new Color(153,0,51));
    }//GEN-LAST:event_btnRegister1MouseEntered

    private void btnRegister1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegister1MouseExited
        // TODO add your handling code here:
        btnRegister1.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_btnRegister1MouseExited

    private void btnRegister1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegister1ActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String  password = new String(txtPassword.getPassword());
        String validate = "";
        
        if(username.length() == 0) validate += "Username can't be blank!\n";
        if(password.length() == 0) validate += "Password can't be blank!\n";
        
        if(validate.equals("")) {
            try {
                RegistrationDAO dao = new RegistrationDAO();
                String role = dao.findExisting(username);
                if(!role.equals("")) {
                    JOptionPane.showMessageDialog(this, "Username Existed!");
                } else {
                    dao.create(username, password);
                    JOptionPane.showMessageDialog(this, "Congratulations! You have registered successfully!\nPlease login to update account Information.");
                    txtPassword.setText("");
                }    
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error registering account!");
            }
        } else {
            JOptionPane.showMessageDialog(this, validate);
        }
    }//GEN-LAST:event_btnRegister1ActionPerformed

    private void btnRegister2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegister2MouseEntered
        // TODO add your handling code here:
        btnRegister2.setBackground(new Color(51,153,0));
    }//GEN-LAST:event_btnRegister2MouseEntered

    private void btnRegister2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegister2MouseExited
        // TODO add your handling code here:
        btnRegister2.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_btnRegister2MouseExited

    private void btnRegister2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegister2ActionPerformed
        // TODO add your handling code her
        String username = txtUsername.getText();
        String  password = new String(txtPassword.getPassword());
        String validate = "";
        
        if(username.length() == 0) validate += "Username can't be blank!\n";
        if(password.length() == 0) validate += "Password can't be blank!\n";
        
        if(validate.equals("")) {
            try {
                RegistrationDAO dao = new RegistrationDAO();
                String role = dao.findByUsernameAndPassword(username, password);
                if(role.equals("admin")) {
                    this.dispose();
                    new AdminFrame(username).setVisible(true);
                } else if (role.equals("user")){
                    InventoryDAO inventoryDAO = new InventoryDAO();
                    List<InventoryDTO> keyCheckList = inventoryDAO.findByUsername(username);
                    int count = 0;
                    for(InventoryDTO inventoryDTO: keyCheckList){
                        if (inventoryDTO.getItem().matches("I0[1-3]")) count += 1;
                    }
                    if (count == 3){
                        JOptionPane.showMessageDialog(this, "Congratulations! Upon obtaining the Three Keys to Halliday's Easter Eggs\n you are now the eligible Admin of OASIS!");
                        AccountDAO accountDAO = new AccountDAO();
                        try {
                            AccountDTO accountDTO = accountDAO.findByPrimaryKey(username);
                            accountDTO.setRole("admin");
                            accountDAO.update(accountDTO);                        
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Error updating Role!");
                        }
                        this.dispose();
                        new AdminFrame(username).setVisible(true);
                    } else {
                        this.dispose();
                        new UserFrame(username).setVisible(true);                    
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Wrong username or password!");
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, validate);
        }
    }//GEN-LAST:event_btnRegister2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnRegister1;
    private javax.swing.JButton btnRegister2;
    private javax.swing.JLabel gl;
    private javax.swing.JLabel gl2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel purp;
    private javax.swing.JLabel purp1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel white;
    private javax.swing.JLabel white1;
    private javax.swing.JLabel white2;
    // End of variables declaration//GEN-END:variables
}
