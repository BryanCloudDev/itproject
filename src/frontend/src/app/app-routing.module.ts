import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { BookAdministrationComponent } from './book-administration/book-administration.component';
import { AddBookComponent } from './add-book/add-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';

const routes: Routes = [
  { path: '', component: IndexComponent },
  { path: 'book-administration', component: BookAdministrationComponent },
  { path: 'add-books', component: AddBookComponent },
  { path: 'update-book/:id', component: UpdateBookComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
