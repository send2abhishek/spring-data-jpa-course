package com.learnspring.jpa.springjpacourse.bootStrap;

import com.learnspring.jpa.springjpacourse.domain.Book;
import com.learnspring.jpa.springjpacourse.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            List<Book> books = List.of(new Book("Spring Framework", "1234", "John", null), new Book("Spring in Action", "1234", "James", null));
            bookRepository.saveAll(books);
        }
    }
}
