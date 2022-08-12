import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Subscription } from 'rxjs';
import { ImageFileInputService } from '../../../service/image-file-input.service';
import { VallejoPickerCanvasComponent } from '../../presentational/vallejo-picker-canvas/vallejo-picker-canvas.component';
import { VallejoPickerCanvasService } from '../../../service/vallejo-picker-canvas.service';
import { VallejoColor, VallejoTableComponent } from '../../container/vallejo-picker/vallejo-table/vallejo-table.component';
import { VallejoTableService } from '../../../service/vallejo-table.service';

@Component({
  selector: 'app-vallejo-picker',
  templateUrl: './vallejo-picker.component.html',
  styleUrls: ['./vallejo-picker.component.sass']
})
export class VallejoPickerComponent implements OnInit, OnDestroy {

  private dataUrlSubscription!: Subscription;

  private selectedColorSubscription!: Subscription;

  public selectedColor: string = "";

  @ViewChild(VallejoPickerCanvasComponent)
  public vallejoPickerCanvas!: VallejoPickerCanvasComponent;

  @ViewChild(VallejoTableComponent)
  public vallejoTable!: VallejoTableComponent;

  constructor(
    private imageFileInputService: ImageFileInputService,
    private vallejoPickerCanvasService: VallejoPickerCanvasService,
    private vallejoTableService: VallejoTableService,
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

  serchVallejoColors(): void {

    this.vallejoTableService.getVallejoColors(this.selectedColor)
      .subscribe(
        (vallejoColors: VallejoColor[]) => {
          this.vallejoTable.setVallejoColors(vallejoColors);
        }
      );
  }


}
