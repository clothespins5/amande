import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VallejoPickerComponent } from './components/pages/vallejo-picker/vallejo-picker.component';

const routes: Routes = [
  { path: '', component: VallejoPickerComponent },
  { path: 'vallejo-picker', component: VallejoPickerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
