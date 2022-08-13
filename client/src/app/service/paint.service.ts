import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {PaintApi} from "../api/paint-api";

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

  private rgb = new RGB(0, 0, 0);
  private paints = new Subject<Paint[]>();
  public observable = this.paints.asObservable();

  constructor(
    private paintApi: PaintApi
  ) {}

  public setRGB(rgb: RGB) {
    this.rgb = rgb;
  }

  public fetch(): void {
    this.paintApi
      .get(this.rgb.toString())
      .subscribe((response) => {
        const paints = response.results.map(
          item => new Paint(
            item.name,
            item.colorCode,
            item.colorProximity
          )
        );
        this.paints.next(paints);
      });
  }
}
