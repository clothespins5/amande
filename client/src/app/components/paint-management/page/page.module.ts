import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PaintManagementRoutingModule} from './page-routing.module';
import {PaintManagementComponent} from "./page.component";
import {MaterialModule} from "../../../material.module";
import {PageContainerComponent} from "../../shared/page-container/page-container.component";
import {PaintManagementTableComponent} from "../container/table/table.component";


@NgModule({
  declarations: [
    PaintManagementComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    PaintManagementRoutingModule,
    PageContainerComponent,
    PaintManagementTableComponent,
  ]
})
export class PaintManagementModule {}
