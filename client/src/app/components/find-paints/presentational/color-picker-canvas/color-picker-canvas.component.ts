import {AfterViewInit, Component, ElementRef, EventEmitter, Input, OnChanges, Output, ViewChild} from '@angular/core';
import {NgStyle} from "@angular/common";

@Component({
  selector: 'app-color-picker-canvas',
  standalone: true,
  imports: [
    NgStyle
  ],
  template: `
    <div class="canvas-block">
      <div class="pick-mark" [ngStyle]="position"></div>
      <canvas #myCanvas (click)="click($event)"></canvas>
    </div>
  `,
  styles: [`
    .canvas-block
      position: relative

      .pick-mark
        position: absolute
        width: 1rem
        height: 1rem
        border-radius: 1rem
        border: solid 0.1rem black

      canvas
        border: solid 0.1rem black
        border-radius: 0.25rem
  `]
})
export class ColorPickerCanvasComponent implements AfterViewInit, OnChanges {

  @Input()
  dataUrl!: string;

  @Output()
  clickCanvas: EventEmitter<ImageData> = new EventEmitter<ImageData>();

  @ViewChild('myCanvas')
  private _canvasElement!: ElementRef

  private _canvasContext!: CanvasRenderingContext2D

  position = {};

  constructor() {}

  ngAfterViewInit(): void {
    this._canvasContext = this._canvasElement.nativeElement.getContext('2d')!;
  }

  ngOnChanges(): void {
    const img = new Image();
    img.src = this.dataUrl;
    img.onload = () => {
      const shrinkageRateY = 400 / img.height;
      const shrinkageRateX = 400 / img.width;
      const shrinkageRate = (shrinkageRateY < shrinkageRateX) ? shrinkageRateY : shrinkageRateX;
      const canvasWidth = img.width * shrinkageRate;
      const canvasHeight = img.height * shrinkageRate;
      this._canvasContext.canvas.width = canvasWidth;
      this._canvasContext.canvas.height = canvasHeight;
      this._canvasContext.drawImage(img, 0, 0, canvasWidth, canvasHeight);
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
