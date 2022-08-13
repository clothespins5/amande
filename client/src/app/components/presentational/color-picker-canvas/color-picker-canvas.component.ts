import {AfterViewInit, Component, ElementRef, EventEmitter, Output, ViewChild} from '@angular/core';

@Component({
  selector: 'app-color-picker-canvas',
  templateUrl: './color-picker-canvas.component.html',
  styleUrls: ['./color-picker-canvas.component.sass']
})
export class ColorPickerCanvasComponent implements AfterViewInit {

  public position = {};

  @ViewChild('myCanvas')
  private canvasElement!: ElementRef

  private canvasContext!: CanvasRenderingContext2D

  @Output()
  clickCanvas: EventEmitter<ImageData> = new EventEmitter<ImageData>();

  constructor() {}

  ngAfterViewInit(): void {
    this.canvasContext = this.canvasElement.nativeElement.getContext('2d')!;
  }

  setDataUrl(dataUrl: string): void {
    const img = new Image();
    img.src = dataUrl;
    img.onload = () => {
      this.canvasContext.canvas.width = img.width;
      this.canvasContext.canvas.height = img.height;
      this.canvasContext.drawImage(img, 0, 0);
    }
  }

  click(event: MouseEvent): void {
    this.position = {
      'top': event.offsetY + 'px',
      'left': event.offsetX + 'px'
    }
    this.clickCanvas.emit(this.canvasContext.getImageData(event.offsetX, event.offsetY, 1, 1));
  }
}
