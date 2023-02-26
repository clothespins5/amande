import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaintManagementTableComponent } from './table.component';

describe('PaintManagementTableComponent', () => {
  let component: PaintManagementTableComponent;
  let fixture: ComponentFixture<PaintManagementTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaintManagementTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaintManagementTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
