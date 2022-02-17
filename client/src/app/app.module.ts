import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatTableModule } from '@angular/material/table';
import { VallejoPickerComponent } from './components/pages/vallejo-picker/vallejo-picker.component';
import { VallejoPickerCanvasComponent } from './components/atoms/vallejo-picker-canvas/vallejo-picker-canvas.component';
import { ImageFileInputComponent } from './components/atoms/image-file-input/image-file-input.component';
import { VallejoTableComponent } from './components/molecules/vallejo-table/vallejo-table.component';

@NgModule({
  declarations: [
    AppComponent,
    VallejoPickerComponent,
    VallejoPickerCanvasComponent,
    ImageFileInputComponent,
    VallejoTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTableModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
