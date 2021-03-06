/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.views;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import popem.daos.InventoryDAO;
import popem.daos.ItemDAO;
import popem.dtos.InventoryDTO;
import popem.dtos.ItemDTO;

/**
 *
 * @author popem
 */
public class AddItemFrame extends javax.swing.JFrame {
    private String username = "";
    private DefaultTableModel tableModel = null;
    /**
     * Creates new form AddItemFrame
     */
    public AddItemFrame(String username, DefaultTableModel tableModel) {
        initComponents();
        this.username = username;
        this.tableModel = tableModel;
        ItemDAO dao = new ItemDAO();
        try {
            showItem(dao.findAllItems());
        } catch (Exception ex) {
            Logger.getLogger(AddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private AddItemFrame() {
        initComponents();
        ItemDAO dao = new ItemDAO();
        try {
            showItem(dao.findAllItems());
        } catch (Exception ex) {
            Logger.getLogger(AddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void showItem(List<String> list){
        for (String string : list){
            cbItem.addItem(string); 
        }
    }
    private void showInventory(List<InventoryDTO> list){
        tableModel.setRowCount(0);
        for (InventoryDTO item : list){
            tableModel.addRow(item.toVector());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbItem = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtItemDes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnMissionCreate1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Item:");

        cbItem.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 7, 1, 1, new java.awt.Color(102, 102, 102)));
        cbItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbItemItemStateChanged(evt);
            }
        });
        cbItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbItemActionPerformed(evt);
            }
        });

        jScrollPane4.setBorder(null);

        txtItemDes.setColumns(20);
        txtItemDes.setFont(new java.awt.Font("Mongolian Baiti", 0, 16)); // NOI18N
        txtItemDes.setLineWrap(true);
        txtItemDes.setRows(5);
        txtItemDes.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 7, 0, 0, new java.awt.Color(102, 102, 102)), javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(204, 204, 204))));
        txtItemDes.setEnabled(false);
        jScrollPane4.setViewportView(txtItemDes);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Choose an Item.");

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 153, 51));
        btnAdd.setText("Add");
        btnAdd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 7, 1, 1, new java.awt.Color(0, 0, 0)));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnMissionCreate1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMissionCreate1.setText("Cancel");
        btnMissionCreate1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 7, 1, 1, new java.awt.Color(0, 0, 0)));
        btnMissionCreate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMissionCreate1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Quantity:");

        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(cbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMissionCreate1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMissionCreate1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        jLabel2.setBackground(new java.awt.Color(230, 230, 230));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 400, 220));

        background.setBackground(new java.awt.Color(200, 200, 200));
        background.setOpaque(true);
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbItemItemStateChanged
        // TODO add your handling code here:
        ItemDTO dto;
        ItemDAO dao = new ItemDAO();
        try {
            dto = dao.findByPrimaryKey(cbItem.getSelectedItem().toString().split("-")[0]);
            txtItemDes.setText(dto.toStringDes());
        } catch (Exception ex) {
            Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbItemItemStateChanged

    private void cbItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbItemActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        boolean check = false;
        String validate = "";
        if (txtQuantity.getText().equals("")) validate += "Quantity can't be blank!";
        else {
            try {
                if (Integer.parseInt(txtQuantity.getText())<0) validate += "Point must be positive number!\n";
            } catch (Exception e) {
            validate += "Point must be number!\n";
            }
        }
        if (!validate.equals("")) JOptionPane.showMessageDialog(this, validate);
        else {
            try {
                InventoryDAO dao = new InventoryDAO();
                InventoryDTO dto = dao.findByPrimaryKey(username, cbItem.getSelectedItem().toString().split("-")[0]);
                if (dto!=null){
                    dto.setQuantity(dto.getQuantity()+Integer.parseInt(txtQuantity.getText()));
                    check = dao.update(dto);
                } else {
                    dto = new InventoryDTO(username, cbItem.getSelectedItem().toString().split("-")[0] , Integer.parseInt(txtQuantity.getText()));
                    check = dao.create(dto);
                }
                if (check) JOptionPane.showMessageDialog(this, "Add successful!");
                else JOptionPane.showMessageDialog(this, "Add failed!");
                //view update
                InventoryDAO inDAO = new InventoryDAO();
                ItemDAO iDAO = new ItemDAO();
                List<InventoryDTO> inventory = inDAO.findByUsername(username);
                if (inventory!=null) {
                    for (InventoryDTO item : inventory){
                        item.setItem(item.getItem()+"-"+new ItemDAO().findByPrimaryKey(item.getItem()).getName());
                    }
                }
                showInventory(inventory);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Add failed!");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnMissionCreate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMissionCreate1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnMissionCreate1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnMissionCreate1;
    private javax.swing.JComboBox<String> cbItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea txtItemDes;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
