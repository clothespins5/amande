import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PaintStockComponent} from "./paint-stock.component";

const routes: Routes = [
  { path: '', component: PaintStockComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PaintStockRoutingModule { }
