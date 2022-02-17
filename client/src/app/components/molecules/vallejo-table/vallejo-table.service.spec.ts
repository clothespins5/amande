import { TestBed } from '@angular/core/testing';

import { VallejoTableService } from './vallejo-table.service';

describe('VallejoTableService', () => {
  let service: VallejoTableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VallejoTableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
