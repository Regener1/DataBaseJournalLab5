/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Regener
 */
public class Speciality implements IEntity{
    private long id;
    private String name;
    private String abbreviation;
    private Long id_faculty;
    
    public Speciality(){}

    public Speciality(long id, String name, String abbreviation, Long id_faculty) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.id_faculty = id_faculty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Long getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(Long id_faculty) {
        this.id_faculty = id_faculty;
    }
    
    @Override
    public String toString(){
        return name + " " + abbreviation;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","name","abbreviation","id_faculty"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"", name,abbreviation,id_faculty.toString()};
    }
}
