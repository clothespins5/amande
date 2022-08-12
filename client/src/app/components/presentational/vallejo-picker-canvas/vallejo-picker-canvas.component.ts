import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { VallejoPickerCanvasService } from '../../../service/vallejo-picker-canvas.service';

@Component({
  selector: 'app-vallejo-picker-canvas',
  templateUrl: './vallejo-picker-canvas.component.html',
  styleUrls: ['./vallejo-picker-canvas.component.sass']
})
export class VallejoPickerCanvasComponent implements AfterViewInit {

  public position = {};

  @ViewChild('myCanvas')
  private canvasElement!: ElementRef

  private canvasContext!: CanvasRenderingContext2D

  constructor(
    private vallejoPickerCanvasService: VallejoPickerCanvasService,
  ) { }

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

  onClick(event: MouseEvent): void {

    const imageData: ImageData = this.canvasContext.getImageData(event.offsetX, event.offsetY, 1, 1);
    this.vallejoPickerCanvasService.setColor(imageData);
    this.position = {
      'top': event.offsetY + 'px',
      'left': event.offsetX + 'px'
    }
  }


}
