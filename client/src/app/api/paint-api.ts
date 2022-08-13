import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export type GetPaintResponseItem = {
  id: string,
  name: string,
  colorCode: string,
  colorProximity: number,
}

export type GetPaintResponse = {
  paints: GetPaintResponseItem[]
}

@Injectable({
  providedIn: 'root'
})
export class PaintApi {
  constructor(
    private http: HttpClient
  ) {}

  public get(rgb: string): Observable<GetPaintResponse> {
    return this.http.get<GetPaintResponse>('http://localhost:8080/vallejoTable?color='+rgb+'&limit=10');
  }
}
