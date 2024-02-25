package com.sce.dataset;

import org.springframework.data.repository.CrudRepository;

public interface IRoles extends CrudRepository<Roles, Integer> {

    Object findByRoleName(String role);

    //Roles findByName(String s);

}
