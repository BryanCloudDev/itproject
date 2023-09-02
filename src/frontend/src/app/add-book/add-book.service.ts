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
export class AddBookService {
  constructor(private http: HttpClient) {}

  getCategories(): Observable<CategoryResponse[]> {
    return this.http.get<CategoryResponse[]>(`${config.baseUrl}/categories`);
  }

  getAuthors(): Observable<AuthorResponse[]> {
    return this.http.get<AuthorResponse[]>(`${config.baseUrl}/authors`);
  }
}
