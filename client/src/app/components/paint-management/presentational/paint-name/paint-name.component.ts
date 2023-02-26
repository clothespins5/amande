import {Component, EventEmitter, Input, OnChanges, OnDestroy, Output} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatInputModule} from "@angular/material/input";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {ValueObjectComponent} from "../../../shared/type/value-object-component";
import {Paint, PaintName} from "../../../../lib/models/paint";
import {Subject} from "rxjs";

@Component({
  selector: 'app-paint-name',
  standalone: true,
  imports: [
    CommonModule,
    MatInputModule,
    ReactiveFormsModule
  ],
  template: `
    <mat-form-field>
      <input
        matInput
        [formControl]="formControl"
        (focusout)="onFocusOut()"
      >
    </mat-form-field>
  `,
})
export class PaintNameComponent implements OnChanges, OnDestroy, ValueObjectComponent<Paint> {

  @Input()
  initialValue!: Paint;
  @Output()
  changed = new EventEmitter<Paint>();

  readonly formControl = new FormControl<string>('', {nonNullable: true});
  private _onDestroy$ = new Subject<boolean>();

  constructor() { }

  onFocusOut() {
    this.changed.emit(
      this.initialValue.changePaintName(new PaintName(this.formControl.value))
    );
  }

  ngOnChanges(): void {
    this.formControl.setValue(this.initialValue.paintName.value);
  }

  ngOnDestroy(): void {
    this._onDestroy$.next(true);
    this._onDestroy$.unsubscribe();
  }

}
