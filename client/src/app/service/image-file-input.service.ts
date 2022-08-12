import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageFileInputService {

  private dataURL: Subject<string>;

  public dataURLObservable: Observable<string>;

  constructor() { 
    this.dataURL = new Subject<string>();
    this.dataURLObservable = this.dataURL.asObservable();
  }

  public onNotifyDataURLChanged(updated: string): void {
    this.dataURL.next(updated);
  }
}
