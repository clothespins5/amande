import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaintManagementTableComponent } from './paint-management-table/paint-management-table.component';
import {MatButtonModule} from "@angular/material/button";



@NgModule({
  declarations: [
    PaintManagementTableComponent
  ],
  exports: [
    PaintManagementTableComponent
  ],
  imports: [
    CommonModule,
    MatButtonModule
  ]
})
export class PaintManagementContainerModule { }
