import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindPaintComponent } from './find-paint.component';

describe('VallejoPickerComponent', () => {
  let component: FindPaintComponent;
  let fixture: ComponentFixture<FindPaintComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindPaintComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FindPaintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
