import { Component, OnInit } from '@angular/core';
import {VehicleClass} from "../../model/VehicleClass";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-vehicle-class-form',
  templateUrl: './vehicle-class-form.component.html',
  styleUrls: ['./vehicle-class-form.component.css']
})
export class VehicleClassFormComponent implements OnInit {

  router : String;
  vClassModel : VehicleClass = {
    name:'',
    id:0
  }

  constructor(public _router: Router, private http: HttpClient) {
    this.router = _router.url;
  }

  ngOnInit(): void {
  }

  sendVehicleClass():void{
    console.log("Sent");
    let url = "http://localhost:8087/admin/vehicleClass";
    this.http.post(url, this.vClassModel, {responseType:'text'}).subscribe(
      res=>{alert("VehicleClass added"); location.reload();},
      err=>{alert("Something went wrong"); console.log(err.message);}
    )
  }
}
