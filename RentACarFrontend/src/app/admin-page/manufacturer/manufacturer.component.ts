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
    if(localStorage.getItem("manID") != null){
      let url = "http://localhost:8087/admin/manufacturer/" + localStorage.getItem("manID");
      this.http.get(url).subscribe(
        res=>{this.manufacturerModel = res as Manufacturer;},
        err=>{alert("Something went wrong"); console.log(err.message);})
    }
  }

  sendManufacturer():void{
    console.log("sent");
    let url = "http://localhost:8087/admin/manufacturer";
    if(localStorage.getItem("manID") != null){
      this.manufacturerModel.id = Number(localStorage.getItem("manID"));
      console.log(localStorage.getItem("manID"));
      console.log(this.manufacturerModel);
      this.http.put(url, this.manufacturerModel,{responseType:'text'}).subscribe(
        res=>{alert("Manufacturer changed"); localStorage.removeItem('manID'); location.reload();},
        err=>{alert('Something went wrong'); console.log(err.message);}
      )
    }else {
      this.http.post(url, this.manufacturerModel, {responseType: 'text'}).subscribe(
        res => {
          alert("Manufacturer added");
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
