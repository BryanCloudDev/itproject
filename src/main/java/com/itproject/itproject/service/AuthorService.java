package com.itproject.itproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itproject.itproject.dto.AuthorDTO;
import com.itproject.itproject.model.Author;
import com.itproject.itproject.repository.AuthorRepository;

@Service
public class AuthorService {

  @Autowired
  private final AuthorRepository authorRepository;

  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author createAuthor(AuthorDTO authorDTO) {
    Author author = this.convertDTOToEntity(authorDTO);
    return authorRepository.save(author);
  }

  public Author getAuthorById(Long id) {
    return authorRepository.findById(id).orElse(null);
  }

  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }

  public Author updateAuthor(Long id, Author updatedAuthor) {
    return authorRepository.findById(id).map(author -> {
      author.setName(updatedAuthor.getName());
      author.setBirthDate(updatedAuthor.getBirthDate());
      author.setCountry(updatedAuthor.getCountry());
      return authorRepository.save(author);
    }).orElse(null);
  }

  public void deleteAuthor(Long id) {
    authorRepository.deleteById(id);
  }

  public Author convertDTOToEntity(AuthorDTO authorDTO) {
    Author author = new Author();
    author.setName(authorDTO.getName());
    author.setBirthDate(authorDTO.getBirthDate());
    author.setCountry(authorDTO.getCountry());
    return author;
  }
}
