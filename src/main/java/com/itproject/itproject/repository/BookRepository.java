package com.itproject.itproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itproject.itproject.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
  
}
