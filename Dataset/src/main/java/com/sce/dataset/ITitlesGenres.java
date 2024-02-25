package com.sce.dataset;

import org.springframework.data.repository.CrudRepository;

public interface ITitlesGenres extends CrudRepository<TitlesGenres, Integer> {

    boolean existsByGenreIdAndTitleId(Integer genreId, String titleId);

}
