/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Assessment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.DbManager;

/**
 *
 * @author Regener
 */
public class AssessmentService extends AbstractService<Assessment>{
    

    public AssessmentService() {
    }

    public AssessmentService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Assessment entity) throws SQLException {
        try{
            String query = "insert into assessments values"
                    + "(nextval('seq_assessments'),'" + entity.getDate_assessment() + "','"
                    + entity.getField_assessment() + "',"+entity.getId_student()+","
                    + entity.getId_subject() + "," + entity.getId_teacher() + ","
                    + entity.getId_test_type()+");";
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<Assessment> all() throws SQLException {
        List<Assessment> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from assessments");
            while(rs.next()){
                Assessment entity = new Assessment();
                entity.setId(rs.getLong("id_assessment"));
                entity.setDate_assessment(rs.getDate("date_assessment"));
                entity.setField_assessment(rs.getString("field_assessment"));
                entity.setId_student(rs.getLong("id_student"));
                if (rs.wasNull()) {
                    entity.setId_student(null);
                }
                entity.setId_subject(rs.getLong("id_subject"));
                if (rs.wasNull()) {
                    entity.setId_subject(null);
                }
                entity.setId_teacher(rs.getLong("id_teacher"));
                if (rs.wasNull()) {
                    entity.setId_teacher(null);
                }
                entity.setId_test_type(rs.getLong("id_test_type"));
                if (rs.wasNull()) {
                    entity.setId_test_type(null);
                }
                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Assessment entity) throws SQLException {
        try{
            String query = "delete from assessments where id_assessment = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void update(Assessment entity) throws SQLException {
        try{
            String query = "update assessments set date_assessment = '" + entity.getDate_assessment() + "',"
                    + "field_assessment = '" + entity.getField_assessment() + "',"
                    + "id_student = " + entity.getId_student() + ","
                    + "id_subject = " + entity.getId_subject() + ","
                    + "id_teacher = " + entity.getId_teacher() + ","
                    + "id_test_type = " + entity.getId_test_type() + " "
                    + "where id_assessment = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    
}
