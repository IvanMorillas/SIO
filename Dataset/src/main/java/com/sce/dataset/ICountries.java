package com.sce.dataset;

import org.springframework.data.repository.CrudRepository;

public interface ICountries extends CrudRepository<Countries, Integer> {
    Object findByCountryName(String country);
}
