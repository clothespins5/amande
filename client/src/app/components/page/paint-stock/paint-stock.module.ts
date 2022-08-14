import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PaintStockRoutingModule} from './paint-stock-routing.module';
import {PaintStockComponent} from "./paint-stock.component";
import {MaterialModule} from "../../../material.module";
import {PageContainerModule} from "../../container/page-container/page-container.module";


@NgModule({
  declarations: [
    PaintStockComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    PaintStockRoutingModule,
    PageContainerModule,
  ]
})
export class PaintStockModule {}
