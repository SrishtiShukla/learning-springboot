package com.learning.springboot.repo;

import com.learning.springboot.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepo extends CrudRepository<Author, Long> {

    @Query("SELECT id, first_name, last_name FROM Author")
    Iterable<Author> findAllAuthors();
}
