import { TestBed } from '@angular/core/testing';

import { VallejoPickerCanvasService } from './vallejo-picker-canvas.service';

describe('VallejoPickerCanvasService', () => {
  let service: VallejoPickerCanvasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VallejoPickerCanvasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
