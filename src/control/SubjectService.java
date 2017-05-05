/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Faculty;
import entities.Subject;
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
public class SubjectService extends AbstractService<Subject>{


    public SubjectService() {
    }

    public SubjectService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Subject entity) throws SQLException {
        try{
            String query = "insert into subjects values"
                + "(nextval('seq_subject'),'" + entity.getName() + "','"
                + entity.getAbbreviation() + "',"
                + entity.getHours_of_lecture() + ","
                + entity.getHours_of_practice() + ");";
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Subject> all() throws SQLException {
        List<Subject> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from subjects");
            while(rs.next()){
                Subject entity = new Subject();
                entity.setId(rs.getLong("id_subject"));
                entity.setName(rs.getString("name"));
                entity.setAbbreviation(rs.getString("abbreviation"));
                entity.setHours_of_lecture(rs.getInt("hours_of_lecture"));
                entity.setHours_of_lecture(rs.getInt("hours_of_practice"));

                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Subject entity) throws SQLException {
        try{
            String query = "delete from subjects where id_subject = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(Subject entity) throws SQLException {
        try{
            String query = "update subjects set name = '" + entity.getName()+ "',"
                + "abbreviation = '" + entity.getAbbreviation() + "',"
                + "hours_of_lecture = " + entity.getHours_of_lecture() + ","
                + "hours_of_practice = " + entity.getHours_of_practice() + " "
                + "where id_subject = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }
    
}
