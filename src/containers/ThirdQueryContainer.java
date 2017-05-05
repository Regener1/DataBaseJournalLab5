/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import entities.IEntity;
import java.sql.Date;

/**
 *
 * @author Администратор
 */
public class ThirdQueryContainer implements IEntity{
    private String surname;
    private String first_name;
    private String patronymic;
    private Date date_assessment;
    private String field_assessment;
    private String stud_surname;
    private String stud_first_name;
    private String stud_patronymic;

    public ThirdQueryContainer() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDate_assessment() {
        return date_assessment;
    }

    public void setDate_assessment(Date date_assessment) {
        this.date_assessment = date_assessment;
    }

    public String getField_assessment() {
        return field_assessment;
    }

    public void setField_assessment(String field_assessment) {
        this.field_assessment = field_assessment;
    }

    public String getStud_surname() {
        return stud_surname;
    }

    public void setStud_surname(String stud_surname) {
        this.stud_surname = stud_surname;
    }

    public String getStud_first_name() {
        return stud_first_name;
    }

    public void setStud_first_name(String stud_first_name) {
        this.stud_first_name = stud_first_name;
    }

    public String getStud_patronymic() {
        return stud_patronymic;
    }

    public void setStud_patronymic(String stud_patronymic) {
        this.stud_patronymic = stud_patronymic;
    }
   
    public String getFullInfo(){
        return surname + "\t" + first_name + "\t" + patronymic + "\t"
                + date_assessment.toString() + "\t" + field_assessment + "\t"
                + stud_surname + "\t" + stud_first_name + "\t" + stud_patronymic;
    }
    
    @Override
    public String[] getHeader() {
        return new String[] {"surname", "first_name", "patronymic",
                                "date_assessment", "field_assessment",
                                "stud_surname", "stud_first_name", "stud_patronymic"};
    }

    @Override
    public String[] getRow() {
        return new String[] {surname , first_name , patronymic, 
                                date_assessment.toString(), field_assessment.toString(),
                                stud_surname, stud_first_name, stud_patronymic};
    }
}
