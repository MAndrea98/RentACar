import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import{FormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Agent} from "../model/Agent";
import {Company} from "../model/Company";
import {Renter} from "../model/Renter";

@Component({
  selector: 'app-agent-register',
  templateUrl: './agent-register.component.html',
  styleUrls: ['./agent-register.component.css']
})
export class AgentRegisterComponent implements OnInit {

  router : String;
  agent : Agent = {
    id:0,
    address:'',
    name:'',
    surname:'',
    phone:'',
    company: new Company,
    renter: new Renter
  }

  poslovniMaticniBroj : String;

  constructor(public _router: Router, private http: HttpClient) {
    this.router = _router.url;
  }

  ngOnInit(): void {
  }

  agentRegister(): void {
    console.log(this.agent);
    let url = "http://localhost:8081/auth/registerAgent/"+this.poslovniMaticniBroj;
    this.http.post(url,this.agent,).subscribe(
      (res:Agent)=>{
        alert(res.id);
        location.href="http://localhost:4200/agentPage";
        localStorage.setItem("agent",res.id.toString());
      },
      err=>{alert("Something went wrong"); console.log(err.message);}
    )
  }

}
