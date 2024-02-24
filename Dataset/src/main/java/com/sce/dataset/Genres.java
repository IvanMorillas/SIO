package com.sce.dataset;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int genreId;
    private String genreName;

    protected Genres(){}

    public Genres(String genreName) {
        this.genreName = genreName;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "Genres{" +
                "genreId='" + genreId + '\'' +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
