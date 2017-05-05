/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Group;
import entities.Student;
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
public class StudentService extends AbstractService<Student>{


    public StudentService() {
    }

    public StudentService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Student entity) throws SQLException {
        try{
            String query = "insert into students values"
                + "(nextval('seq_student'),'" + entity.getSurname() + "','"
                + entity.getFirst_name() + "','"
                + entity.getPatronymic() + "','"
                + entity.getDate_birth() + "','"
                + entity.getDate_receipt() + "','"
                + entity.getDate_deduction() + "','"
                + entity.getResidential_address() + "','"
                + entity.getPhone_number() + "',"
                + entity.getId_group() + ");";
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Student> all() throws SQLException {
        List<Student> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from students");
            while(rs.next()){
                Student entity = new Student();
                entity.setId(rs.getLong("id_student"));
                entity.setSurname(rs.getString("surname"));
                entity.setFirst_name(rs.getString("first_name"));
                entity.setPatronymic(rs.getString("patronymic"));
                entity.setDate_birth(rs.getDate("date_birth"));
                entity.setDate_receipt(rs.getDate("date_receipt"));
                entity.setDate_deduction(rs.getDate("date_deduction"));
                entity.setResidential_address(rs.getString("residential_address"));
                entity.setPhone_number(rs.getString("phone_number"));
                entity.setId_group(rs.getLong("id_group"));
                if (rs.wasNull()) {
                    entity.setId_group(null);
                }
                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Student entity) throws SQLException {
        try{
            String query = "delete from students where id_student = " + entity.getId();
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(Student entity) throws SQLException {
        try{
            String query = "update students set surname = '" + entity.getSurname() + "'," 
                + "first_name = '" + entity.getFirst_name() + "',"
                + "patronymic = '" + entity.getPatronymic() + "',"
                + "date_birth = '" + entity.getDate_birth() + "',"        
                + "date_receipt = '" + entity.getDate_receipt() + "',"
                + "date_deduction = '" + entity.getDate_deduction() + "',"
                + "residential_address = '" + entity.getResidential_address() + "',"
                + "phone_number = '" + entity.getPhone_number() + "',"
                + "id_group = " + entity.getId_group() + " "
                + "where id_student = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

}
