import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {FindPaintRoutingModule} from './find-paint-routing.module';
import {FindPaintComponent} from "./find-paint.component";
import {MaterialModule} from "../../../material.module";
import {PageContainerComponent} from "../../shared/page-container/page-container.component";
import {SelectColorFromImageComponent} from "../container/select-color-from-image/select-color-from-image.component";
import {
  FindPaintsAndViewResultsComponent
} from "../container/find-paints-and-view-results/find-paints-and-view-results.component";


@NgModule({
  declarations: [
    FindPaintComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FindPaintRoutingModule,
    PageContainerComponent,
    SelectColorFromImageComponent,
    FindPaintsAndViewResultsComponent,
  ]
})
export class FindPaintModule {}
