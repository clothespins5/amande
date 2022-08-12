import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { VallejoColor } from './vallejo-table.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VallejoTableService {

  constructor(
    private http: HttpClient
  ) { }

  public getVallejoColors(selectedColor: string): Observable<VallejoColor[]> {

    const specifiedColorCode = selectedColor.replace(/ /g,"");
    return this.http.get<VallejoColor[]>('http://localhost:8080/vallejoTable?color='+specifiedColorCode+'&limit=10');

  }
}
