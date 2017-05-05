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
public class Subject implements IEntity{
    private long id;
    private String name;
    private String abbreviation;
    private int hours_of_lecture;
    private int hours_of_practice;
    
    public Subject(){}

    public Subject(long id, String name, String abbreviation, int hours_of_lecture, int hours_of_practice) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.hours_of_lecture = hours_of_lecture;
        this.hours_of_practice = hours_of_practice;
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

    public int getHours_of_lecture() {
        return hours_of_lecture;
    }

    public void setHours_of_lecture(int hours_of_lecture) {
        this.hours_of_lecture = hours_of_lecture;
    }

    public int getHours_of_practice() {
        return hours_of_practice;
    }

    public void setHours_of_practice(int hours_of_practice) {
        this.hours_of_practice = hours_of_practice;
    }
    
    @Override
    public String toString(){
        return name + " " + abbreviation +
                hours_of_lecture + " " + hours_of_practice;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","name","abbreviation","hours_of_lecture","hours_of_practice"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"",name,abbreviation,hours_of_lecture+"",hours_of_practice+""};
    }
}
