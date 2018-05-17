package com.learning.springboot.repo;

import com.learning.springboot.model.Author;

public interface CustomReportRepo {
    Iterable<Author> fetchAllAuthors();
}
