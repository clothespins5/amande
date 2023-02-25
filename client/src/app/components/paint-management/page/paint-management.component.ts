import {Component} from '@angular/core';

@Component({
  selector: 'app-paint-management',
  template: `
    <app-page-container>
      <app-paint-management-table></app-paint-management-table>
    </app-page-container>
  `,
})
export class PaintManagementComponent {

  constructor() { }

}
