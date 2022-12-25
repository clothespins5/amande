import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-image-file-input-button',
  template: `
    <input type="file" (change)="change($event)">
  `
})
export class ImageFileInputButtonComponent implements OnInit {

  private _reader: FileReader;

  @Output()
  onFileLoad: EventEmitter<string> = new EventEmitter<string>();

  constructor() {
    this._reader = new FileReader();
  }

  ngOnInit(): void {
    this._reader.onload = () => {
      this.onFileLoad.emit(this._reader.result as string);
    }
  }

  change(event: Event) {
    const target = event.target as HTMLInputElement;
    const file = target.files?.[0] as File;
    this._reader.readAsDataURL(file);
  }

}
