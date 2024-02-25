package com.sce.dataset;

import org.springframework.data.repository.CrudRepository;

public interface ITitlePerson extends CrudRepository<TitlePerson, Integer> {
    //boolean existsByPersonIdAndTitleIdAndRoleName(int personId, String titleId, String roleName);

    boolean existsByPersonIdAndTitleIdAndRoleId(int personId, String titleId, int roleId);

    //boolean existsByPersonIdAndTitleId(int personId, String titleId);
}
