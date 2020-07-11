import { Component, OnInit } from '@angular/core';
import {VehicleClass} from "../../../model/VehicleClass";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-vehicle-class-table',
  templateUrl: './vehicle-class-table.component.html',
  styleUrls: ['./vehicle-class-table.component.css']
})
export class VehicleClassTableComponent implements OnInit {

  router: String;
  cl:VehicleClass={
    name:'',
    id:0
  }

  classModelList:VehicleClass[] = [];
  constructor(public _router: Router, private http: HttpClient) {
    this.router = _router.url;
  }

  ngOnInit(): void {
    this.getManufacturer();
  }

  getManufacturer():void{
    console.log('get');

    let url = "http://localhost:8087/admin/vehicleClass";
    this.http.get(url).subscribe(
      res=>{
        let i = 0
        for(let r in res){

          this.classModelList.push(res[i] as VehicleClass);
          i++;
        }


      },
      err=>{
        alert('Something went wrong');
        console.log(err.message);
      }
    )
  }

  deleteRow(id):void{
    let url = "http://localhost:8087/admin/vehicleClass/" + id;

    this.http.delete(url,{responseType:'text'}).subscribe(
      res=>{
        alert("Successfully deleted");
        location.reload();
      },
      err => {
        alert("Something went wrong");
      })


  }

  editRow(id):void{
    localStorage.setItem("vehicleC", id);
    location.href = "adminPage/vehicleClass/add";
  }

}
