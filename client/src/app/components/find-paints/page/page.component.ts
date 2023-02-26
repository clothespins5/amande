import {Component} from '@angular/core';

@Component({
  selector: 'app-find-paint',
  template: `
    <app-page-container>
      <app-find-paints-container></app-find-paints-container>
    </app-page-container>
  `,
  styles: [`
    section
      margin: 1rem
  `]
})
export class FindPaintPageComponent {

  constructor() {}

}
