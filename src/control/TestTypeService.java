/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Group;
import entities.TestType;
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
public class TestTypeService extends AbstractService<TestType>{

    public TestTypeService() {
    }

    public TestTypeService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(TestType entity) throws SQLException {
        try{
            String query = "insert into test_types values"
                + "(nextval('seq_test_type'),'" + entity.getName() + "');";
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<TestType> all() throws SQLException {
        List<TestType> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from test_types");
            while(rs.next()){
                TestType entity = new TestType();
                entity.setId(rs.getLong("id_test_type"));
                entity.setName(rs.getString("name"));
                
                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(TestType entity) throws SQLException {
        try{
            String query = "delete from test_types where id_test_type = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(TestType entity) throws SQLException {
        try{
            String query = "update test_types set name = '" + entity.getName()+ "' "
                + "where id_test_type = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

}
