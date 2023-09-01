package com.itproject.itproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itproject.itproject.model.Book;
import com.itproject.itproject.repository.BookRepository;

@Service
public class BookService {

  @Autowired
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
  }

  public Book createBook(Book book) {
      return bookRepository.save(book);
  }

  public List<Book> getAllBooks() {
      return bookRepository.findAll();
  }

  public Book getBookById(Long id) {
    return bookRepository.findById(id).orElse(null);
  }

  public Book updateBook(Long id, Book updatedBook) {
    return bookRepository.findById(id)
      .map(book -> {
          book.setName(updatedBook.getName());
          book.setAuthor(updatedBook.getAuthor());
          book.setCategory(updatedBook.getCategory());
          book.setPrice(updatedBook.getPrice());
          book.setStatus(updatedBook.getStatus());
          return bookRepository.save(book);
      })
      .orElse(null);
  }

  public void deleteBook(Long id) {
      bookRepository.deleteById(id);
  }
}
