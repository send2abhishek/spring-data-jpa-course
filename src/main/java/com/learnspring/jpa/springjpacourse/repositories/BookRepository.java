package com.learnspring.jpa.springjpacourse.repositories;

import com.learnspring.jpa.springjpacourse.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
