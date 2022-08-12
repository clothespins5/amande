import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VallejoPickerComponent } from './vallejo-picker.component';

describe('VallejoPickerComponent', () => {
  let component: VallejoPickerComponent;
  let fixture: ComponentFixture<VallejoPickerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VallejoPickerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VallejoPickerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
