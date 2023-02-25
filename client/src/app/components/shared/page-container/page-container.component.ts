import {Component} from '@angular/core';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {RouterModule} from "@angular/router";


@Component({
  selector: 'app-page-container',
  standalone: true,
  imports: [
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    RouterModule
  ],
  template: `
    <mat-toolbar color="primary">
      <button
        mat-icon-button
        class="example-icon"
        aria-label="Example icon-button with menu icon"
        (click)="sidenav.toggle()"
      >
        <mat-icon>menu</mat-icon>
      </button>
      <span>Amande</span>
    </mat-toolbar>
    <mat-sidenav-container>

      <mat-sidenav #sidenav>
        <mat-nav-list>
          <mat-list-item>
            <a routerLink="/find-paint">
              <mat-icon mat-list-icon>search</mat-icon>
              <span class="full-width">塗料を探す</span>
            </a>
          </mat-list-item>
          <mat-list-item>
            <a routerLink="/paint-management">
              <mat-icon mat-list-icon>inventory</mat-icon>
              <span class="full-width">塗料管理</span>
            </a>
          </mat-list-item>
        </mat-nav-list>
      </mat-sidenav>

      <mat-sidenav-content>
        <ng-content></ng-content>
      </mat-sidenav-content>

    </mat-sidenav-container>
  `,
  styles: [`
    mat-list-item a
      display: flex
      align-items: center
  `]
})
export class PageContainerComponent {

  constructor() {}

}
