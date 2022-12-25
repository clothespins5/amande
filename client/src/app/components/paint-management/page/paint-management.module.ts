import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PaintManagementRoutingModule} from './paint-management-routing.module';
import {PaintManagementComponent} from "./paint-management.component";
import {MaterialModule} from "../../../material.module";
import {PageContainerModule} from "../../shared/page-container/page-container.module";
import {PaintManagementContainerModule} from "../container/paint-management-container.module";


@NgModule({
  declarations: [
    PaintManagementComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    PaintManagementRoutingModule,
    PageContainerModule,
    PaintManagementContainerModule,
  ]
})
export class PaintManagementModule {}
