import { TestBed } from '@angular/core/testing';

import { ImageFileInputService } from './image-file-input.service';

describe('ImageFileInputService', () => {
  let service: ImageFileInputService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImageFileInputService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
