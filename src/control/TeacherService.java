/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Student;
import entities.Teacher;
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
public class TeacherService extends AbstractService<Teacher>{

    public TeacherService() {
    }

    public TeacherService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Teacher entity) throws SQLException {
        try{
            String query = "insert into teachers values"
                + "(nextval('seq_teacher'),'" + entity.getSurname() + "','"
                + entity.getFirst_name() + "','"
                + entity.getPatronymic() + "','"
                + entity.getResidential_address() + "','"
                + entity.getPhone_number() + "');";
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Teacher> all() throws SQLException {
        List<Teacher> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from teachers");
            while(rs.next()){
                Teacher entity = new Teacher();
                entity.setId(rs.getLong("id_teacher"));
                entity.setSurname(rs.getString("surname"));
                entity.setFirst_name(rs.getString("first_name"));
                entity.setPatronymic(rs.getString("patronymic"));
                entity.setResidential_address(rs.getString("residential_address"));
                entity.setPhone_number(rs.getString("phone_number"));

                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Teacher entity) throws SQLException {
        try{
            String query = "delete from teachers where id_teacher = " + entity.getId();
            dbManager.executeQuery(query);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void update(Teacher entity) throws SQLException {
        try{
            String query = "update teachers set surname = '" + entity.getSurname() + "'," 
                + "first_name = '" + entity.getFirst_name() + "',"
                + "patronymic = '" + entity.getPatronymic() + "',"
                + "residential_address = '" + entity.getResidential_address() + "',"
                + "phone_number = '" + entity.getPhone_number() + "' "
                + "where id_teacher = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    
}
