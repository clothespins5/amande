import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaintNameComponent } from './paint-name.component';

describe('PaintNameComponent', () => {
  let component: PaintNameComponent;
  let fixture: ComponentFixture<PaintNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ PaintNameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaintNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
