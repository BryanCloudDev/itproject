package com.itproject.itproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itproject.itproject.dto.BookDTO;
import com.itproject.itproject.model.Author;
import com.itproject.itproject.model.Book;
import com.itproject.itproject.model.Category;
import com.itproject.itproject.repository.BookRepository;

@Service
public class BookService {

  @Autowired
  private final BookRepository bookRepository;
  @Autowired
  private AuthorService authorService;
  @Autowired
  private final CategoryService categoryService;

  public BookService(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
    this.bookRepository = bookRepository;
    this.authorService = authorService;
    this.categoryService = categoryService;
  }

  public Book createBook(BookDTO bookDTO) {
    Author author = authorService.getAuthorById(bookDTO.getAuthorId());
    Category category = categoryService.getCategoryById(bookDTO.getCategoryId());

    if (author == null || category == null) {
      return null;
    }

    Book newBook = this.convertDTOToEntity(bookDTO, author, category);

    return bookRepository.save(newBook);
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Book getBookById(Long id) {
    return bookRepository.findById(id).orElse(null);
  }

  public Book updateBook(Long id, BookDTO updatedBook) {
    Author author = authorService.getAuthorById(updatedBook.getAuthorId());
    Category category = categoryService.getCategoryById(updatedBook.getCategoryId());

    if (author == null || category == null) {
      return null;
    }

    return bookRepository.findById(id)
        .map(book -> {
          book.setName(updatedBook.getName());
          book.setPrice(updatedBook.getPrice());
          book.setAuthor(author);
          book.setCategory(category);
          book.setStatus(updatedBook.getStatus());
          return bookRepository.save(book);
        })
        .orElse(null);
  }

  public Book deactivateBook(Long id) {
    return bookRepository.findById(id)
        .map(book -> {
          book.setStatus(false);
          return bookRepository.save(book);
        }).orElse(null);
  }

  public Book convertDTOToEntity(BookDTO bookDTO, Author author, Category category) {
    Book newBook = new Book();
    newBook.setName(bookDTO.getName());
    newBook.setAuthor(author);
    newBook.setCategory(category);
    newBook.setPrice(bookDTO.getPrice());
    newBook.setStatus(true);
    return newBook;
  }
}
