package com.sce.dataset;

import org.springframework.data.repository.CrudRepository;

public interface IStreamings extends CrudRepository<Streamings, Integer> {

    boolean existsByStreamingName(String nameFiles);
    Streamings findByStreamingName(String nameFiles);
}
