package com.sce.dataset;

import jakarta.persistence.*;

@Entity
public class TitlesCountries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int titleCountryId;

    private String titleId;

    private int countryId;

    protected TitlesCountries(){}

    public TitlesCountries(String titleId, int countryId){
        this.titleId = titleId;
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "TitlesCountries{" +
                "titleCountryId=" + titleCountryId +
                ", titleId='" + titleId + '\'' +
                ", countryId=" + countryId +
                '}';
    }

    public int getTitleCountryId() {
        return titleCountryId;
    }

    public void setTitleCountryId(int titleCountryId) {
        this.titleCountryId = titleCountryId;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
