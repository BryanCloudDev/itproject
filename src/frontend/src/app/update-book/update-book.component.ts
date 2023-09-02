import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookResponse } from '../dto/BookResponse';
import { UpdateBookService } from './update-book.service';
import { BookRequest } from '../dto/BookRequest';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
})
export class UpdateBookComponent implements OnInit {
  private id: number = 0;
  public book: BookResponse | undefined;
  public bookUpdated: BookRequest = {
    name: '',
    price: 0,
    authorId: 0,
    categoryId: 0,
  };

  constructor(
    private updateBookService: UpdateBookService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
    });
  }
  ngOnInit(): void {
    this.getBookById(this.id);
  }

  getBookById(id: number) {
    this.updateBookService.getBookById(id).subscribe((book) => {
      this.book = book;
      this.bookUpdated = {
        name: this.book.name,
        price: this.book.price,
        status: this.book.status,
        authorId: this.book.author.id,
        categoryId: this.book.category.id,
      };
    });
  }

  redirectToAdminPage() {
    this.router.navigate(['/book-administration']);
  }

  editBookById() {
    console.log(this.bookUpdated);

    this.updateBookService
      .editBookById(this.book?.id, this.bookUpdated)
      .subscribe(() => {
        this.redirectToAdminPage();
      });
  }

  onSubmit() {
    this.editBookById();
  }

  onCheckboxChange(event: any) {
    this.bookUpdated.status = event.target.checked;
  }
}
