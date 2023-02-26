import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export type GetPaintResponse = {
  results: {
    id: string,
    name: string,
    colorCode: string,
    colorProximity: number,
  }[]
}

export type PaintListResponse = {
  results: {
    paintID: string,
    paintName: string,
    colorCode: string
  }[]
}

export type PostPaintRequest = {

  paintName: string,
  colorCode: string
}

export type ChangeNameRequest = {

  id: string,
  paintName: string
}

@Injectable({
  providedIn: 'root'
})
export class PaintApi {
  constructor(
    private http: HttpClient
  ) {}

  public get(rgb: string): Observable<GetPaintResponse> {
    return this.http.get<GetPaintResponse>('http://localhost:8080/paints?rgb='+rgb+'&limit=10');
  }

  public list(): Observable<PaintListResponse> {
    return this.http.get<PaintListResponse>('http://localhost:8080/paints/list');
  }

  public post(request: PostPaintRequest): Observable<void> {
    return this.http.post<void>('http://localhost:8080/paints', request);
  }

  public changeName(request: ChangeNameRequest): Observable<void> {
    return this.http.patch<void>('http://localhost:8080/paints/change-name', request);
  }
}
