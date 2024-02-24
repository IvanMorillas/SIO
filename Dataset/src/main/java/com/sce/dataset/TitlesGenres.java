package com.sce.dataset;

import jakarta.persistence.*;

@Entity
public class TitlesGenres {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int titleGenreId;

        private String titleId;

        private int genreId;

        protected TitlesGenres(){}

        public TitlesGenres(String titleId, int genreId){
            this.titleId = titleId;
            this.genreId = genreId;
        }

        @Override
        public String toString() {
            return "TitlesGenres{" +
                    "titleGenreId=" + titleGenreId +
                    ", titleId='" + titleId + '\'' +
                    ", genreId=" + genreId +
                    '}';
        }

        public int getTitleGenreId() {
            return titleGenreId;
        }

        public void setTitleGenreId(int titleGenreId) {
            this.titleGenreId = titleGenreId;
        }

        public String getTitleId() {
            return titleId;
        }

        public void setTitleId(String titleId) {
            this.titleId = titleId;
        }

        public int getGenreId() {
            return genreId;
        }

        public void setGenreId(int genreId) {
            this.genreId = genreId;
        }
}
