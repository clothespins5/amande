import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VallejoTableComponent } from './vallejo-table.component';

describe('VallejoTableComponent', () => {
  let component: VallejoTableComponent;
  let fixture: ComponentFixture<VallejoTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VallejoTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VallejoTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
