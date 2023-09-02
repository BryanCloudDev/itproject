import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {
  AuthorResponse,
  BookResponse,
  CategoryResponse,
} from '../dto/BookResponse';
import { config } from '../common/config';
import { BookRequest } from '../dto/BookRequest';

@Injectable({
  providedIn: 'root',
})
export class UpdateBookService {
  constructor(private http: HttpClient) {}

  getBookById(id: number): Observable<BookResponse> {
    return this.http.get<BookResponse>(`${config.baseUrl}/books/${id}`);
  }

  editBookById(id: number | undefined, body: BookRequest) {
    return this.http.put(`${config.baseUrl}/books/${id}`, body);
  }
}
