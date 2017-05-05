/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import entities.IEntity;

/**
 *
 * @author Администратор
 */
public class FirstQueryContainer implements IEntity{
    private String surname;
    private String first_name;
    private String patronymic;

    public FirstQueryContainer() {
    }

    public FirstQueryContainer(String surname, String first_name, String patronymic) {
        this.surname = surname;
        this.first_name = first_name;
        this.patronymic = patronymic;
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
    
    public String getFullInfo(){
        return surname + "\t" + first_name + "\t" + patronymic;
    }

    @Override
    public String[] getHeader() {
        return new String[] {"surname", "first_name", "patronymic"};
    }

    @Override
    public String[] getRow() {
        return new String[] {surname , first_name , patronymic};
    }
}
