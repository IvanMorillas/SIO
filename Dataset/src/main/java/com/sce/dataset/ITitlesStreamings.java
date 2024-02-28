package com.sce.dataset;

import org.springframework.data.repository.CrudRepository;

public interface ITitlesStreamings extends CrudRepository<TitlesStreamings, Integer> {

    boolean existsByStreamingIdAndTitleId(Integer streamingId, String titleId);

}
