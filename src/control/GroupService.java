/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Faculty;
import entities.Group;
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
public class GroupService extends AbstractService<Group>{

    public GroupService() {
    }

    public GroupService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Group entity) throws SQLException {
        try{
            String query = "insert into groups values"
                + "(nextval('seq_group'),'" + entity.getName() + "','"
                + entity.getAbbreviation() + "',"
                + entity.getId_speciality() + ");";
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Group> all() throws SQLException {
        List<Group> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from groups");
            while(rs.next()){
                Group entity = new Group();
                entity.setId(rs.getLong("id_group"));
                entity.setName(rs.getString("name"));
                entity.setAbbreviation(rs.getString("abbreviation"));
                entity.setId_speciality(rs.getLong("id_speciality"));
                if (rs.wasNull()) {
                    entity.setId_speciality(null);
                }
                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Group entity) throws SQLException {
        try{
            String query = "delete from groups where id_group = " + entity.getId();
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(Group entity) throws SQLException {
        try{
            String query = "update groups set name = '" + entity.getName()+ "',"
                + "abbreviation = '" + entity.getAbbreviation() + "',"
                + "id_speciality = " + entity.getId_speciality() + " "
                + "where id_group = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

}
