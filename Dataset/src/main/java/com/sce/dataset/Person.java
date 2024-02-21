package com.sce.dataset;

import jakarta.persistence.*;

@Entity
//@Table(name = "person")
public class Person {

    @Id
    private int personId;

    private String titleId;

    private String personName;

    private String personCharacter;

    private String personRole;

    protected Person(){}

    public Person(int personId, String titleId, String name, String character, String role){
        this.personId = personId;
        this.titleId = titleId;
        this.personName = name;
        this.personCharacter = character;
        this.personRole = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", titleId='" + titleId + '\'' +
                ", personName='" + personName + '\'' +
                ", personCharacter='" + personCharacter + '\'' +
                ", personRole='" + personRole + '\'' +
                '}';
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonCharacter() {
        return personCharacter;
    }

    public void setPersonCharacter(String personCharacter) {
        this.personCharacter = personCharacter;
    }

    public String getPersonRole() {
        return personRole;
    }

    public void setPersonRole(String personRole) {
        this.personRole = personRole;
    }
}