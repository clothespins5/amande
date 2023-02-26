import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaintTableComponent } from './paint-table.component';

describe('VallejoTableComponent', () => {
  let component: PaintTableComponent;
  let fixture: ComponentFixture<PaintTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaintTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaintTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
