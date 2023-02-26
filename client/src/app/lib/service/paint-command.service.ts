import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {PaintApi} from "../api/paint-api";
import {Paint} from "../models/paint";

@Injectable({
  providedIn: 'root'
})
export class PaintCommandService {
  constructor(
    private paintApi: PaintApi
  ) {}

  create(paintName: string, colorCode: string): Observable<void> {
    return this.paintApi.post(
      {
        paintName: paintName,
        colorCode: colorCode
      }
    );
  }

  changeName(paint: Paint): Observable<void> {
    return this.paintApi.changeName(
      {
        id: paint.id.value,
        paintName: paint.paintName.value
      }
    );
  }
}
