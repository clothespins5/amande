import {Component, OnInit, ViewChild} from '@angular/core';
import {PaintService, RGB} from "../../../../service/paint.service";
import {ColorPickerCanvasComponent} from "../../../presentational/color-picker-canvas/color-picker-canvas.component";

@Component({
  selector: 'app-select-color-from-image',
  templateUrl: './select-color-from-image.component.html',
  styleUrls: ['./select-color-from-image.component.sass']
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
    this.paintService.setRGB(this._rgb);
  }

  setDataUrlToCanvas(dataUrl: string): void {
    this.colorPickerCanvasComponent.setDataUrl(dataUrl);
  }

  getClickedCanvasColor(): string {
    return (this._rgb === undefined) ? '' : this._rgb.toString();
  }


}
