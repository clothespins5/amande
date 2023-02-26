import {Component, OnDestroy} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ColorPickerCanvasComponent} from "../../presentational/color-picker-canvas/color-picker-canvas.component";
import {
  ImageFileInputButtonComponent
} from "../../presentational/image-file-input-button/image-file-input-button.component";
import {MatButtonModule} from "@angular/material/button";
import {PaintTableComponent} from "../../presentational/paint-table/paint-table.component";
import {RGB} from "../../../../lib/shared/rgb";
import {Subject, takeUntil} from "rxjs";
import {NearestPaints, PaintQueryService} from "../../../../lib/service/paint-query.service";

@Component({
  selector: 'app-find-paints-container',
  standalone: true,
  imports: [
    CommonModule,
    ColorPickerCanvasComponent,
    ImageFileInputButtonComponent,
    MatButtonModule,
    PaintTableComponent
  ],
  templateUrl: 'find-paints-container.component.html',
  styleUrls: ['find-paints-container.component.sass']
})
export class FindPaintsContainerComponent implements OnDestroy {

  loadedImageDataUrl: string = '';
  nearestPaints: NearestPaints = [];
  clickedCanvasColor = new RGB(0, 0, 0);
  private _onDestroy$ = new Subject();
  constructor(
    private readonly paintQueryService: PaintQueryService
  ) {}

  ngOnDestroy(): void {
    this._onDestroy$.next(true);
    this._onDestroy$.unsubscribe();
  }

  searchNearestPaints(): void {
    this.paintQueryService
      .searchNearestPaints(this.clickedCanvasColor)
      .pipe(takeUntil(this._onDestroy$))
      .subscribe(nearestPaints => this.nearestPaints = nearestPaints);
  }

  onClickCanvas(imageData: ImageData): void {
    this.clickedCanvasColor = new RGB(
      imageData.data[0],
      imageData.data[1],
      imageData.data[2]
    );
  }

}
