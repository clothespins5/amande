import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PaintManagementRoutingModule} from './paint-management-routing.module';
import {PaintManagementComponent} from "./paint-management.component";
import {MaterialModule} from "../../../material.module";
import {PageContainerComponent} from "../../shared/page-container/page-container.component";
import {PaintManagementTableComponent} from "../container/paint-management-table/paint-management-table.component";


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
