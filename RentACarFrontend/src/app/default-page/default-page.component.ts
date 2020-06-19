import { Component, OnInit } from '@angular/core';

import {Router} from "@angular/router";

@Component({
  selector: 'app-default-page',
  templateUrl: './default-page.component.html',
  styleUrls: ['./default-page.component.css']
})
export class DefaultPageComponent implements OnInit {

   router : String;
  constructor(public _router : Router) {
    this.router = _router.url;
  }

  ngOnInit(): void {
  }

}
