import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FindPaintComponent} from "./find-paint.component";

const routes: Routes = [
  { path: '', component: FindPaintComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FindPaintRoutingModule { }
