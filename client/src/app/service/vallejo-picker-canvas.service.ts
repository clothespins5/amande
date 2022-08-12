import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VallejoPickerCanvasService {

  
  private selectedColor: Subject<string>;

  public selectedColorObservable: Observable<string>;

  private red: number = 0;

  private green: number = 0;

  private blue: number = 0;

  constructor() { 
    this.selectedColor = new Subject<string>();
    this.selectedColorObservable = this.selectedColor.asObservable();
  }

  public setColor(imageData: ImageData): void {

    this.red = imageData.data[0];
    this.green = imageData.data[1];
    this.blue = imageData.data[2];
    this.onNotifySelectedColorChanged('rgb(' + this.red + ',' + this.green + ',' + this.blue + ')');

  }

  public onNotifySelectedColorChanged(updated: string): void {

    this.selectedColor.next(updated)

  }


  
}
