/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.gui;

import anhht.daos.AdminDAO;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author tuana
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        blink().start();
    }

    public Thread blink() {
        return new Thread() {
            @Override
            public void run() {
                lblBlink.setVisible(false);
                while (true) {
                    try {
                        lblBlink.setVisible(true);
                        sleep(200);
                        lblBlink.setVisible(false);
                        sleep(200); 
                        lblBlink.setVisible(true);
                        sleep(200);
                        lblBlink.setVisible(false);
                        sleep(2000);
                    } catch (InterruptedException ex) {
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

        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnSignIn = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        lblBlink = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(570, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(102, 255, 102));
        lblTitle.setLabelFor(this);
        lblTitle.setText("SAIGON BOOKING TRAVEL CAR");
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 150, 370, -1));

        lblUsername.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(102, 255, 102));
        lblUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/avatar-user-profile2.png"))); // NOI18N
        getContentPane().add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 60, 70));

        lblPass.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblPass.setForeground(new java.awt.Color(102, 255, 102));
        lblPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/1444036584_lock_security_password_secure_connecton_protection_flat_icon_symbol.png"))); // NOI18N
        getContentPane().add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 60, 60));

        txtUsername.setBackground(new java.awt.Color(204, 255, 255));
        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 51, 51));
        txtUsername.setSelectedTextColor(new java.awt.Color(255, 51, 51));
        txtUsername.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 260, -1));

        btnSignIn.setBackground(new java.awt.Color(204, 204, 204));
        btnSignIn.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnSignIn.setForeground(new java.awt.Color(255, 0, 51));
        btnSignIn.setMnemonic('S');
        btnSignIn.setText("Sign In");
        btnSignIn.setBorder(null);
        btnSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 120, 50));

        txtPass.setBackground(new java.awt.Color(204, 255, 255));
        txtPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 51, 51));
        txtPass.setSelectedTextColor(new java.awt.Color(255, 51, 51));
        txtPass.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 260, -1));

        lblBlink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/f9a7628c5db9bda0c201c9ad5b326215.png"))); // NOI18N
        getContentPane().add(lblBlink, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 210, 70));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/6d230b748b (1).png"))); // NOI18N
        lblLogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 130, 130));

        lblBackground.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anhht/imgs/y1ostvqnr4711.jpg"))); // NOI18N
        lblBackground.setLabelFor(this);
        lblBackground.setOpaque(true);
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 600, 580));

        setSize(new java.awt.Dimension(509, 523));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String password = new String(txtPass.getPassword());
        String usernamePattern = "[\\w]{7,}";
        String passPattern = "(?=.*\\d)(?=.*[a-zA-Z])[\\w]{8,}";
        String msg = "";
        if (!username.matches(usernamePattern)) {
            msg += "Username must be 7 or more alphanumberic characters.\n";
        }
        if (!password.matches(passPattern)) {
            msg += "Password must be 8 or more alphanumberic characters "
                    + "including at least 1 letter and 1 numberic letter.";
        }

        if (msg.equals("")) {
            AdminDAO adDAO = new AdminDAO();
            if (adDAO.findByUserNameAndPassword(username, password)) {
                new AdminJFrame().setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Username or password incorrect!", "Sign In Failed!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, msg, "Wrong input format!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        // TODO add your handling code here:
        txtUsername.setBackground(new Color(204, 255, 255));
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        // TODO add your handling code here:
        txtUsername.setBackground(Color.white);
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        // TODO add your handling code here:
        txtPass.setBackground(Color.white);
    }//GEN-LAST:event_txtPassFocusGained

    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost
        // TODO add your handling code here:
        txtPass.setBackground(new Color(204, 255, 255));
    }//GEN-LAST:event_txtPassFocusLost

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
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignIn;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBlink;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
