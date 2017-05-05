/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journalbrowserjdbc;

import control.AbstractService;
import entities.Assessment;
import entities.Speciality;
import entities.Student;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import manager.DbManager;
import tools.TableTool;

/**
 *
 * @author Regener
 */
public class StudentEditJFrame extends javax.swing.JFrame {
    
    private AbstractService service = null;
    private DefaultTableModel tableModel = new DefaultTableModel();
    
    /**
     * Creates new form CatalogEditJFrame
     */
    public StudentEditJFrame() {
        initComponents();
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
        jTable1 = new javax.swing.JTable();
        tfAddValues = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        tfChangeValues = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        cbChangePK = new javax.swing.JComboBox<>();
        cbDeletePK = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        cbChangePK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbDeletePK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfAddValues)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbChangePK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfChangeValues, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbDeletePK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfAddValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfChangeValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbChangePK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnUpdate))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDeletePK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String[] values = tfAddValues.getText().split(",");
            Student entity = new Student();
            
            entity.setSurname(values[0]);
            entity.setFirst_name(values[1]);
            entity.setPatronymic(values[2]);
            
            java.util.Date dat_utl = format.parse(values[3]);
            entity.setDate_birth(new java.sql.Date(dat_utl.getTime()));
            
            dat_utl = format.parse(values[4]);
            entity.setDate_receipt(new java.sql.Date(dat_utl.getTime()));
            
            dat_utl = format.parse(values[5]);
            entity.setDate_deduction(new java.sql.Date(dat_utl.getTime()));
            
            entity.setResidential_address(values[6]);
            entity.setPhone_number(values[7]);
            entity.setId_group(Long.parseLong(values[8]));
            
            service.add(entity);
            showAllInfo();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(AssessmentEditJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(StudentEditJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        updateComboBoxes();
        showAllInfo();
    }//GEN-LAST:event_formWindowOpened

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String[] values = tfChangeValues.getText().split(",");
            Student entity = new Student();
            
            entity.setId(Long.parseLong(cbChangePK.getItemAt(cbChangePK.getSelectedIndex())));
            entity.setSurname(values[0]);
            entity.setFirst_name(values[1]);
            entity.setPatronymic(values[2]);
            
            java.util.Date dat_utl = format.parse(values[3]);
            entity.setDate_birth(new java.sql.Date(dat_utl.getTime()));
            
            dat_utl = format.parse(values[4]);
            entity.setDate_receipt(new java.sql.Date(dat_utl.getTime()));
            
            dat_utl = format.parse(values[5]);
            entity.setDate_deduction(new java.sql.Date(dat_utl.getTime()));
            
            entity.setResidential_address(values[6]);
            entity.setPhone_number(values[7]);
            entity.setId_group(Long.parseLong(values[8]));
            
            service.add(entity);
            showAllInfo();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(AssessmentEditJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(StudentEditJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            Student entity = new Student();
            entity.setId(Long.parseLong(cbDeletePK.getItemAt(cbDeletePK.getSelectedIndex())));
            service.delete(entity);
            updateComboBoxes();
            showAllInfo();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(StudentEditJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(StudentEditJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentEditJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentEditJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentEditJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentEditJFrame().setVisible(true);
            }
        });
    }
    
    public void setService(AbstractService service){
        this.service = service;
    }
    
    private void showAllInfo(){
        try {
            jTable1.setModel(tableModel);
            TableTool.FillTable(tableModel, service.all());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(StudentEditJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboBoxes(){
        try {
            cbChangePK.removeAllItems();
            cbDeletePK.removeAllItems();
            
            List<Student> entities = service.all();
            for(Student e : entities){
                cbChangePK.addItem(e.getId()+"");
                cbDeletePK.addItem(e.getId()+"");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(StudentEditJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbChangePK;
    private javax.swing.JComboBox<String> cbDeletePK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfAddValues;
    private javax.swing.JTextField tfChangeValues;
    // End of variables declaration//GEN-END:variables
}