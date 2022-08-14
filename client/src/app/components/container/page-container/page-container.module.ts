import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PageContainerComponent} from "./page-container.component";
import {MaterialModule} from "../../../material.module";
import {RouterModule} from "@angular/router";



@NgModule({
  declarations: [
    PageContainerComponent
  ],
  exports: [
    PageContainerComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    RouterModule,
  ]
})
export class PageContainerModule { }
