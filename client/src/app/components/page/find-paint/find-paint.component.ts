import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Subscription } from 'rxjs';
import { ImageFileInputService } from '../../../service/image-file-input.service';
import { ColorPickerCanvasComponent } from '../../presentational/color-picker-canvas/color-picker-canvas.component';
import { VallejoPickerCanvasService } from '../../../service/vallejo-picker-canvas.service';
import { VallejoColor, PaintTableComponent } from '../../presentational/paint-table/paint-table.component';
import { PaintService } from '../../../service/paint.service';

@Component({
  selector: 'app-find-paint',
  templateUrl: './find-paint.component.html',
  styleUrls: ['./find-paint.component.sass']
})
export class FindPaintComponent implements OnInit, OnDestroy {

  private dataUrlSubscription!: Subscription;

  private selectedColorSubscription!: Subscription;

  public selectedColor: string = "";

  @ViewChild(ColorPickerCanvasComponent)
  public vallejoPickerCanvas!: ColorPickerCanvasComponent;

  @ViewChild(PaintTableComponent)
  public vallejoTable!: PaintTableComponent;

  constructor(
    private imageFileInputService: ImageFileInputService,
    private vallejoPickerCanvasService: VallejoPickerCanvasService,
    private vallejoTableService: PaintService,
  ) { }

  ngOnInit(): void {

    this.dataUrlSubscription = this.imageFileInputService.dataURLObservable.subscribe(
      (dataUrl: string) => {
        this.vallejoPickerCanvas.setDataUrl(dataUrl);
      }
    );

    this.selectedColorSubscription = this.vallejoPickerCanvasService.selectedColorObservable.subscribe(
      (selectedColor: string) => {
        this.selectedColor = selectedColor;
      }
    );

  }

  ngOnDestroy(): void {

    this.dataUrlSubscription.unsubscribe();
    this.selectedColorSubscription.unsubscribe();

  }

  findPaints(): void {

    // this.vallejoTableService.fetchPaints(this.selectedColor)
    //   .subscribe(
    //     (vallejoColors: VallejoColor[]) => {
    //       this.vallejoTable.setVallejoColors(vallejoColors);
    //     }
    //   );
  }


}
