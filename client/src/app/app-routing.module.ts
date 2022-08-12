import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FindPaintComponent } from './components/page/find-paint/find-paint.component';

const routes: Routes = [
  { path: '', component: FindPaintComponent },
  { path: 'vallejo-picker', component: FindPaintComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
