import { Component, OnInit } from '@angular/core';

export interface VallejoColor {
  name: string;
  colorCode: string;
  near: number;
}


@Component({
  selector: 'app-paint-table',
  templateUrl: './paint-table.component.html',
  styleUrls: ['./paint-table.component.sass']
})
export class PaintTableComponent implements OnInit {

  displayedColumns: string[] = ['name', 'rgb', 'color'];

  dataSource!: VallejoColor[];

  constructor() { }

  ngOnInit(): void {
  }

  public setVallejoColors(vallejoColors: VallejoColor[]): void {

    this.dataSource = vallejoColors;

  }

}
