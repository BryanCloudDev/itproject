import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {
  AuthorResponse,
  BookResponse,
  CategoryResponse,
} from '../dto/BookResponse';
import { config } from '../common/config';

@Injectable({
  providedIn: 'root',
})
export class BookAdministrationService {
  constructor(private http: HttpClient) {}

  getBooks(): Observable<BookResponse[]> {
    return this.http.get<BookResponse[]>(`${config.baseUrl}/books`);
  }

  getCategories(): Observable<CategoryResponse[]> {
    return this.http.get<CategoryResponse[]>(`${config.baseUrl}/categories`);
  }

  getAuthors(): Observable<AuthorResponse[]> {
    return this.http.get<AuthorResponse[]>(`${config.baseUrl}/authors`);
  }

  public editBook(id: number) {
    // return this.http.put<AuthorResponse>(`${config.baseUrl}/authors/${id}`, body);
  }

  public deleteBook(id: number) {
    return this.http.delete(`${config.baseUrl}/books/${id}`);
  }
}
