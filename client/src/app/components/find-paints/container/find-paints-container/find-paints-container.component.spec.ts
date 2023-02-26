import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindPaintsContainerComponent } from './find-paints-container.component';

describe('FindPaintsContainerComponent', () => {
  let component: FindPaintsContainerComponent;
  let fixture: ComponentFixture<FindPaintsContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ FindPaintsContainerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindPaintsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
