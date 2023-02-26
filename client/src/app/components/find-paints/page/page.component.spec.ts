import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindPaintPageComponent } from './page.component';

describe('VallejoPickerComponent', () => {
  let component: FindPaintPageComponent;
  let fixture: ComponentFixture<FindPaintPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindPaintPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FindPaintPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
