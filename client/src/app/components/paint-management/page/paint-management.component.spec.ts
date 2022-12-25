import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaintManagementComponent } from './paint-management.component';

describe('PaintStockComponent', () => {
  let component: PaintManagementComponent;
  let fixture: ComponentFixture<PaintManagementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaintManagementComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaintManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
