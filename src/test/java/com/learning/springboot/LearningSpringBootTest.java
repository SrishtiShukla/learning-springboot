package com.learning.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LearningSpringBoot.class})
@TestPropertySource(locations = "classpath:application-dev.properties")
public class LearningSpringBootTest {

    @Test
    public void contextLoads() throws Exception {
    }

}

