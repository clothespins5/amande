import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VallejoPickerCanvasComponent } from './vallejo-picker-canvas.component';

describe('VallejoPickerCanvasComponent', () => {
  let component: VallejoPickerCanvasComponent;
  let fixture: ComponentFixture<VallejoPickerCanvasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VallejoPickerCanvasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VallejoPickerCanvasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
