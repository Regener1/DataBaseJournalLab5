/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import control.AssessmentService;
import control.StudentService;
import control.SubjectService;
import control.TeacherService;
import control.TestTypeService;
import entities.Assessment;
import entities.Student;
import entities.Subject;
import entities.Teacher;
import entities.TestType;
import java.sql.SQLException;
import java.util.List;
import manager.DbManager;

/**
 *
 * @author Администратор
 */
public class MainInfoModel {
    private AssessmentService assessmentS = new AssessmentService();
    private StudentService studentS = new StudentService();
    private TeacherService teacherS = new TeacherService();
    private TestTypeService testTypeS = new TestTypeService();
    private SubjectService subjectS = new SubjectService();
    
    private DbManager dbManager = null;

    public MainInfoModel() {
    }

    public MainInfoModel(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void setDbManager(DbManager dbManager) {
        this.dbManager = dbManager;
        assessmentS.setManager(dbManager);
        studentS.setManager(dbManager);
        teacherS.setManager(dbManager);
        testTypeS.setManager(dbManager);
        subjectS.setManager(dbManager);
    }
    
    public void add(Assessment entity) throws SQLException{
        assessmentS.add(entity);
    }
    
    public void update(Assessment entity) throws SQLException{
        assessmentS.update(entity);
    }
    
    public void delete(Assessment entity) throws SQLException{
        assessmentS.delete(entity);
    }
    
    public List<Teacher> getTeachers() throws SQLException{
        return teacherS.all();
    }
    
    public List<Student> getStudents() throws SQLException{
        return studentS.all();
    }
    
    public List<TestType> getTestTypes() throws SQLException{
        return testTypeS.all();
    }
    
    public List<Subject> getSubjects() throws SQLException{
        return subjectS.all();
    }
    
    public List<Assessment> getAssessments() throws SQLException{
        return assessmentS.all();
    }
}
