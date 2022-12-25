import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {FindPaintRoutingModule} from './find-paint-routing.module';
import {FindPaintComponent} from "./find-paint.component";
import {ColorPickerCanvasComponent} from "../presentational/color-picker-canvas/color-picker-canvas.component";
import {
  ImageFileInputButtonComponent
} from "../presentational/image-file-input-button/image-file-input-button.component";
import {PaintTableComponent} from "../presentational/paint-table/paint-table.component";
import {
  FindPaintsAndViewResultsComponent
} from "../container/find-paints-and-view-results/find-paints-and-view-results.component";
import {
  SelectColorFromImageComponent
} from "../container/select-color-from-image/select-color-from-image.component";
import {MaterialModule} from "../../../material.module";
import {PageContainerModule} from "../../shared/page-container/page-container.module";


@NgModule({
  declarations: [
    FindPaintComponent,
    ColorPickerCanvasComponent,
    ImageFileInputButtonComponent,
    PaintTableComponent,
    FindPaintsAndViewResultsComponent,
    SelectColorFromImageComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FindPaintRoutingModule,
    PageContainerModule,
  ]
})
export class FindPaintModule {}
