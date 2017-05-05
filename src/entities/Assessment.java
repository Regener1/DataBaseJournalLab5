/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Regener
 */
public class Assessment implements IEntity{
    private long id;
    private Date date_assessment;
    private String field_assessment;
    private Long id_student;
    private Long id_subject;
    private Long id_teacher;
    private Long id_test_type;
    
    public Assessment(){}

    public Assessment(long id, Date date_assessment, String field_assessment, Long id_student, Long id_subject, Long id_teacher, Long id_test_type) {
        this.id = id;
        this.date_assessment = date_assessment;
        this.field_assessment = field_assessment;
        this.id_student = id_student;
        this.id_subject = id_subject;
        this.id_teacher = id_teacher;
        this.id_test_type = id_test_type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Long getId_student() {
        return id_student;
    }

    public void setId_student(Long id_student) {
        this.id_student = id_student;
    }

    public Long getId_subject() {
        return id_subject;
    }

    public void setId_subject(Long id_subject) {
        this.id_subject = id_subject;
    }

    public Long getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Long id_teacher) {
        this.id_teacher = id_teacher;
    }

    public Long getId_test_type() {
        return id_test_type;
    }

    public void setId_test_type(Long id_test_type) {
        this.id_test_type = id_test_type;
    }
    
    @Override
    public String toString(){
        return date_assessment.toString() + " " + field_assessment;
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"id","date_assessment","field_assessment","id_student",
            "id_subject","id_teacher","id_test_type"};
    }
    
    @Override
    public String[] getRow(){
        return new String[] {id+"", date_assessment.toString(), field_assessment.toString(),
                    id_student+"",id_subject+"",id_teacher+"",id_test_type+""};
    }
}
