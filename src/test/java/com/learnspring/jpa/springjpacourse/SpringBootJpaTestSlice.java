package com.learnspring.jpa.springjpacourse;


import com.learnspring.jpa.springjpacourse.domain.Book;
import com.learnspring.jpa.springjpacourse.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// this will load minimal context for testing for spring data repository, this will scans the repositories,entities.
// This will not load the data insilizer which we are doing to load initial data

//bring the data initializer
@ComponentScan(basePackages = {" com.learnspring.jpa.springjpacourse.bootStrap"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    // typically, we don't use order of execution it should execute in random order as default
    @Commit
    @Order(1)
    @Test
    void testJpaTestSplice() {
        long count = bookRepository.count();

        assertThat(count).isEqualTo(2);

        bookRepository.save(new Book("Demo Book", "12345", "self"));

        long countAfter = bookRepository.count();

        assertThat(count).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        long countAfter = bookRepository.count();
        assertThat(countAfter).isEqualTo(3);

    }
}
