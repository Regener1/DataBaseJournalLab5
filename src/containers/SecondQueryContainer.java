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
public class SecondQueryContainer implements IEntity{
    private String surname;
    private String first_name;
    private String patronymic;
    private String group;
    private String subject;
    private Date date_assessment;
    private String field_assessment;

    public SecondQueryContainer() {
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
    
    public String getFullInfo(){
        return surname + "\t" + first_name + "\t" + patronymic + "\t"
                + group + "\t" + subject + "\t"
                + date_assessment.toString() + "\t" + field_assessment;
    }
    
    @Override
    public String[] getHeader() {
        return new String[] {"surname", "first_name", "patronymic", "group", "subject",
                                "date_assessment", "field_assessment"};
    }

    @Override
    public String[] getRow() {
        return new String[] {surname , first_name , patronymic, group, subject,
                                date_assessment.toString(), field_assessment.toString()};
    }
}
