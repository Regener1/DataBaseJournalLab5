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
public class Student implements IEntity{
    private long id;
    private String surname;
    private String first_name;
    private String patronymic;
    private Date date_birth;
    private Date date_receipt;
    private Date date_deduction;
    private String residential_address;
    private String phone_number;
    private Long id_group;
    
    public Student(){}

    public Student(long id, String surname, String first_name, String patronymic, Date date_birth, Date date_receipt, Date date_deduction, String residential_address, String phone_number, Long id_group) {
        this.id = id;
        this.surname = surname;
        this.first_name = first_name;
        this.patronymic = patronymic;
        this.date_birth = date_birth;
        this.date_receipt = date_receipt;
        this.date_deduction = date_deduction;
        this.residential_address = residential_address;
        this.phone_number = phone_number;
        this.id_group = id_group;
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

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public Date getDate_receipt() {
        return date_receipt;
    }

    public void setDate_receipt(Date date_receipt) {
        this.date_receipt = date_receipt;
    }

    public Date getDate_deduction() {
        return date_deduction;
    }

    public void setDate_deduction(Date date_deduction) {
        this.date_deduction = date_deduction;
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

    public Long getId_group() {
        return id_group;
    }

    public void setId_group(Long id_group) {
        this.id_group = id_group;
    }
    
    @Override
    public String toString(){
        return surname + " " + first_name + " " +
                patronymic + " " + date_birth.toString() + " " +
                date_receipt.toString() + " " + date_deduction.toString() + " "+
                residential_address + " " + phone_number;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","surname","first_name","patronymic","date_birth",
            "date_receipt","date_deduction","residential_address","phone_number","id_group"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"",surname,first_name,patronymic,date_birth.toString(),
            date_receipt.toString(),date_deduction.toString(),residential_address,phone_number,id_group+""};
    }
}
