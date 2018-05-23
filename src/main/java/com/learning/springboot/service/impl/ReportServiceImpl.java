package com.learning.springboot.service.impl;

import com.learning.springboot.model.Author;
import com.learning.springboot.repo.CustomReportRepoWithCrud;
import com.learning.springboot.repo.MyViewRepository;
import com.learning.springboot.repo.ReportRepo;
import com.learning.springboot.service.MyViewDTO;
import com.learning.springboot.service.ReportService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

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

    private MyViewRepository myViewRepository;

    public ReportServiceImpl() {
    }

    @Autowired
    public ReportServiceImpl(ReportRepo reportRepo,
                             CustomReportRepoWithCrud customReportRepoWithCrud,
                             MyViewRepository myViewRepository) {
        this.reportRepo = reportRepo;
        this.customReportRepoWithCrud = customReportRepoWithCrud;
        this.myViewRepository = myViewRepository;
    }

    @Override
    public Iterable<Author> getAllAuthorsList() {
        return customReportRepoWithCrud.fetchAllAuthors();
    }

    @Override
    public Long countAuthors() {
        return myViewRepository.count();
    }

    @Override
    public Iterable<MyViewDTO> getAllAuthorsViewList() {
        return myViewRepository.findAll();
    }

    public List<Author> getSomeLegacyData(String firstParameter) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("StoredProcName");

        // Set the parameters of the stored procedure.
        String firstParam = "firstParam";
        storedProcedure.registerStoredProcedureParameter(firstParam, String.class, ParameterMode.IN);
        storedProcedure.setParameter(firstParam, firstParameter);

        // Call the stored procedure.
        List<Object[]> storedProcedureResults = storedProcedure.getResultList();

        // Use Java 8's cool new functional programming paradigm to map the objects from the stored procedure results
//        return storedProcedureResults.stream().map(result -> new User(
//                (Integer) result[0],
//                (String) result[1]
//        )).collect(Collectors.toList());
        return null;

    }
}
