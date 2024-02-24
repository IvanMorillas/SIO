package com.sce.dataset;

import jakarta.persistence.*;

@Entity
public class TitlePerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int titlePersonId;

    int personId;

    String titleId;

    protected TitlePerson(){}

    public TitlePerson(int personId, String titleId){
        this.personId = personId;
        this.titleId = titleId;
    }

    @Override
    public String toString() {
        return "TitlePerson{" +
                "titlePersonId=" + titlePersonId +
                ", personId=" + personId +
                ", titleId='" + titleId + '\'' +
                '}';
    }

    public int getTitlePersonId() {
        return titlePersonId;
    }

    public void setTitlePersonId(int titlePersonId) {
        this.titlePersonId = titlePersonId;
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
}
