import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindPaintsAndViewResultsComponent } from './find-paints-and-view-results.component';

describe('FindPaintsAndViewResultsComponent', () => {
  let component: FindPaintsAndViewResultsComponent;
  let fixture: ComponentFixture<FindPaintsAndViewResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindPaintsAndViewResultsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindPaintsAndViewResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
