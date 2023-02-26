import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FindPaintPageComponent} from "./page.component";

const routes: Routes = [
  { path: '', component: FindPaintPageComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FindPaintRoutingPageModule { }
