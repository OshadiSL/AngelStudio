/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.edu.angelStudio.controller.ManageDesignController;
import lk.ijse.edu.angleStudio.model.DesginDTO;

/**
 *
 * @author Oshadi
 */
public class ManageDesigne extends javax.swing.JFrame {

    /**
     * Creates new form ManageCamara
     */
    public ManageDesigne() {
        initComponents();
        setLocationRelativeTo(null);
        loosAllDesing();
        tblDesigne.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                if (tblDesigne.getSelectedRow() == -1) {
                    return;
                }
                txtDesigneID.setText((String) tblDesigne.getValueAt(tblDesigne.getSelectedRow(), 0));
                txtDesigneName.setText((String) tblDesigne.getValueAt(tblDesigne.getSelectedRow(), 1));
                txtDesigneSize.setText(tblDesigne.getValueAt(tblDesigne.getSelectedRow(), 2).toString());
                txtDesignePrice.setText(tblDesigne.getValueAt(tblDesigne.getSelectedRow(), 3).toString());
                txtDesigneQty.setText(tblDesigne.getValueAt(tblDesigne.getSelectedRow(), 4).toString());
                
            }
        });
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
        jLabel1 = new javax.swing.JLabel();
        lblDesigneReport = new javax.swing.JLabel();
        txtDesigneID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDesigneName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDesigneSize = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDesignePrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDesigneQty = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblDesigneID = new javax.swing.JLabel();
        lblDesigneName = new javax.swing.JLabel();
        lblDesigneSave = new javax.swing.JLabel();
        lbDesigneUpdate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDesigne = new javax.swing.JTable();
        lblDesigneRemove = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(59, 163, 163));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Designe");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 50));

        lblDesigneReport.setBackground(new java.awt.Color(0, 204, 204));
        lblDesigneReport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesigneReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesigneReport.setText("Get Report");
        lblDesigneReport.setOpaque(true);
        jPanel1.add(lblDesigneReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 370, 100, 30));

        txtDesigneID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDesigneID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesigneIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtDesigneID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 190, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Designe Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 30));

        txtDesigneName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDesigneName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesigneNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtDesigneName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 190, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Designe Size");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 30));

        txtDesigneSize.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDesigneSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesigneSizeActionPerformed(evt);
            }
        });
        jPanel1.add(txtDesigneSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 220, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Designe Price");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 30));

        txtDesignePrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDesignePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesignePriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtDesignePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 220, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Qty On Hand");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 30));

        txtDesigneQty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDesigneQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesigneQtyActionPerformed(evt);
            }
        });
        jPanel1.add(txtDesigneQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 220, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Designe ID");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 30));

        lblDesigneID.setBackground(new java.awt.Color(0, 204, 204));
        lblDesigneID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesigneID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesigneID.setText("S");
        lblDesigneID.setOpaque(true);
        jPanel1.add(lblDesigneID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 30, 30));

        lblDesigneName.setBackground(new java.awt.Color(0, 204, 204));
        lblDesigneName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesigneName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesigneName.setText("S");
        lblDesigneName.setOpaque(true);
        jPanel1.add(lblDesigneName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 30, 30));

        lblDesigneSave.setBackground(new java.awt.Color(0, 204, 204));
        lblDesigneSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesigneSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesigneSave.setText("Save");
        lblDesigneSave.setOpaque(true);
        lblDesigneSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDesigneSaveMouseClicked(evt);
            }
        });
        jPanel1.add(lblDesigneSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 30));

        lbDesigneUpdate.setBackground(new java.awt.Color(0, 204, 204));
        lbDesigneUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbDesigneUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDesigneUpdate.setText("Update");
        lbDesigneUpdate.setOpaque(true);
        lbDesigneUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDesigneUpdateMouseClicked(evt);
            }
        });
        jPanel1.add(lbDesigneUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 100, 30));

        tblDesigne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Designe ID", "Designe Name", "Designe Size", "Designe Price", "Qty On Hand"
            }
        ));
        jScrollPane1.setViewportView(tblDesigne);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 590, 290));

        lblDesigneRemove.setBackground(new java.awt.Color(0, 204, 204));
        lblDesigneRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesigneRemove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesigneRemove.setText("Remove");
        lblDesigneRemove.setOpaque(true);
        lblDesigneRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDesigneRemoveMouseClicked(evt);
            }
        });
        jPanel1.add(lblDesigneRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDesigneSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesigneSaveMouseClicked
        try {
            String id = txtDesigneID.getText();
            String name = txtDesigneName.getText();
            String size = txtDesigneSize.getText();
            double price = Double.parseDouble(txtDesignePrice.getText());
            int qty = Integer.parseInt(txtDesigneQty.getText());
            DesginDTO desgin = new DesginDTO(id, name, size, price, qty);
            boolean isAdded = ManageDesignController.addDising(desgin);
            if (isAdded) {
                JOptionPane.showMessageDialog(null, "Add a desingetype ");
                DefaultTableModel dtm = (DefaultTableModel) tblDesigne.getModel();
                Object[] rowData = {id, name, size, price, qty};
                dtm.addRow(rowData);
                txt();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageDesigne.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lblDesigneSaveMouseClicked

    private void lblDesigneRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesigneRemoveMouseClicked
        try {
            if (tblDesigne.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Select a Row");
            }
            boolean isDelete = ManageDesignController.delete(tblDesigne.getValueAt(tblDesigne.getSelectedRow(), 0).toString());
            loosAllDesing();
            txt();
        } catch (Exception ex) {
            Logger.getLogger(ManageDesigne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblDesigneRemoveMouseClicked

    private void lbDesigneUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDesigneUpdateMouseClicked
        try {
            String id = txtDesigneID.getText();
            String name = txtDesigneName.getText();
            String size = txtDesigneSize.getText();
            double price = Double.parseDouble(txtDesignePrice.getText());
            int qty = Integer.parseInt(txtDesigneQty.getText());
            DesginDTO desgin = new DesginDTO(id, name, size, price, qty);
            boolean isUpdate = ManageDesignController.dudate(desgin);
            if (isUpdate) {
                JOptionPane.showMessageDialog(null, "Update a desingetype ");
                loosAllDesing();
                txt();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageDesigne.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lbDesigneUpdateMouseClicked

    private void txtDesigneIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesigneIDActionPerformed
        txtDesigneName.requestFocusInWindow();
    }//GEN-LAST:event_txtDesigneIDActionPerformed

    private void txtDesigneNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesigneNameActionPerformed
        txtDesigneSize.requestFocusInWindow();
    }//GEN-LAST:event_txtDesigneNameActionPerformed

    private void txtDesigneSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesigneSizeActionPerformed
       txtDesignePrice.requestFocusInWindow();
    }//GEN-LAST:event_txtDesigneSizeActionPerformed

    private void txtDesignePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesignePriceActionPerformed
       txtDesigneQty.requestFocusInWindow();
    }//GEN-LAST:event_txtDesignePriceActionPerformed

    private void txtDesigneQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesigneQtyActionPerformed
          try {
            String id = txtDesigneID.getText();
            String name = txtDesigneName.getText();
            String size = txtDesigneSize.getText();
            double price = Double.parseDouble(txtDesignePrice.getText());
            int qty = Integer.parseInt(txtDesigneQty.getText());
            DesginDTO desgin = new DesginDTO(id, name, size, price, qty);
            boolean isAdded = ManageDesignController.addDising(desgin);
            if (isAdded) {
                JOptionPane.showMessageDialog(null, "Add a desingetype ");
                DefaultTableModel dtm = (DefaultTableModel) tblDesigne.getModel();
                Object[] rowData = {id, name, size, price, qty};
                dtm.addRow(rowData);
                txt();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageDesigne.class.getName()).log(Level.SEVERE, null, ex);
        }

              
    }//GEN-LAST:event_txtDesigneQtyActionPerformed

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
            java.util.logging.Logger.getLogger(ManageDesigne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageDesigne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageDesigne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageDesigne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageDesigne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDesigneUpdate;
    private javax.swing.JLabel lblDesigneID;
    private javax.swing.JLabel lblDesigneName;
    private javax.swing.JLabel lblDesigneRemove;
    private javax.swing.JLabel lblDesigneReport;
    private javax.swing.JLabel lblDesigneSave;
    private javax.swing.JTable tblDesigne;
    private javax.swing.JTextField txtDesigneID;
    private javax.swing.JTextField txtDesigneName;
    private javax.swing.JTextField txtDesignePrice;
    private javax.swing.JTextField txtDesigneQty;
    private javax.swing.JTextField txtDesigneSize;
    // End of variables declaration//GEN-END:variables

    private void loosAllDesing() {
        try {
            ArrayList<DesginDTO> addDesing = ManageDesignController.getAllDising();
            DefaultTableModel dtm = (DefaultTableModel) tblDesigne.getModel();
            dtm.setRowCount(0);
            for (DesginDTO desgin : addDesing) {
                Object[] rowData = {desgin.getDid(), desgin.getType(), desgin.getSize(), desgin.getPrice(), desgin.getQty()};
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageDesigne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void txt() {
        txtDesigneID.setText("");
        txtDesigneName.setText("");
        txtDesigneSize.setText("");
        txtDesignePrice.setText("");
        txtDesigneQty.setText("");
        
    }
}