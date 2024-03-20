package com.sce.dataset;

import jakarta.persistence.*;

@Entity
public class TitlesDuplicated {
    @Id
    private String titleId;

    private String title;

    private String titleType;

    private String titleDescription;

    private int titleReleaseYear;

    private String titleAgeCertification;

    private int titleRuntime;

    private double titleSeasons;

    private String titleImdbId;

    private double titleImdbScore;

    private double titleImdbVotes;

    private double titleTmdbPopularity;

    private double titleTmdbScore;

    protected TitlesDuplicated() {}

    public TitlesDuplicated(String titleId, String title, String type, String description, int year, String age,
                            int runtime, double seasons, String imdbId, double imbdScore, double imbdVotes,
                            double tmbdPopularity, double tmbdScore) {
        this.titleId = titleId;
        this.title = title;
        this.titleType = type;
        this.titleDescription = description;
        this.titleReleaseYear = year;
        this.titleAgeCertification = age;
        this.titleRuntime = runtime;
        this.titleSeasons = seasons;
        this.titleImdbId = imdbId;
        this.titleImdbScore = imbdScore;
        this.titleImdbVotes = imbdVotes;
        this.titleTmdbPopularity = tmbdPopularity;
        this.titleTmdbScore = tmbdScore;
    }

    @Override
    public String toString() {
        return "TitlesDuplicated{" +
                "titleId='" + titleId + '\'' +
                ", title='" + title + '\'' +
                ", titleType='" + titleType + '\'' +
                ", titleDescription='" + titleDescription + '\'' +
                ", titleReleaseYear=" + titleReleaseYear +
                ", titleAgeCertification='" + titleAgeCertification + '\'' +
                ", titleRuntime=" + titleRuntime +
                ", titleSeasons=" + titleSeasons +
                ", titleImdbId='" + titleImdbId + '\'' +
                ", titleImdbScore=" + titleImdbScore +
                ", titleImdbVotes=" + titleImdbVotes +
                ", titleTmdbPopularity=" + titleTmdbPopularity +
                ", titleTmdbScore=" + titleTmdbScore +
                '}';
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getTitleDescription() {
        return titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    public int getTitleReleaseYear() {
        return titleReleaseYear;
    }

    public void setTitleReleaseYear(int titleReleaseYear) {
        this.titleReleaseYear = titleReleaseYear;
    }

    public String getTitleAgeCertification() {
        return titleAgeCertification;
    }

    public void setTitleAgeCertification(String titleAgeCertification) {
        this.titleAgeCertification = titleAgeCertification;
    }

    public int getTitleRuntime() {
        return titleRuntime;
    }

    public void setTitleRuntime(int titleRuntime) {
        this.titleRuntime = titleRuntime;
    }

    public double getTitleSeasons() {
        return titleSeasons;
    }

    public void setTitleSeasons(double titleSeasons) {
        this.titleSeasons = titleSeasons;
    }

    public String getTitleImdbId() {
        return titleImdbId;
    }

    public void setTitleImdbId(String titleImdbId) {
        this.titleImdbId = titleImdbId;
    }

    public double getTitleImdbScore() {
        return titleImdbScore;
    }

    public void setTitleImdbScore(double titleImdbScore) {
        this.titleImdbScore = titleImdbScore;
    }

    public double getTitleImdbVotes() {
        return titleImdbVotes;
    }

    public void setTitleImdbVotes(double titleImdbVotes) {
        this.titleImdbVotes = titleImdbVotes;
    }

    public double getTitleTmdbPopularity() {
        return titleTmdbPopularity;
    }

    public void setTitleTmdbPopularity(double titleTmdbPopularity) {
        this.titleTmdbPopularity = titleTmdbPopularity;
    }

    public double getTitleTmdbScore() {
        return titleTmdbScore;
    }

    public void setTitleTmdbScore(double titleTmdbScore) {
        this.titleTmdbScore = titleTmdbScore;
    }
}
