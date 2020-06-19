import { Component, OnInit } from '@angular/core';

import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  router: String;
  constructor(public _router :Router) {
    this.router = _router.url;
  }

  ngOnInit(): void {
  }

}
