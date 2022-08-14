import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaintStockComponent } from './paint-stock.component';

describe('PaintStockComponent', () => {
  let component: PaintStockComponent;
  let fixture: ComponentFixture<PaintStockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaintStockComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaintStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
