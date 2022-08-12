import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColorPickerCanvasComponent } from './color-picker-canvas.component';

describe('VallejoPickerCanvasComponent', () => {
  let component: ColorPickerCanvasComponent;
  let fixture: ComponentFixture<ColorPickerCanvasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ColorPickerCanvasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ColorPickerCanvasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
