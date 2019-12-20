package ex2;
import javax.swing.JOptionPane;
public class NewJFrame extends javax.swing.JFrame
{ 
    private boolean isPassed = false;
    public NewJFrame()
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        groupSex = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addStudent = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        show = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        maleButton = new javax.swing.JRadioButton();
        femaleButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");

        jLabel2.setText("ID:");

        jLabel3.setText("Male:");

        jLabel5.setText("Mark:");

        jLabel6.setText("Phone number:");

        jLabel7.setText("Address:");

        jLabel8.setText("Date of birth:");

        addStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ex2/if_199_CircledPlus_183316.png"))); // NOI18N
        addStudent.setText("Add Student");
        addStudent.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ex2/if_Plus_206460.png"))); // NOI18N
        addStudent.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ex2/if_Plus_206460.png"))); // NOI18N
        addStudent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addStudentActionPerformed(evt);
            }
        });

        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ex2/if_Reset_40005.png"))); // NOI18N
        reset.setText("Reset");
        reset.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ex2/if_Reset_40149.png"))); // NOI18N
        reset.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ex2/if_Reset_40149.png"))); // NOI18N
        reset.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                resetActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("STUDENT INFORMATION");

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ex2/if_23_slide_show_presentation_google_file_service_2109189.png"))); // NOI18N
        show.setSelected(true);
        show.setText("Unshow");
        show.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ex2/if_23_slide_show_presentation_google_file_service_2109108.png"))); // NOI18N
        show.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ex2/if_23_slide_show_presentation_google_file_service_2109189.png"))); // NOI18N
        show.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ex2/if_23_slide_show_presentation_google_file_service_2109108.png"))); // NOI18N
        show.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                showItemStateChanged(evt);
            }
        });
        show.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                showActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel9.setText("Female:");

        groupSex.add(maleButton);
        maleButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                maleButtonActionPerformed(evt);
            }
        });

        groupSex.add(femaleButton);
        femaleButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                femaleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(femaleButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(addStudent)
                .addGap(66, 66, 66)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(show)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(maleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(femaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(show)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_resetActionPerformed
    {//GEN-HEADEREND:event_resetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

    private void addStudentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addStudentActionPerformed
    {//GEN-HEADEREND:event_addStudentActionPerformed
        if(isPassed == true)
            isPassed = true;
        else 
        {
            JOptionPane.showInputDialog("PassWord:");
        }       
    }//GEN-LAST:event_addStudentActionPerformed

    private void showActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_showActionPerformed
    {//GEN-HEADEREND:event_showActionPerformed
        
    }//GEN-LAST:event_showActionPerformed

    private void showItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_showItemStateChanged
    {//GEN-HEADEREND:event_showItemStateChanged
        if(show.isSelected())
        {
            show.setText("Unshow");
            table.setVisible(true);
        }
        else 
        {
            show.setText("Show");
            table.setVisible(false);
        }
    }//GEN-LAST:event_showItemStateChanged

    private void maleButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_maleButtonActionPerformed
    {//GEN-HEADEREND:event_maleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleButtonActionPerformed

    private void femaleButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_femaleButtonActionPerformed
    {//GEN-HEADEREND:event_femaleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleButtonActionPerformed

    public static void main(String args[])
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new NewJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudent;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.ButtonGroup groupSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JButton reset;
    private javax.swing.JToggleButton show;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
