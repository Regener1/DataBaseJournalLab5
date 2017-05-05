/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Assessment;
import entities.Faculty;
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
public class FaculyService extends AbstractService<Faculty>{

    public FaculyService() {
    }

    public FaculyService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Faculty entity) throws SQLException {
        try{
            String query = "insert into faculties values"
                + "(nextval('seq_faculties'),'" + entity.getName() + "','"
                + entity.getAbbreviation() + "');";
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Faculty> all() throws SQLException {
        List<Faculty> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from faculties");
            while(rs.next()){
                Faculty entity = new Faculty();
                entity.setId(rs.getLong("id_faculty"));
                entity.setName(rs.getString("name"));
                entity.setAbbreviation(rs.getString("abbreviation"));

                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Faculty entity) throws SQLException {
        try{
            String query = "delete from faculties where id_faculty = " + entity.getId();
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(Faculty entity) throws SQLException {
        try{
            String query = "update faculties set name = '" + entity.getName()+ "',"
                + "abbreviation = '" + entity.getAbbreviation() + "' "
                + "where id_faculty = " + entity.getId();
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

}
