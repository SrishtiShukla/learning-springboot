package com.learning.springboot.controller;

import com.google.common.collect.Lists;
import com.learning.springboot.service.ReportService;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsCsvView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private static final Logger logger = Logger.getLogger(ReportController.class);

    private ApplicationContext applicationContext;

    private ReportService reportService;

    public ReportController() {
    }

    @Autowired
    public ReportController(ApplicationContext applicationContext,
                            ReportService reportService) {
        this.applicationContext = applicationContext;
        this.reportService = reportService;
    }

    @GetMapping
    public ModelAndView getAuthorList() {
        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:authors_report.jrxml");
        view.setApplicationContext(applicationContext);
        JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(
                Lists.newArrayList(reportService.getAllAuthorsList()));
        return new ModelAndView(view, "authorData", jrds);

    }

    @GetMapping("/procedure")
    public ModelAndView getAuthorProcedureList() {
        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:authors_procedure.jrxml");
        view.setApplicationContext(applicationContext);
        JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(
                Lists.newArrayList(reportService.getAllAuthorsList()));
        return new ModelAndView(view, "authorData", jrds);

    }

    @GetMapping("/view")
    public ModelAndView getAuthorViewList() {
        JasperReportsCsvView view = new JasperReportsCsvView();
//        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:authors_view.jrxml");
        view.setApplicationContext(applicationContext);
        JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(
                Lists.newArrayList(reportService.getAllAuthorsViewList()));
        return new ModelAndView(view, "authorData", jrds);

    }

    @PostMapping("/birt")
    public ResponseEntity<byte[]> getBIRTReport() {
        byte[] reportBytes;
        ResponseEntity<byte[]> responseEntity;
//        try {
//            logger.info("REPORT REQUEST NAME:  Authors ");
//            ReportEngine
//                    reportBytes =
//                    new BIRTReport(
//                            reportRequest.getReportName(),
//                            reportRequest.getReportParameters(),
//                            reportRunner)
//                            .runReport().getReportContent().toByteArray();
//
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.setContentType(MediaType.parseMediaType("application/pdf"));
//            String fileName = reportRequest.getReportName() + ".pdf";
//            httpHeaders.setContentDispositionFormData(fileName, fileName);
//            httpHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//            responseEntity = new ResponseEntity<byte[]>(reportBytes, httpHeaders, HttpStatus.OK);
//        } catch (Exception e) {
//            responseEntity = new ResponseEntity<byte[]>(HttpStatus.NOT_IMPLEMENTED);
//            return responseEntity;
//        }
//        return responseEntity;
        return null;
    }

    @GetMapping("/count")
    public Long getAuthorListCount() {
        return reportService.countAuthors();
    }

}
