import {Component} from '@angular/core';

@Component({
  selector: 'app-find-paint',
  template: `
    <app-page-container>
      <section>
        <app-select-color-from-image></app-select-color-from-image>
        <app-find-paints-and-view-results></app-find-paints-and-view-results>
      </section>
    </app-page-container>
  `,
  styles: [`
    section
      margin: 1rem
  `]
})
export class FindPaintComponent {

  constructor() {}

}
