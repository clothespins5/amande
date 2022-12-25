import {Component, OnInit} from '@angular/core';
import {PaintService} from "../../../../service/paint.service";

@Component({
  selector: 'app-paint-management-table',
  templateUrl: './paint-management-table.component.html',
  styleUrls: ['./paint-management-table.component.sass']
})
export class PaintManagementTableComponent implements OnInit {

  constructor(
    private paintService: PaintService
  ) { }

  ngOnInit(): void {
  }

  register() {
    this.paintService.create();
  }
}
