package com.learning.springboot;

import com.learning.springboot.model.Author;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LearningSpringBoot.class})
@TestPropertySource(locations = "classpath:application.properties")
public class StoredProcedureTest {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Using the stored procedure defined on the entity
    @Test
    public void findAllTheAuthorsNamedStored() {
        StoredProcedureQuery getAllAuthors =
                entityManager.createNamedStoredProcedureQuery("getAllAuthors");
        Assert.assertTrue(getAllAuthors.getResultList().size() > 0);
    }

    //Using the procedure defined in test itself
    @Test
    public void findAllTheAuthorsNamedStoredUsingSP() {
        StoredProcedureQuery getAllAuthors =
                entityManager
                        .createStoredProcedureQuery("get_all_authors", Author.class);
        Assert.assertTrue(getAllAuthors.getResultList().size() > 0);
    }

}
