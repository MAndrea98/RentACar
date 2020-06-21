import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-agent-page',
  templateUrl: './agent-page.component.html',
  styleUrls: ['./agent-page.component.css']
})
export class AgentPageComponent implements OnInit {

  router:String
  constructor(public _router:Router) {
    this.router=_router.url;
  }

  ngOnInit(): void {
  }

}
