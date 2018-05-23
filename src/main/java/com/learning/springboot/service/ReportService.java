package com.learning.springboot.service;

import com.learning.springboot.model.Author;

public interface ReportService {
    Iterable<Author> getAllAuthorsList();
    Long countAuthors();
    Iterable<MyViewDTO> getAllAuthorsViewList();
}
