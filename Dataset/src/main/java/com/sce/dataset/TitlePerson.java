package com.sce.dataset;

import jakarta.persistence.*;

@Entity
public class TitlePerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int titlePersonId;

    int personId;

    String titleId;

    //String roleName;
    int roleId;

    protected TitlePerson(){}

    public TitlePerson(int personId, String titleId, int roleId/*String roleName*/){
        this.personId = personId;
        this.titleId = titleId;
        //this.roleName = roleName;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "TitlePerson{" +
                "titlePersonId=" + titlePersonId +
                ", personId=" + personId +
                ", titleId='" + titleId + '\'' +
                //", roleName=" + roleName +
                ", roleId=" + roleId +
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /*public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }*/
}
