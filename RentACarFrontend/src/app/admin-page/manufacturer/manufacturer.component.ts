import { Component, OnInit } from '@angular/core';
import {Manufacturer} from "../../model/Manufacturer";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-manufacturer',
  templateUrl: './manufacturer.component.html',
  styleUrls: ['./manufacturer.component.css']
})
export class ManufacturerComponent implements OnInit {

  router : String;
  manufacturerModel: Manufacturer ={
    name:'',
    id:0
  };

  constructor(public _router:Router, private http:HttpClient) {
    this.router=_router.url;
  }

  ngOnInit(): void {
  }

  sendManufacturer():void{
    console.log("sent");
    let url = "http://localhost:8087/admin/manufacturer";
    this.http.post(url, this.manufacturerModel, {responseType:'text'}).subscribe(
      res=>{alert("Manufacturer added"); location.reload();},
      err=>{alert("Something went wrong"); console.log(err.message);}
    )
  }

}
