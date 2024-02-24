package com.sce.dataset;

import org.springframework.data.repository.CrudRepository;

public interface IGenres extends CrudRepository<Genres, Integer> {

    Object findByGenreName(String genre);


}
