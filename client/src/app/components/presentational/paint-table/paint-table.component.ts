import { Component, OnInit } from '@angular/core';
import {Paint} from "../../../service/paint.service";

@Component({
  selector: 'app-paint-table',
  templateUrl: './paint-table.component.html',
  styleUrls: ['./paint-table.component.sass']
})
export class PaintTableComponent implements OnInit {

  displayedColumns: string[] = ['name', 'rgb', 'color'];

  dataSource!: Paint[];

  constructor() {}

  ngOnInit(): void {
  }

}
