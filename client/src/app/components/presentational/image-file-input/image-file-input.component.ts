import { Component, OnInit } from '@angular/core';
import { ImageFileInputService } from './image-file-input.service';

@Component({
  selector: 'app-image-file-input',
  templateUrl: './image-file-input.component.html',
  styleUrls: ['./image-file-input.component.sass']
})
export class ImageFileInputComponent implements OnInit {

  private reader: FileReader;

  constructor(private imageFileInputService: ImageFileInputService) { 
    this.reader = new FileReader();
  }

  ngOnInit(): void {

    this.reader.onload = (event: Event) => {

      this.imageFileInputService.onNotifyDataURLChanged(this.reader.result as string);

    }

  }

  public onChange(event: Event) {

    const target = event.target as HTMLInputElement;
    const file = target.files?.[0] as File;
    this.reader.readAsDataURL(file);

  }

}
