import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import{FormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {GasType} from "../../model/GasType";
import {Observable} from "rxjs";

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
    console.log(localStorage.getItem("gasID"));
    if(localStorage.getItem("gasID") !== null){
      let url = "http://localhost:8087/admin/gasType/"+localStorage.getItem("gasID");
      console.log(url);
      this.http.get(url).subscribe(
        res=>{this.gasTypeModel = res as GasType;},
        err => {alert("Something went wrong"); console.log(err.message);}
      )
    }

  }

  sendGasType():void{
    console.log("Sent");
    console.log(this.gasTypeModel.name);
    //let url = "http://localhost:8080/api/administrator/admin/gasType";
    let url = "http://localhost:8087/admin/gasType";

    if(localStorage.getItem("gasID") != null){
      this.gasTypeModel.id = Number(localStorage.getItem("gasID"));
      if(this.gasTypeModel.id == 0)
        return;
      console.log(this.gasTypeModel);
      this.http.put(url, this.gasTypeModel,{responseType:'text'}).subscribe(
        res=>{alert("Gas Type changed"); localStorage.removeItem('gasID'); location.reload();},
        err=>{alert("Something went wrong"); console.log(err.message);}
      )
    }else {

      this.http.post(url, this.gasTypeModel, {responseType: 'text'}).subscribe(
        res => {
          alert("Gas Type added");
          location.reload();
        },
        err => {
          alert("Something went wrong");
          console.log(err.message);
        }
      )
    }
  }



}
