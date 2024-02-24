package com.sce.dataset;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Titles {

    @Id
    private String titleId;

    private String title;

    private String titleType;

    private String titleDescription;

    private int titleReleaseYear;

    private String titleAgeCertification;

    private int titleRuntime;

    //private List<String> titleGenres;

    //private List<String> titleProductionCountries;

    private double titleSeasons;

    private String titleImdbId;

    private double titleImdbScore;

    private double titleImdbVotes;

    private double titleTmdbPopularity;

    private double titleTmdbScore;

    protected Titles() {}

    public Titles(String titleId, String title, String type, String description, int year, String age, int runtime, /*List<String> genres, List<String> countries,*/ double seasons, String imdbId, double imbdScore, double imbdVotes, double tmbdPopularity, double tmbdScore) {
        this.titleId = titleId;
        this.title = title;
        this.titleType = type;
        this.titleDescription = description;
        this.titleReleaseYear = year;
        this.titleAgeCertification = age;
        this.titleRuntime = runtime;
        //this.titleGenres = genres;
        //this.titleProductionCountries = countries;
        this.titleSeasons = seasons;
        this.titleImdbId = imdbId;
        this.titleImdbScore = imbdScore;
        this.titleImdbVotes = imbdVotes;
        this.titleTmdbPopularity = tmbdPopularity;
        this.titleTmdbScore = tmbdScore;
    }

    @Override
    public String toString() {
        return "Title{" +
                " titleId='" + titleId + '\'' +
                ", title='" + title + '\'' +
                ", titleType='" + titleType + '\'' +
                ", titleDescription='" + titleDescription + '\'' +
                ", titleReleaseYear=" + titleReleaseYear +
                ", titleAgeCertification='" + titleAgeCertification + '\'' +
                ", titleRuntime=" + titleRuntime +
                /*", titleGenres=" + titleGenres +
                ", titleProductionCountries=" + titleProductionCountries +*/
                ", titleSeasons=" + titleSeasons +
                ", titleImdbId='" + titleImdbId + '\'' +
                ", titleImdbScore=" + titleImdbScore +
                ", titleImdbVotes=" + titleImdbVotes +
                ", titleTmdbPopularity=" + titleTmdbPopularity +
                ", titleTmdbScore=" + titleTmdbScore +
                '}';
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    public void setTitleReleaseYear(int titleReleaseYear) {
        this.titleReleaseYear = titleReleaseYear;
    }

    public void setTitleAgeCertification(String titleAgeCertification) {
        this.titleAgeCertification = titleAgeCertification;
    }

    public void setTitleRuntime(int titleRuntime) {
        this.titleRuntime = titleRuntime;
    }

    /*public void setTitleGenres(List<String> titleGenres) {
        this.titleGenres = titleGenres;
    }

    public void setTitleProductionCountries(List<String> titleProductionCountries) {
        this.titleProductionCountries = titleProductionCountries;
    }*/

    public void setTitleSeasons(double titleSeasons) {
        this.titleSeasons = titleSeasons;
    }

    public void setTitleImdbId(String titleImdbId) {
        this.titleImdbId = titleImdbId;
    }

    public void setTitleImdbScore(double titleImdbScore) {
        this.titleImdbScore = titleImdbScore;
    }

    public void setTitleImdbVotes(double titleImdbVotes) {
        this.titleImdbVotes = titleImdbVotes;
    }

    public void setTitleTmdbPopularity(double titleTmdbPopularity) {
        this.titleTmdbPopularity = titleTmdbPopularity;
    }

    public void setTitleTmdbScore(double titleTmdbScore) {
        this.titleTmdbScore = titleTmdbScore;
    }
}
