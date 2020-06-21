import { Component, OnInit } from '@angular/core';

import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  router : String;
  constructor(public _router : Router) {
    this.router = _router.url;
  }

  ngOnInit(): void {
  }

}
