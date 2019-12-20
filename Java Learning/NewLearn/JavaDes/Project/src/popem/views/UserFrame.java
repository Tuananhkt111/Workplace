/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import popem.daos.AccountDAO;
import popem.daos.ClassDAO;
import popem.dtos.AccountDTO;
import popem.dtos.ClassDTO;

/**
 *
 * @author popem
 */
public class UserFrame extends javax.swing.JFrame {
    private String username;
    /**
     * Creates new form UserFrame
     */
    public UserFrame(String username) {
        this.username = username;
        initComponents();
        setPreferredSize(new Dimension(1206,729));
        effect().start();
        effectBg().start();
        effectColor().start();
        AccountDAO accountDAO = new AccountDAO();
        try {
            AccountDTO accountDTO = accountDAO.findByPrimaryKey(this.username);
            if (accountDTO.getCharacterName()==null){
                JOptionPane.showMessageDialog(this, "This is your first time logging in.\nPlease Create your character.");
                JPanel jpanel = new CharacterCreationPanel(username, this);
                this.pnlMain.add(jpanel, BorderLayout.WEST);
            } else {
                ClassDTO classDTO = new ClassDAO().findByPrimaryKey(accountDTO.getCharacterClass());
                lblCharacterAvatar.setIcon(new ImageIcon(getClass().getResource("/popem/img/"+classDTO.getName()+".png")));
                lblCharacterAvatarBG.setIcon(new ImageIcon(getClass().getResource("/popem/img/"+classDTO.getName()+"_bg.png")));
                this.pnlMain.add(new PlayingPanel(this.username, classDTO, this));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error logging in!");
        }

    }
    
    public UserFrame() {
        initComponents();
        effect().start();
        JPanel jpanel = new CharacterCreationPanel(username, this);
        this.pnlMain.add(jpanel, BorderLayout.WEST);
        effectBg().start();
        effectColor().start();
    }
    
    public Thread effect(){
        return new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        for (int i = 0; i < 5; i++) {
                            for (int j = 0; j < 120; j++) {
                                Effect.setLocation(Effect.getLocation().x + 10, Effect.getLocation().y);
                                sleep(3*i+5);
                            }
                            Effect.setLocation(-Effect.getWidth(), 60);
                        }
                        for (int i = 4; i >= 0; i--) {
                            for (int j = 0; j < 120; j++) {
                                Effect.setLocation(Effect.getLocation().x + 10, Effect.getLocation().y);
                                sleep(3*i+5);
                            }
                            Effect.setLocation(-Effect.getWidth(), 60);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                    
            }
            };
    }
    public Thread effectBg(){
        return new Thread(){
            @Override
            public void run() {
                try {
                    while (true){
                        for (int i = 0; i < 200; i++) {
                            EffectBG.setLocation(EffectBG.getLocation().x - 5, EffectBG.getLocation().y);
                            sleep(30);
                        }
                        EffectBG.setLocation(400, 210);
                    }
                } catch (InterruptedException ex) {
                            Logger.getLogger(UserFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        };
    }
    
    private Thread effectColor(){
        return new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        int a = 5;
                        for(int i = 0; i < 256; i++){
                            lblColor.setBackground(new Color(i, 255, 100));
                            sleep(a);
                        }
                        for(int i = 255; i >-1; i--){
                            lblColor.setBackground(new Color(255, i, 100));
                            sleep(a);
                        }
                        for(int i = 255; i >99; i--){
                            lblColor.setBackground(new Color(255, 0, i));
                            sleep(a);
                        }
                        for(int i = 255; i >-1; i--){
                            lblColor.setBackground(new Color(i, 0, 100));
                            sleep(a);
                        }
                        for(int i = 0; i < 256; i++){
                            lblColor.setBackground(new Color(0, i, 100));
                            sleep(a);
                        }
                    } catch (Exception e){
                        
                    }
                }
                    
            }
        };
    }

    public JLabel getLblCharacterAvatar() {
        return lblCharacterAvatar;
    }

    public void setLblCharacterAvatar(JLabel lblCharacterAvatar) {
        this.lblCharacterAvatar = lblCharacterAvatar;
    }

    public JLabel getLblCharacterAvatarBG() {
        return lblCharacterAvatarBG;
    }

    public void setLblCharacterAvatarBG(JLabel lblCharacterAvatarBG) {
        this.lblCharacterAvatarBG = lblCharacterAvatarBG;
    }

    public JPanel getPnlMain() {
        return pnlMain;
    }

    public void setPnlMain(JPanel pnlMain) {
        this.pnlMain = pnlMain;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblColor = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        lblCharacterAvatar = new javax.swing.JLabel();
        heading = new javax.swing.JLabel();
        Effect = new javax.swing.JLabel();
        EffectBG = new javax.swing.JLabel();
        lblCharacterAvatarBG = new javax.swing.JLabel();
        behind_heading = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OASIS");
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblColor.setBackground(new java.awt.Color(255, 204, 102));
        lblColor.setOpaque(true);
        getContentPane().add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 233, 734, 5));

        pnlMain.setOpaque(false);
        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        lblCharacterAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/popem/img/Elf.png"))); // NOI18N
        getContentPane().add(lblCharacterAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 400, 580));

        heading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/popem/img/HEADING.png"))); // NOI18N
        getContentPane().add(heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        Effect.setBackground(new java.awt.Color(255, 255, 255));
        Effect.setOpaque(true);
        getContentPane().add(Effect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 50, 170));

        EffectBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/popem/img/WinningEffect.png"))); // NOI18N
        getContentPane().add(EffectBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 600, 490));

        lblCharacterAvatarBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/popem/img/Elf_bg.png"))); // NOI18N
        getContentPane().add(lblCharacterAvatarBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 420, 580));

        behind_heading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/popem/img/heading_behind.png"))); // NOI18N
        getContentPane().add(behind_heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Effect;
    private javax.swing.JLabel EffectBG;
    private javax.swing.JLabel behind_heading;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel lblCharacterAvatar;
    private javax.swing.JLabel lblCharacterAvatarBG;
    private javax.swing.JLabel lblColor;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
