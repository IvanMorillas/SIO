package com.sce.dataset;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public class DAOimpl implements DAO{

    /*private final EntityManager entityManager;
    public DAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    @Override
    @Transactional
    public void saveTitle(Title title) {
        entityManager.persist(title);

    @Override
    @Transactional
    public void deletePerson(Long id) {
        Person tempPerson = entityManager.find(Person.class, id);
        entityManager.remove(tempPerson);
    }

    /*@Override
    @Transactional
    public void deleteTitle(Long id) {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.remove(person);
        }
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        entityManager.merge(person);
    }

    @Override
    @Transactional
    public void updateTitle(Title title) {
        entityManager.merge(title);
    }*/
}
