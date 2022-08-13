import {Component, OnInit, ViewChild} from '@angular/core';
import {ColorPickerCanvasComponent} from '../../presentational/color-picker-canvas/color-picker-canvas.component';
import {PaintTableComponent} from '../../presentational/paint-table/paint-table.component';

@Component({
  selector: 'app-find-paint',
  templateUrl: './find-paint.component.html',
  styleUrls: ['./find-paint.component.sass']
})
export class FindPaintComponent implements OnInit {

  @ViewChild(ColorPickerCanvasComponent)
  public vallejoPickerCanvas!: ColorPickerCanvasComponent;

  @ViewChild(PaintTableComponent)
  public vallejoTable!: PaintTableComponent;

  constructor() {}

  ngOnInit(): void {
  }

}
