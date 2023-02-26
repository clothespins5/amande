import {EventEmitter} from "@angular/core";

export type ValueObjectComponent<T> = {
  initialValue: T,
  changed: EventEmitter<T>,
  validate?(): boolean,
}
