package com.itproject.itproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.itproject.itproject.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
  
}
