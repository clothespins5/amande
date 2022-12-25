import {Injectable} from '@angular/core';
import {Subject, Subscription} from 'rxjs';
import {PaintApi} from "../api/paint-api";

export class RGB {
  constructor(
    public readonly r: number,
    public readonly g: number,
    public readonly b: number
  ) {
  }

  public toString(): string {
    return 'rgb(' + this.r + ',' + this.g + ',' + this.b + ')'
  }
}

export class Paint {
  constructor(
    public readonly name: string,
    public readonly colorCode: string,
    public readonly colorProximity: number
  ) {
  }
}


@Injectable({
  providedIn: 'root'
})
export class PaintService {

  private _subscriptionToGet?: Subscription;
  private _rgb = new RGB(0, 0, 0);
  private _paints = new Subject<Paint[]>();

  observable = this._paints.asObservable();

  constructor(
    private paintApi: PaintApi
  ) {
  }

  changeRGB(rgb: RGB) {
    this._rgb = rgb;
  }

  fetch(): void {
    if (this._subscriptionToGet !== undefined)
      this._subscriptionToGet.unsubscribe();

    this._subscriptionToGet = this.paintApi
      .get(this._rgb.toString())
      .subscribe((response) => {
        const paints = response.results.map(
          item => new Paint(
            item.name,
            item.colorCode,
            item.colorProximity
          )
        );
        this._paints.next(paints);
      });
  }

  create(): void {
    this.paintApi
      .post(
        {
          colorName: 'aaa',
          colorCode: 'rgb(200, 100, 30)'
        }
      )
      .subscribe();
  }
}


