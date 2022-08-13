import {Component, OnInit, ViewChild} from '@angular/core';
import {PaintService, RGB} from "../../../../service/paint.service";
import {ColorPickerCanvasComponent} from "../../../presentational/color-picker-canvas/color-picker-canvas.component";

@Component({
  selector: 'app-select-color-from-image',
  templateUrl: './select-color-from-image.component.html',
  styleUrls: ['./select-color-from-image.component.sass']
})
export class SelectColorFromImageComponent implements OnInit {

  private rgb?: RGB;

  @ViewChild(ColorPickerCanvasComponent)
  colorPickerCanvas!: ColorPickerCanvasComponent;

  constructor(
    private paintService: PaintService
  ) {}

  ngOnInit(): void {
  }

  onClickCanvas(imageData: ImageData): void {
    this.rgb = new RGB(
      imageData.data[0],
      imageData.data[1],
      imageData.data[2]
    );
    this.paintService.setRGB(this.rgb);
  }

  setDataUrlToCanvas(dataUrl: string): void {
    this.colorPickerCanvas.setDataUrl(dataUrl);
  }

  getClickedCanvasColor(): string {
    return (this.rgb === undefined) ? '' : this.rgb.toString();
  }


}
