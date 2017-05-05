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
public class TestType implements IEntity{
    private long id;
    private String name;

    public TestType(){}
    
    public TestType(long id, String name) {
        this.id = id;
        this.name = name;
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
    
    @Override
    public String toString(){
        return name;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","name"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"",name};
    }
}
