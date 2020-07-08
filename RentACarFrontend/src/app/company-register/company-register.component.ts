import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Company} from "../model/Company";
import {Agent} from "../model/Agent";
import { Renter } from '../model/Renter';

@Component({
  selector: 'app-company-register',
  templateUrl: './company-register.component.html',
  styleUrls: ['./company-register.component.css']
})
export class CompanyRegisterComponent implements OnInit {

  agents: Agent[] = [];
  company: Company = {
    id: 0,
    agents : this.agents,
    address: '',
    name: '',
    poslovniMaticniBroj: '',
    renter: new Renter()
  }

  router: String;

  constructor(public _router: Router, private http: HttpClient) {
    this.router = _router.url;
  }

  ngOnInit(): void {
  }

  companyRegister(): void {
    console.log(this.company);
    let url = "http://localhost:8081/auth/registerCompany/";
    this.http.post(url,this.company, {responseType:'text'}).subscribe(
      res=>{
        alert(res);
        location.href="http://localhost:4200/agentPage";
      },
      err=>{alert("Something went wrong"); console.log(err.message);}
    )

  }

}
