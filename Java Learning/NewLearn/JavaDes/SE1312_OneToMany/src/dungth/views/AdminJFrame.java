/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.views;

import dungth.dao.CategoryDAO;
import dungth.dto.CategoryDTO;
import dungth.pdao.ProductDAO;
import dungth.pdto.ProductDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoang Dung
 */
public class AdminJFrame extends javax.swing.JFrame {

    DefaultTableModel tblModelCategories = null;
    DefaultTableModel tblModelProducts = null;

    /**
     * Creates new form AdminJFrame
     */
    public AdminJFrame() {
        initComponents();
        MyInit();
    }

    private void MyInit() {
        try {
            tblModelCategories = (DefaultTableModel) tblViewCategoies.getModel();
            loadCategory();
            tblModelProducts = (DefaultTableModel) tblViewProducts.getModel();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void showCategory(List<CategoryDTO> list) {
        try {
            tblModelCategories.setRowCount(0);
            for (CategoryDTO categoryDTO : list) {
                tblModelCategories.addRow(categoryDTO.toVector());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void showProduct(List<ProductDTO> list) {
        try {
            tblModelProducts.setRowCount(0);
            for (ProductDTO productDTO : list) {
                tblModelProducts.addRow(productDTO.toVector());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void loadCategory() {
        try {
            //Goi model
            CategoryDAO cateDAO = new CategoryDAO();
            List<CategoryDTO> result = cateDAO.loadAllCategory();
            showCategory(result);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void loadCboCategory(ProductDTO dto) {
            try {
                cboCategory.removeAllItems();
                CategoryDAO dao = new CategoryDAO();
                List<CategoryDTO> list = dao.loadAllCategory();
                for (CategoryDTO categoryDTO : list) {
                    cboCategory.addItem(categoryDTO.getId() + " " + categoryDTO.getName());
                    if(dto.getCateID().equals(categoryDTO.getId())) {
                        cboCategory.setSelectedItem(categoryDTO.getId() + " " + categoryDTO.getName());
                    }
                }
            } catch (Exception e) {
                
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewCategoies = new javax.swing.JTable();
        btnCategoryDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblViewProducts = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtProDes = new javax.swing.JTextArea();
        txtProID = new javax.swing.JTextField();
        txtProName = new javax.swing.JTextField();
        txtProQuantity = new javax.swing.JTextField();
        cboCategory = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("One To Many");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("category"));

        tblViewCategoies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblViewCategoies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewCategoiesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblViewCategoies);

        btnCategoryDelete.setText("Delete");
        btnCategoryDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCategoryDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnCategoryDelete)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Product"));

        tblViewProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblViewProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewProductsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblViewProducts);

        jLabel2.setText("ID:");

        jLabel3.setText("Name:");

        jLabel4.setText("Description:");

        jLabel5.setText("Quantity:");

        jLabel6.setText("Category:");

        txtProDes.setColumns(20);
        txtProDes.setRows(5);
        jScrollPane3.setViewportView(txtProDes);

        cboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInsert)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProID)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(txtProName))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btnInsert)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(525, 525, 525)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblViewCategoiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewCategoiesMouseClicked
        // TODO add your handling code here:

        try {
            int row = tblViewCategoies.getSelectedRow();
            String cateID = (String) tblModelCategories.getValueAt(row, 0);
            ProductDAO proDAO = new ProductDAO();
            List<ProductDTO> result = proDAO.loadProductsByCategoryID(cateID);
            showProduct(result);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblViewCategoiesMouseClicked

    private void tblViewProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewProductsMouseClicked
        try {
            // TODO add your handling code here:
            int row = tblViewProducts.getSelectedRow();
            String proID = (String)tblModelProducts.getValueAt(row, 0);
            ProductDAO proDAO = new ProductDAO();
            ProductDTO dto = proDAO.findByPrimaryKey(proID);
            
            txtProID.setText(dto.getId());
            txtProDes.setText(dto.getDes());
            txtProName.setText(dto.getName());
            txtProQuantity.setText(dto.getQuantity() + "");
            loadCboCategory(dto);
        } catch (Exception ex) {
            Logger.getLogger(AdminJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblViewProductsMouseClicked

    private void btnCategoryDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryDeleteActionPerformed
        try {
            // TODO add your handling code here:
            int rowCate = tblViewCategoies.getSelectedRow();
            String cateID = (String) tblViewCategoies.getValueAt(rowCate, 0);
            
            ProductDAO proDAO = new ProductDAO();
            List<ProductDTO> listProDuct = proDAO.loadProductsByCategoryID(cateID);
            if(listProDuct.size() > 0) {
                JOptionPane.showMessageDialog(null, "Can't delete...");
            } else {
                CategoryDAO cateDAO = new CategoryDAO();
                if(cateDAO.delete(cateID)) {
                    JOptionPane.showMessageDialog(null, "Delete Success");
                    tblModelCategories.removeRow(rowCate);
                }
            }
//            if(proDAO.deleteAllByCateID(cateID)) {
//                JOptionPane.showMessageDialog(null, "Delete Success");
//                tblModelProducts.setRowCount(0);
//                tblModelCategories.removeRow(rowCate);
//            }
//            List<ProductDTO> listProDuct = proDAO.loadProductsByCategoryID(cateID);
//            for (ProductDTO productDTO : listProDuct) {
//                proDAO.deleteAllByCateID(cateID);
//            }
        } catch (Exception ex) {
            Logger.getLogger(AdminJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCategoryDeleteActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String id = txtProID.getText();
        String name = txtProName.getText();
        String des = txtProDes.getText();
        int quantity = Integer.parseInt(txtProQuantity.getText()); 
        String txtCbo = cboCategory.getSelectedItem().toString();
        String[] tmp = txtCbo.split(" ");
        ProductDTO dto = new ProductDTO(id, name, quantity);
        dto.setDes(des);
        String cateID = tmp[0];
        dto.setCateID(cateID);
        try {
            ProductDAO dao = new ProductDAO();
            if(dao.insert(dto)) {
                JOptionPane.showMessageDialog(null, "Insert success");
                tblModelProducts.addRow(dto.toVector());
            }
        } catch (Exception e) {
            if(e.getMessage().contains("duplicate")) {
                JOptionPane.showMessageDialog(null,id + " is Existed");
            } else {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

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
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategoryDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblViewCategoies;
    private javax.swing.JTable tblViewProducts;
    private javax.swing.JTextArea txtProDes;
    private javax.swing.JTextField txtProID;
    private javax.swing.JTextField txtProName;
    private javax.swing.JTextField txtProQuantity;
    // End of variables declaration//GEN-END:variables
}
