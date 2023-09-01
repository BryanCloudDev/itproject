package com.itproject.itproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itproject.itproject.model.Author;
import com.itproject.itproject.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
  
  @Autowired
  private AuthorService authorService;

  @PostMapping
    public ResponseEntity<Author> crearAuthor(@RequestBody Author author) {
      System.out.println(author);
      Author newAuthor = authorService.createAuthor(author);
      return ResponseEntity.status(HttpStatus.CREATED).body(newAuthor);
    }

  @GetMapping("/{id}")
  public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
    Author author = authorService.getAuthorById(id);
    if (author != null) {
      return ResponseEntity.ok(author);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping
  public ResponseEntity<List<Author>> getAllAuthors() {
    List<Author> authors = authorService.getAllAuthors();
    return ResponseEntity.ok(authors);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
    Author author = authorService.updateAuthor(id, updatedAuthor);
    if (author != null) {
      return ResponseEntity.ok(author);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
    authorService.deleteAuthor(id);
    return ResponseEntity.noContent().build();
  }
}
