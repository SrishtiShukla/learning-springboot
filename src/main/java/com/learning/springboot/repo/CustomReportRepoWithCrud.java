package com.learning.springboot.repo;

import com.learning.springboot.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface CustomReportRepoWithCrud extends CrudRepository<Author, Long>, CustomReportRepo {
}
