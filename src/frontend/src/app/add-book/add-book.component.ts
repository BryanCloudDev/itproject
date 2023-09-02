import { Component, OnInit } from '@angular/core';
import { AuthorResponse, CategoryResponse } from '../dto/BookResponse';
import { AddBookService } from './add-book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
})
export class AddBookComponent implements OnInit {
  public authors: AuthorResponse[] | undefined;
  public categories: CategoryResponse[] | undefined;

  constructor(private addBookService: AddBookService) {}

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
}
