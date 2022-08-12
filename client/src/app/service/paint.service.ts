import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export class RGB {
  constructor(
    public readonly r: number,
    public readonly g: number,
    public readonly b: number
  ) {}

  public toString(): string {
    return 'rgb(' + this.r + ',' + this.g + ',' + this.b + ')'
  }
}

export class Paint {
  constructor(
    public readonly name: string,
    public readonly colorCode: string,
    public readonly colorProximity: number
  ) {}
}


@Injectable({
  providedIn: 'root'
})
export class PaintService {

  private rgb: RGB = new RGB(0, 0, 0);

  constructor(
    private http: HttpClient
  ) {}

  public targetColor(rgb: RGB) {
    this.rgb = rgb;
  }

  public fetchPaints(): Observable<Paint[]> {

    return this.http.get<Paint[]>('http://localhost:8080/vallejoTable?color='+this.rgb.toString()+'&limit=10');

  }
}
