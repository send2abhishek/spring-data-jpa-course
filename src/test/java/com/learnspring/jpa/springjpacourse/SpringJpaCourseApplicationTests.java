package com.learnspring.jpa.springjpacourse;

import com.learnspring.jpa.springjpacourse.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringJpaCourseApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testRepository() {
        long count = bookRepository.count();

        assertThat(count).isGreaterThan(0);
    }

    @Test
    void contextLoads() {
    }

}
