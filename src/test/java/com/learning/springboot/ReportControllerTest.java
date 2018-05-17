package com.learning.springboot;

import com.learning.springboot.controller.ReportController;
import com.learning.springboot.service.ReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LearningSpringBoot.class})
public class ReportControllerTest {

    @Autowired
    private ReportController reportController;

    @MockBean
    private ReportService reportService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(reportController).isNotNull();
    }
}
