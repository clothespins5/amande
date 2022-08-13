import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectColorFromImageComponent } from './select-color-from-image.component';

describe('FindColorFromImageComponent', () => {
  let component: SelectColorFromImageComponent;
  let fixture: ComponentFixture<SelectColorFromImageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SelectColorFromImageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelectColorFromImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
