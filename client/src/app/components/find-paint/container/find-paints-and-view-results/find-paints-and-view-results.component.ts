import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {PaintService} from "../../../../service/paint.service";
import {PaintTableComponent} from "../../presentational/paint-table/paint-table.component";
import {Subscription} from "rxjs";
import {MatButtonModule} from "@angular/material/button";

@Component({
  selector: 'app-find-paints-and-view-results',
  standalone: true,
  imports: [
    MatButtonModule,
    PaintTableComponent
  ],
  template: `
    <div class="searchButtonArea">
      <button
        mat-raised-button
        color="primary"
        (click)="findPaints()"
      >検索</button>
    </div>
    <app-paint-table></app-paint-table>
  `,
  styles: [`
    .searchButtonArea
      margin: 1rem
      text-align: center

      button
        width: 50%
  `]
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
