import {AfterViewInit, Component, ElementRef, EventEmitter, Output, ViewChild} from '@angular/core';

@Component({
  selector: 'app-color-picker-canvas',
  templateUrl: './color-picker-canvas.component.html',
  styleUrls: ['./color-picker-canvas.component.sass']
})
export class ColorPickerCanvasComponent implements AfterViewInit {

  @ViewChild('myCanvas')
  private _canvasElement!: ElementRef

  private _canvasContext!: CanvasRenderingContext2D

  position = {};

  @Output()
  clickCanvas: EventEmitter<ImageData> = new EventEmitter<ImageData>();

  constructor() {}

  ngAfterViewInit(): void {
    this._canvasContext = this._canvasElement.nativeElement.getContext('2d')!;
  }

  setDataUrl(dataUrl: string): void {
    const img = new Image();
    img.src = dataUrl;
    img.onload = () => {
      this._canvasContext.canvas.width = img.width;
      this._canvasContext.canvas.height = img.height;
      this._canvasContext.drawImage(img, 0, 0);
    }
  }

  click(event: MouseEvent): void {
    this.position = {
      'top': event.offsetY - 10 + 'px',
      'left': event.offsetX - 10 + 'px'
    }
    this.clickCanvas.emit(this._canvasContext.getImageData(event.offsetX, event.offsetY, 1, 1));
  }
}
