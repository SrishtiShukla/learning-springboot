package com.learning.springboot;

import com.learning.springboot.service.impl.ReportServiceImpl;
import com.learning.springboot.service.ReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LearningSpringBoot.class})
@TestPropertySource(locations = "classpath:application.properties")
public class ReportServiceImplTest {

    @TestConfiguration
    static class ReportServiceImplTestTestContextConfiguration {

        @Bean
        public ReportServiceImpl reportService() {
            return new ReportServiceImpl();
        }
    }

    @Autowired
    ReportService reportService;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
    }
}
