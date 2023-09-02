import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { BookAdministrationComponent } from './book-administration/book-administration.component';

const routes: Routes = [
  { path: '', component: IndexComponent },
  { path: 'book-administration', component: BookAdministrationComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
