import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-image-file-input-button',
  templateUrl: './image-file-input-button.component.html',
  styleUrls: ['./image-file-input-button.component.sass']
})
export class ImageFileInputButtonComponent implements OnInit {

  private reader: FileReader;

  @Output()
  onFileLoad = new EventEmitter<string>();

  constructor() {
    this.reader = new FileReader();
  }

  ngOnInit(): void {
    this.reader.onload = (event: Event) => {
      this.onFileLoad.emit(this.reader.result as string);
    }
  }

  change(event: Event) {
    const target = event.target as HTMLInputElement;
    const file = target.files?.[0] as File;
    this.reader.readAsDataURL(file);
  }

}
