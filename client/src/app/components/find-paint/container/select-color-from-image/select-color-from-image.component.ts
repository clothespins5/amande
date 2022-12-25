import {Component, OnInit, ViewChild} from '@angular/core';
import {PaintService, RGB} from "../../../../service/paint.service";
import {ColorPickerCanvasComponent} from "../../presentational/color-picker-canvas/color-picker-canvas.component";

@Component({
  selector: 'app-select-color-from-image',
  template: `
    <div class="select-color-from-image-block">
      <app-color-picker-canvas (clickCanvas)="onClickCanvas($event)"></app-color-picker-canvas>
      <div>
        <app-image-file-input-button (onFileLoad)="setDataUrlToCanvas($event)"></app-image-file-input-button>
        <div>
          <span class="selectedColor" [style.background-color]="getClickedCanvasColor()"></span>
          {{getClickedCanvasColor()}}
        </div>
      </div>
    </div>
  `,
  styles: [`
    .select-color-from-image-block
      display: flex
      flex-direction: column
      align-items: center

    .selectedColor
      display: inline-block
      width: 1rem
      height: 1rem
      border: solid 0.1rem black
      border-radius: 0.3rem
  `]
})
export class SelectColorFromImageComponent implements OnInit {

  private _rgb?: RGB;

  @ViewChild(ColorPickerCanvasComponent)
  colorPickerCanvasComponent!: ColorPickerCanvasComponent;

  constructor(
    private paintService: PaintService
  ) {}

  ngOnInit(): void {
  }

  onClickCanvas(imageData: ImageData): void {
    this._rgb = new RGB(
      imageData.data[0],
      imageData.data[1],
      imageData.data[2]
    );
    this.paintService.changeRGB(this._rgb);
  }

  setDataUrlToCanvas(dataUrl: string): void {
    this.colorPickerCanvasComponent.setDataUrl(dataUrl);
  }

  getClickedCanvasColor(): string {
    return (this._rgb === undefined) ? '' : this._rgb.toString();
  }


}
