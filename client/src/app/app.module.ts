import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTableModule } from '@angular/material/table';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { VallejoPickerComponent } from './components/pages/vallejo-picker/vallejo-picker.component';
import { VallejoPickerCanvasComponent } from './components/atoms/vallejo-picker-canvas/vallejo-picker-canvas.component';
import { ImageFileInputComponent } from './components/atoms/image-file-input/image-file-input.component';
import { VallejoTableComponent } from './components/molecules/vallejo-table/vallejo-table.component';
import { PageContainerComponent } from './components/templates/page-container/page-container.component';

@NgModule({
  declarations: [
    AppComponent,
    VallejoPickerComponent,
    VallejoPickerCanvasComponent,
    ImageFileInputComponent,
    VallejoTableComponent,
    PageContainerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
