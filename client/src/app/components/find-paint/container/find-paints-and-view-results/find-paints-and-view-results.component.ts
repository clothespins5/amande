import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {PaintService} from "../../../../service/paint.service";
import {PaintTableComponent} from "../../presentational/paint-table/paint-table.component";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-find-paints-and-view-results',
  templateUrl: './find-paints-and-view-results.component.html',
  styleUrls: ['./find-paints-and-view-results.component.sass']
})
export class FindPaintsAndViewResultsComponent implements OnInit, OnDestroy {

  private _printSubscription?: Subscription;

  @ViewChild(PaintTableComponent)
  paintTableComponent!: PaintTableComponent;

  constructor(
    private paintService: PaintService
  ) {}

  ngOnInit(): void {
    this._printSubscription = this
      .paintService
      .observable
      .subscribe(paints => this.paintTableComponent.dataSource = paints);
  }

  ngOnDestroy(): void {
    if (this._printSubscription !== undefined)
      this._printSubscription.unsubscribe();
  }

  findPaints(): void {
    this.paintService.fetch();
  }


}
