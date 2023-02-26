import {Injectable} from "@angular/core";
import {PaintApi} from "../api/paint-api";
import {ColorCode, Paint, PaintID, PaintName} from "../models/paint";
import {map, Observable} from "rxjs";
import {RGB} from "../shared/rgb";

export type NearestPaints = {
  name: string,
  colorCode: string,
  difference: number,
}[]

@Injectable({
  providedIn: 'root'
})
export class PaintQueryService {


  constructor(
    private paintApi: PaintApi
  ) {
  }

  searchNearestPaints(rgb: RGB): Observable<NearestPaints> {
    return this.paintApi
      .get(rgb.toString())
      .pipe(
        map(response => response
          .results
          .map(item => {
              return {
                name: item.name,
                colorCode: item.colorCode,
                difference: item.colorProximity,
              }
            }
          ))
      );
  }

  list(): Observable<Paint[]> {
    return this.paintApi
      .list()
      .pipe(
        map(response => response
          .results
          .map(paint => new Paint(
            new PaintID(paint.paintID),
            new PaintName(paint.paintName),
            new ColorCode(paint.colorCode),
          ))
        )
      );
  }
}
