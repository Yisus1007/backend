package com.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jesus.a.castellanos
 */
@Entity
@Table(name="PEOPLE")
public class People 
{
    @Id      
    private int id;  
    private String rut;
    private String name;
    private String lastName;
    private Integer age;
    private String adress;

    public People(int id, String rut, String name, String lastName, Integer age, String adress) {
        this.id = id;
        this.rut = rut;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.adress = adress;
    }


    
    public People()
    {
    }


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    @Override
    public String toString()
    {
        return "{ \n rut: [" + this.rut + "],\n name: [" + this.name + "], \n lastName: [" + this.lastName + "], "+
                "\n age: [" + this.age + "], \n adress: [" + this.adress + "] \n }"; 
    }
    
    
}
