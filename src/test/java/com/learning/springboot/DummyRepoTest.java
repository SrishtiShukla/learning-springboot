package com.learning.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes = {LearningSpringBoot.class})
//@TestPropertySource(locations = "classpath:application.properties")
public class DummyRepoTest {
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
    }
}
