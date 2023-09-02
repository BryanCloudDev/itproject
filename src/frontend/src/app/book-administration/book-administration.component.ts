import { Component, OnInit } from '@angular/core';
import { BookResponse } from '../dto/BookResponse';
import { BookAdministrationService } from './book-administration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-administration',
  templateUrl: './book-administration.component.html',
})
export class BookAdministrationComponent implements OnInit {
  public books: BookResponse[] | undefined;

  constructor(
    private bookAdministrationService: BookAdministrationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getBooks();
  }

  private getBooks() {
    this.bookAdministrationService.getBooks().subscribe((books) => {
      this.books = books;
    });
  }

  public editBook(id: number) {}

  public deleteBook(id: number) {
    this.bookAdministrationService.deleteBook(id).subscribe((result) => {
      this.getBooks();
    });
  }
}
