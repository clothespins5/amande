import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageFileInputButtonComponent } from './image-file-input-button.component';

describe('ImageFileInputComponent', () => {
  let component: ImageFileInputButtonComponent;
  let fixture: ComponentFixture<ImageFileInputButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImageFileInputButtonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageFileInputButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
