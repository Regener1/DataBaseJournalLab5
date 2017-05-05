/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import containers.FirstQueryContainer;
import containers.SecondQueryContainer;
import containers.ThirdQueryContainer;
import entities.IEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.DbManager;

/**
 *
 * @author Администратор
 */
public class Queries {
    private DbManager dbManager;

    public Queries() {
    }

    public Queries(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void setDbManager(DbManager dbManager) {
        this.dbManager = dbManager;
    }
    
    public List<IEntity> queryFirst() throws SQLException{
        List<IEntity> fqContainers = null;
        try {
            fqContainers = new ArrayList<>();
            String query = "select surname,first_name,patronymic " +
                    "from students join groups " +
                    "on students.id_group = groups.id_group " +
                    "where groups.id_speciality = 1;";
            ResultSet rs = dbManager.executeQuery(query);
            while(rs.next()){
                FirstQueryContainer container = new FirstQueryContainer();
                container.setSurname(rs.getString("surname"));
                container.setFirst_name(rs.getString("first_name"));
                container.setPatronymic(rs.getString("patronymic"));
                
                fqContainers.add(container);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return fqContainers;
    }
    
    public List<IEntity> querySecond() throws SQLException{
        List<IEntity> fqContainers = null;
        try {
            fqContainers = new ArrayList<>();
            String query = "select stud.surname,stud.first_name,stud.patronymic, g.abbreviation as group, sub.abbreviation as subject, a.date_assessment,a.field_assessment\n" +
                            "from groups g join students stud\n" +
                            "on g.id_group = stud.id_group \n" +
                            "join assessments a\n" +
                            "on stud.id_student = a.id_student\n" +
                            "join subjects sub\n" +
                            "on sub.id_subject = a.id_subject;";
            ResultSet rs = dbManager.executeQuery(query);
            while(rs.next()){
                SecondQueryContainer container = new SecondQueryContainer();
                container.setSurname(rs.getString("surname"));
                container.setFirst_name(rs.getString("first_name"));
                container.setPatronymic(rs.getString("patronymic"));
                container.setGroup(rs.getString("group"));
                container.setSubject(rs.getString("subject"));
                container.setDate_assessment(rs.getDate("date_assessment"));
                container.setField_assessment(rs.getString("field_assessment"));
                
                fqContainers.add(container);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return fqContainers;
    }
    
    public List<IEntity> queryThird() throws SQLException{
        List<IEntity> fqContainers = null;
        try {
            fqContainers = new ArrayList<>();
            String query = "select t.surname,t.first_name,t.patronymic, a.date_assessment, a.field_assessment,stud.surname as stud_surname,stud.first_name as \n" +
                            "stud_first_name,stud.patronymic as stud_patronymic\n" +
                            "from teachers t join assessments a \n" +
                            "on t.id_teacher = a.id_teacher\n" +
                            "join students stud\n" +
                            "on a.id_student = stud.id_student;";
            ResultSet rs = dbManager.executeQuery(query);
            while(rs.next()){
                ThirdQueryContainer container = new ThirdQueryContainer();
                container.setSurname(rs.getString("surname"));
                container.setFirst_name(rs.getString("first_name"));
                container.setPatronymic(rs.getString("patronymic"));
                container.setDate_assessment(rs.getDate("date_assessment"));
                container.setField_assessment(rs.getString("field_assessment"));
                container.setStud_surname(rs.getString("stud_surname"));
                container.setStud_first_name(rs.getString("stud_first_name"));
                container.setStud_patronymic(rs.getString("stud_patronymic"));
                
                fqContainers.add(container);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return fqContainers;
    }
}
