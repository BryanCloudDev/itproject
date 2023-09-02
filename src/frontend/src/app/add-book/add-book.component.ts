import { Component, OnInit } from '@angular/core';
import { AuthorResponse, CategoryResponse } from '../dto/BookResponse';
import { AddBookService } from './add-book.service';
import { BookRequest } from '../dto/BookRequest';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
})
export class AddBookComponent implements OnInit {
  public authors: AuthorResponse[] | undefined;
  public categories: CategoryResponse[] | undefined;
  public book: BookRequest = {
    name: '',
    authorId: 0,
    categoryId: 0,
    price: 0,
  };

  constructor(private addBookService: AddBookService, private router: Router) {}

  ngOnInit(): void {
    this.getAuthors();
    this.getCategories();
  }

  private getAuthors() {
    this.addBookService.getAuthors().subscribe((authors) => {
      this.authors = authors;
    });
  }

  private getCategories() {
    this.addBookService.getCategories().subscribe((categories) => {
      this.categories = categories;
    });
  }

  goToListOfBooks() {
    this.router.navigate(['/book-administration']);
  }

  createBook() {
    this.addBookService.createBook(this.book).subscribe((data) => {
      this.goToListOfBooks();
    });
  }

  onSubmit() {
    this.createBook();
  }
}
