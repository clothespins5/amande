import {Component, OnInit, ViewChild} from '@angular/core';
import {PaintService} from "../../../../service/paint.service";
import {PaintTableComponent} from "../../../presentational/paint-table/paint-table.component";

@Component({
  selector: 'app-find-paints-and-view-results',
  templateUrl: './find-paints-and-view-results.component.html',
  styleUrls: ['./find-paints-and-view-results.component.sass']
})
export class FindPaintsAndViewResultsComponent implements OnInit {

  @ViewChild(PaintTableComponent)
  paintTable!: PaintTableComponent;

  constructor(
    private paintService: PaintService
  ) {}

  ngOnInit(): void {
    this.paintService.observable.subscribe(paints => this.paintTable.dataSource = paints);
  }

  findPaints(): void {
    this.paintService.fetch();
  }
}
