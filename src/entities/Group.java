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
public class Group implements IEntity{
    private long id;
    private String name;
    private String abbreviation;
    private Long id_speciality;
    
    public Group(){}

    public Group(long id, String name, String abbreviation, Long id_speciality) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.id_speciality = id_speciality;
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

    public Long getId_speciality() {
        return id_speciality;
    }

    public void setId_speciality(Long id_speciality) {
        this.id_speciality = id_speciality;
    }
    
    @Override
    public String toString(){
        return name + " " + abbreviation;
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"id","name","abbreviation","id_speciality"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"", name,abbreviation,id_speciality.toString()};
    }
}
