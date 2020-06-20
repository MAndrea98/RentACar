import { Component, OnInit } from '@angular/core';
import {Manufacturer} from "../../../model/Manufacturer";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-manufacturer-table',
  templateUrl: './manufacturer-table.component.html',
  styleUrls: ['./manufacturer-table.component.css']
})
export class ManufacturerTableComponent implements OnInit {

  router:String;
  manT:Manufacturer = {
    name:'',
    id:0
  };
  manModelList:Manufacturer[] = [];
  constructor(public _router:Router, private http:HttpClient) {
      this.router=_router.url;
  }

  ngOnInit(): void {
    this.getManufacturers();
  }

  getManufacturers():void{
    let url = "http://localhost:8087/admin/manufacturer";
    this.http.get(url).subscribe(
      res=>{
        let i = 0
        for(let r in res){

          this.manModelList.push(res[i]);
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
    let url = "http://localhost:8087/admin/manufacturer/" + id;
    this.http.delete(url,{responseType:'text'}).subscribe(
      res=>{
        alert("Successfully deleted");
        location.reload();
      },
      err => {
        alert("Something went wrong");
      })
  }

}
