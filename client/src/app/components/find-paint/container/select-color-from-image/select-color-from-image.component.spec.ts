import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectColorFromImageComponent } from './select-color-from-image.component';
import {PaintService} from "../../../../service/paint.service";
import createSpyObj = jasmine.createSpyObj;

describe('FindColorFromImageComponent', () => {
  let component: SelectColorFromImageComponent;
  let fixture: ComponentFixture<SelectColorFromImageComponent>;

  beforeEach(async () => {
    let paintService = createSpyObj('PaintService', 'changeRGB');
    await TestBed.configureTestingModule({
      providers: [
        {
          provide: paintService, useValue: PaintService
        }
      ],
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
