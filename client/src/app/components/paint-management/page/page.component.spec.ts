import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaintManagementComponent } from './page.component';

describe('PaintStockComponent', () => {
  let component: PaintManagementComponent;
  let fixture: ComponentFixture<PaintManagementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({})
    .compileComponents();

    fixture = TestBed.createComponent(PaintManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
