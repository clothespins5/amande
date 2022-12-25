import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PaintManagementComponent} from "./paint-management.component";

const routes: Routes = [
  { path: '', component: PaintManagementComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PaintManagementRoutingModule { }
