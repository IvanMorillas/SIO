package com.sce.dataset;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;
    private String countryName;

    protected Countries(){}

    public Countries(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "countryId='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
