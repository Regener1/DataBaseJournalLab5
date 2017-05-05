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
public class Teacher implements IEntity{
    private long id;
    private String surname;
    private String first_name;
    private String patronymic;
    private String residential_address;
    private String phone_number;
    
    public Teacher(){}

    public Teacher(long id, String surname, String first_name, String patronymic, String residential_address, String phone_number) {
        this.id = id;
        this.surname = surname;
        this.first_name = first_name;
        this.patronymic = patronymic;
        this.residential_address = residential_address;
        this.phone_number = phone_number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getResidential_address() {
        return residential_address;
    }

    public void setResidential_address(String residential_address) {
        this.residential_address = residential_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
    @Override
    public String toString(){
        return surname + " " + first_name + " " +
                patronymic + " " + residential_address + " " + 
                phone_number;
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"id","surname","first_name","patronymic","residential_address","phone_number"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"",surname,first_name,patronymic,residential_address,
                    phone_number};
    }
}
