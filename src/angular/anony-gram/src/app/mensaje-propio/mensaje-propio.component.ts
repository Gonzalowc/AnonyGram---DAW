import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mensaje-propio',
  templateUrl: './mensaje-propio.component.html',
  styleUrls: ['./mensaje-propio.component.scss']
})
export class MensajePropioComponent implements OnInit {
  mensaje:string | undefined;
  constructor() { }

  ngOnInit(): void {
  }

}
