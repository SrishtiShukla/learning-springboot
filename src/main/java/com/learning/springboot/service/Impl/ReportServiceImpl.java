package com.learning.springboot.service.Impl;

import com.learning.springboot.model.Author;
import com.learning.springboot.repo.CustomReportRepo;
import com.learning.springboot.repo.CustomReportRepoWithCrud;
import com.learning.springboot.repo.ReportRepo;
import com.learning.springboot.service.ReportService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger logger = Logger.getLogger(ReportServiceImpl.class);

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private ReportRepo reportRepo;

    private CustomReportRepoWithCrud customReportRepoWithCrud;

    public ReportServiceImpl() {
    }

    @Autowired
    public ReportServiceImpl(ReportRepo reportRepo,
                             CustomReportRepoWithCrud customReportRepoWithCrud) {
        this.reportRepo = reportRepo;
        this.customReportRepoWithCrud = customReportRepoWithCrud;
    }

    @Override
    public Iterable<Author> getAllAuthorsList() {
        return customReportRepoWithCrud.fetchAllAuthors();
    }


}
