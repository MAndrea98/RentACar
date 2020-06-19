import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import{FormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {GasType} from "../../model/GasType";

@Component({
  selector: 'app-gas-type',
  templateUrl: './gas-type.component.html',
  styleUrls: ['./gas-type.component.css']
})
export class GasTypeComponent implements OnInit {

  router : String;
  gasTypeModel : GasType = {
    name:'',
    id:0
  }

  constructor(public _router: Router, private http: HttpClient) {
    this.router = _router.url;
  }


  ngOnInit(): void {
  }

  sendGasType():void{
    console.log("Sent");
    console.log(this.gasTypeModel.name);
    let url = "http://localhost:8080/api/administrator/admin/gasType";
    this.http.post(url, this.gasTypeModel, {responseType:'text'}).subscribe(
      res=>{alert("Gas Type added"); location.reload();},
      err=>{alert("Something went wrong"); console.log(err.message);}
    )
  }

}
