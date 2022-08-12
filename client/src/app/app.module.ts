import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatSelectModule } from '@angular/material/select';
import { MatChipsModule } from '@angular/material/chips';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDialogModule } from '@angular/material/dialog';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatMenuModule } from '@angular/material/menu';
import { MatStepperModule } from '@angular/material/stepper';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatBadgeModule } from '@angular/material/badge';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { VallejoPickerComponent } from './components/page/vallejo-picker/vallejo-picker.component';
import { VallejoPickerCanvasComponent } from './components/presentational/vallejo-picker-canvas/vallejo-picker-canvas.component';
import { ImageFileInputComponent } from './components/presentational/image-file-input/image-file-input.component';
import { VallejoTableComponent } from './components/container/vallejo-table/vallejo-table.component';
import { PageContainerComponent } from './components/page/page-container/page-container.component';

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
    MatAutocompleteModule,
    MatBadgeModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatSelectModule,
    MatChipsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    MatTableModule,
    MatSnackBarModule,
    MatCheckboxModule,
    MatDialogModule,
    MatGridListModule,
    MatSlideToggleModule,
    MatButtonToggleModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatStepperModule,
    MatTabsModule,
    MatTooltipModule,
    MatMenuModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
