import {Component, Input, OnInit} from '@angular/core';
import {MatTableModule} from "@angular/material/table";
import {NearestPaints} from "../../../../lib/service/paint-query.service";

@Component({
  selector: 'app-paint-table',
  standalone: true,
  imports: [
    MatTableModule
  ],
  template: `
    <table mat-table [dataSource]="dataSource" class="mat-elevation-z8">
      <ng-container matColumnDef="name">
        <th mat-header-cell *matHeaderCellDef> Name</th>
        <td mat-cell *matCellDef="let element"> {{element.name}} </td>
      </ng-container>
      <ng-container matColumnDef="rgb">
        <th mat-header-cell *matHeaderCellDef> RGB</th>
        <td mat-cell *matCellDef="let element"> {{element.colorCode}} </td>
      </ng-container>
      <ng-container matColumnDef="color">
        <th mat-header-cell *matHeaderCellDef> Color</th>
        <td mat-cell *matCellDef="let element">
          <div class="vallejo-color" [style.background-color]="element.colorCode"></div>
        </td>
      </ng-container>
      <ng-container matColumnDef="diff">
        <th mat-header-cell *matHeaderCellDef> Diff</th>
        <td mat-cell *matCellDef="let element"> {{element.difference}} </td>
      </ng-container>
      <tr mat-header-row *matHeaderRowDef="displayedColumns"></tr>
      <tr mat-row *matRowDef="let row; columns: displayedColumns;"></tr>
    </table>
  `,
  styles: [`
    table
      width: 100%

    .vallejo-color
      width: 1rem
      height: 1rem
      border: solid 0.1rem black
      border-radius: 0.3rem
  `]
})
export class PaintTableComponent implements OnInit {

  @Input()
  dataSource: NearestPaints = [];

  displayedColumns: string[] = ['name', 'rgb', 'color', 'diff'];

  constructor() {}

  ngOnInit(): void {
  }

}
