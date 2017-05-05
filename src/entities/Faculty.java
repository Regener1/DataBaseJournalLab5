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
public class Faculty implements IEntity{
    private long id;
    private String name;
    private String abbreviation;
    
    public Faculty(){}

    public Faculty(long id, String name, String abbreviation) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
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
    
    @Override
    public String toString(){
        return name + " " + abbreviation;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","name","abbreviation"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"", name, abbreviation};
    }
}
