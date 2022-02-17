import { Component, OnInit } from '@angular/core';

export interface VallejoColor {
  name: string;
  colorCode: string;
  near: number;
}


@Component({
  selector: 'app-vallejo-table',
  templateUrl: './vallejo-table.component.html',
  styleUrls: ['./vallejo-table.component.sass']
})
export class VallejoTableComponent implements OnInit {

  displayedColumns: string[] = ['name', 'rgb', 'color'];
  
  dataSource!: VallejoColor[];
  
  constructor() { }

  ngOnInit(): void {
  }

  public setVallejoColors(vallejoColors: VallejoColor[]): void {
    
    this.dataSource = vallejoColors;

  }

}
