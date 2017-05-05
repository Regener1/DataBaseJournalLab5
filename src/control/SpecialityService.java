/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Group;
import entities.Speciality;
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
public class SpecialityService extends AbstractService<Speciality>{

    public SpecialityService() {
    }

    public SpecialityService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Speciality entity) throws SQLException {
        try{
            String query = "insert into specialties values"
                + "(nextval('seq_speciality'),'" + entity.getName() + "','"
                + entity.getAbbreviation() + "',"
                + entity.getId_faculty() + ");";
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Speciality> all() throws SQLException {
        List<Speciality> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from specialties");
            while(rs.next()){
                Speciality entity = new Speciality();
                entity.setId(rs.getLong("id_speciality"));
                entity.setName(rs.getString("name"));
                entity.setAbbreviation(rs.getString("abbreviation"));
                entity.setId_faculty(rs.getLong("id_faculty"));
                if (rs.wasNull()) {
                    entity.setId_faculty(null);
                }
                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Speciality entity) throws SQLException {
        try{
            String query = "delete from specialties where id_speciality = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(Speciality entity) throws SQLException {
        try{
            String query = "update groups set name = '" + entity.getName()+ "',"
                + "abbreviation = '" + entity.getAbbreviation() + "',"
                + "id_faculty = " + entity.getId_faculty() + " "
                + "where id_speciality = " + entity.getId();
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }
    
}
