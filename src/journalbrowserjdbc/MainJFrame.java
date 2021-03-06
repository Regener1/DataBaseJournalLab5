/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journalbrowserjdbc;

import containers.ConnectionContainer;
import control.AssessmentService;
import control.FaculyService;
import control.GroupService;
import control.SpecialityService;
import control.StudentService;
import control.SubjectService;
import control.TeacherService;
import control.TestTypeService;
import entities.Assessment;
import entities.Student;
import entities.Subject;
import entities.Teacher;
import entities.TestType;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import manager.DbManager;
import models.MainInfoModel;

/**
 *
 * @author Regener
 */
public class MainJFrame extends javax.swing.JFrame {
    
    private DefaultTableModel tableModel = new DefaultTableModel();
    
    private MainInfoModel model = new MainInfoModel();

    private ConnectionContainer conCont= new  ConnectionContainer("jdbc:postgresql://127.0.0.1:5432/journal",
                                                    "postgres",
                                                    "");   
    private DbManager dbManager = new DbManager();
    private List<Assessment> assessments = null;
    private List<Teacher> teachers = null;
    private List<Student> students = null;
    private List<TestType> testTypes = null;
    private List<Subject> subjects = null;
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
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

        jLabel1 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnQueries = new javax.swing.JButton();
        cbQueryId = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mItemNewConnection = new javax.swing.JMenuItem();
        mItemDisconnect = new javax.swing.JMenuItem();
        mItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mItemFaculties = new javax.swing.JMenuItem();
        mItemSpecialties = new javax.swing.JMenuItem();
        mItemGroups = new javax.swing.JMenuItem();
        mItemStudents = new javax.swing.JMenuItem();
        mItemAssessments = new javax.swing.JMenuItem();
        mItemTestTypes = new javax.swing.JMenuItem();
        mItemTeachers = new javax.swing.JMenuItem();
        mItemSubjects = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Status");

        btnQueries.setText("Queries");
        btnQueries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueriesActionPerformed(evt);
            }
        });

        cbQueryId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnChange.setText("Change");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
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
        jScrollPane2.setViewportView(jTable1);

        jMenu1.setLabel("Connection");
        jMenu1.setName(""); // NOI18N

        mItemNewConnection.setText("New connection");
        mItemNewConnection.setName(""); // NOI18N
        mItemNewConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemNewConnectionActionPerformed(evt);
            }
        });
        jMenu1.add(mItemNewConnection);

        mItemDisconnect.setText("Disconnect");
        mItemDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemDisconnectActionPerformed(evt);
            }
        });
        jMenu1.add(mItemDisconnect);

        mItemExit.setText("Exit");
        mItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(mItemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setLabel("Catalogues");

        mItemFaculties.setText("Faculties");
        mItemFaculties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemFacultiesActionPerformed(evt);
            }
        });
        jMenu2.add(mItemFaculties);

        mItemSpecialties.setText("Specialties");
        mItemSpecialties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemSpecialtiesActionPerformed(evt);
            }
        });
        jMenu2.add(mItemSpecialties);

        mItemGroups.setText("Groups");
        mItemGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemGroupsActionPerformed(evt);
            }
        });
        jMenu2.add(mItemGroups);

        mItemStudents.setText("Students");
        mItemStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemStudentsActionPerformed(evt);
            }
        });
        jMenu2.add(mItemStudents);

        mItemAssessments.setText("Assessments");
        mItemAssessments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemAssessmentsActionPerformed(evt);
            }
        });
        jMenu2.add(mItemAssessments);

        mItemTestTypes.setText("Test types");
        mItemTestTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemTestTypesActionPerformed(evt);
            }
        });
        jMenu2.add(mItemTestTypes);

        mItemTeachers.setText("Teachers");
        mItemTeachers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemTeachersActionPerformed(evt);
            }
        });
        jMenu2.add(mItemTeachers);

        mItemSubjects.setText("Subjects");
        mItemSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemSubjectsActionPerformed(evt);
            }
        });
        jMenu2.add(mItemSubjects);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 545, Short.MAX_VALUE)
                        .addComponent(btnQueries))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbQueryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbQueryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnChange)
                            .addComponent(btnDelete))
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnQueries, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        lblStatus.getAccessibleContext().setAccessibleName("lblStatus");

        pack();
    }// </editor-fold>//GEN-END:initComponents
                             
    private void mItemNewConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemNewConnectionActionPerformed
        openConnectionFrame();
        dbManager.setConnectionContainer(conCont);
        dbManager.closeConnection();
        if(dbManager.openConnection()){
            lblStatus.setText("Connected");
        }
        else{
            lblStatus.setText("connection error");
        }
    }//GEN-LAST:event_mItemNewConnectionActionPerformed

    private void mItemDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemDisconnectActionPerformed
        if(dbManager.closeConnection()){
            lblStatus.setText("Connection closed");
        }
    }//GEN-LAST:event_mItemDisconnectActionPerformed

    private void mItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mItemExitActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        openConnectionFrame();
        dbManager.setConnectionContainer(conCont);
        if(dbManager.openConnection()){
            lblStatus.setText("Connected");
            model.setDbManager(dbManager);
        }
        else{
            lblStatus.setText("connection error");
        }
        
        jTable1.setModel(tableModel);
        
        cbQueryId.removeAllItems();
        for(int i = 0; i < 3; i++){
            cbQueryId.addItem(i+"");
        }
        
        updateInfo();
    }//GEN-LAST:event_formWindowOpened

    private void updateInfo(){
        try {
            assessments = model.getAssessments();
            teachers = model.getTeachers();
            students = model.getStudents();
            subjects = model.getSubjects();
            testTypes = model.getTestTypes();
            
            tableModel.setRowCount(0);
            tableModel.setColumnCount(0);
            
            tableModel.addColumn("id");
            tableModel.addColumn("date_assessment");
            tableModel.addColumn("field_assessment");
            tableModel.addColumn("student");
            tableModel.addColumn("subject");
            tableModel.addColumn("teacher");
            tableModel.addColumn("test_type");
            
            for(Assessment e : assessments){
                tableModel.addRow(new String[]{e.getId()+"",e.getDate_assessment().toString(),e.getField_assessment()+"",
                    getStudentName(e.getId_student()), getSubjectName(e.getId_subject()),
                    getTeacherName(e.getId_teacher()),getTestTypeName(e.getId_test_type())});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(AssessmentEditJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private String getSubjectName(long id){
        for(Subject e : subjects){
            if(e.getId() == id)
                return e.getAbbreviation();
        }
        return "";
    }
    
    private String getTeacherName(long id){
        for(Teacher e : teachers){
            if(e.getId() == id)
                return e.getSurname() + " " + e.getFirst_name();
        }
        return "";
    }
    
    private String getStudentName(long id){
        for(Student e : students){
            if(e.getId() == id)
                return e.getSurname() + " " + e.getFirst_name();
        }
        return "";
    }
    
    private String getTestTypeName(long id){
        for(TestType e : testTypes){
            if(e.getId() == id)
                return e.getName();
        }
        return "";
    }

    
    private void mItemFacultiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemFacultiesActionPerformed
        FacultyEditJFrame assessmFrame = new FacultyEditJFrame();
        assessmFrame.setService(new FaculyService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemFacultiesActionPerformed

    private void mItemSpecialtiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSpecialtiesActionPerformed
        SpecialityEditJFrame assessmFrame = new SpecialityEditJFrame();
        assessmFrame.setService(new SpecialityService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemSpecialtiesActionPerformed

    private void mItemGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemGroupsActionPerformed
        GroupEditJFrame assessmFrame = new GroupEditJFrame();
        assessmFrame.setService(new GroupService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemGroupsActionPerformed

    private void mItemStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemStudentsActionPerformed
        StudentEditJFrame assessmFrame = new StudentEditJFrame();
        assessmFrame.setService(new StudentService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemStudentsActionPerformed

    private void mItemAssessmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemAssessmentsActionPerformed
        AssessmentEditJFrame assessmFrame = new AssessmentEditJFrame();
        assessmFrame.setService(new AssessmentService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemAssessmentsActionPerformed

    private void mItemTestTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemTestTypesActionPerformed
        TestTypeEditJFrame assessmFrame = new TestTypeEditJFrame();
        assessmFrame.setService(new TestTypeService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemTestTypesActionPerformed

    private void mItemTeachersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemTeachersActionPerformed
        TeacherEditJFrame assessmFrame = new TeacherEditJFrame();
        assessmFrame.setService(new TeacherService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemTeachersActionPerformed

    private void mItemSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSubjectsActionPerformed
        SubjectEditJFrame assessmFrame = new SubjectEditJFrame();
        assessmFrame.setService(new SubjectService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemSubjectsActionPerformed

    private void btnQueriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueriesActionPerformed
        QueriesJFrame qF = new QueriesJFrame();
        qF.setDbManager(dbManager);
        qF.setId_query(cbQueryId.getSelectedIndex());
        qF.setVisible(true);
        qF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnQueriesActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddMainInfoJDialog ami = new AddMainInfoJDialog();
        ami.setDbManager(dbManager);
        ami.setVisible(true);
        ami.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        ChangeMainInfoJDialog ami = new ChangeMainInfoJDialog();
        ami.setDbManager(dbManager);
        ami.setId(assessments.get(jTable1.getSelectedRow()).getId());
        ami.setVisible(true);
        ami.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            model.delete(assessments.get(jTable1.getSelectedRow()));
            updateInfo();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(AssessmentEditJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        updateInfo();
    }//GEN-LAST:event_btnRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    
    private void openConnectionFrame(){
        ConnectionJDialog cf = new ConnectionJDialog((Frame)this.getOwner(), true);
        cf.setFields(conCont);
        cf.setVisible(true);
        conCont = cf.getFields();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnQueries;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cbQueryId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem mItemAssessments;
    private javax.swing.JMenuItem mItemDisconnect;
    private javax.swing.JMenuItem mItemExit;
    private javax.swing.JMenuItem mItemFaculties;
    private javax.swing.JMenuItem mItemGroups;
    private javax.swing.JMenuItem mItemNewConnection;
    private javax.swing.JMenuItem mItemSpecialties;
    private javax.swing.JMenuItem mItemStudents;
    private javax.swing.JMenuItem mItemSubjects;
    private javax.swing.JMenuItem mItemTeachers;
    private javax.swing.JMenuItem mItemTestTypes;
    // End of variables declaration//GEN-END:variables
}
