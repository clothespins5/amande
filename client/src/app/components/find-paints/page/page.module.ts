import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {FindPaintRoutingPageModule} from './page-routing.module';
import {FindPaintPageComponent} from "./page.component";
import {MaterialModule} from "../../../material.module";
import {PageContainerComponent} from "../../shared/page-container/page-container.component";
import {FindPaintsContainerComponent} from "../container/find-paints-container/find-paints-container.component";


@NgModule({
  declarations: [
    FindPaintPageComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FindPaintRoutingPageModule,
    PageContainerComponent,
    FindPaintsContainerComponent,
  ]
})
export class FindPaintPageModule {}
