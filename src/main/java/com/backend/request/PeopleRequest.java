package com.backend.request;

/**
 *
 * @author jesus.a.castellanos
 * Request from the front-end
 */
public class PeopleRequest 
{
    private String rut;
    private String name;
    private String lastName;
    private Integer age;
    private String adress;

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
        return "{ \n rut: [" + this.rut + "], \n name: [" + this.name + "], \n lastName: [" + this.lastName + "], \n" +
                " age: [" + this.age + "], \n adress: [" + this.adress + "] \n}";
    }
    
    
}
