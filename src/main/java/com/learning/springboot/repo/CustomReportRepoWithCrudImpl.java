package com.learning.springboot.repo;

import com.learning.springboot.model.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class CustomReportRepoWithCrudImpl implements CustomReportRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Author> fetchAllAuthors() {
        return this.entityManager
                .createNamedStoredProcedureQuery("getAllAuthors")
                .getResultList();

    }
}
