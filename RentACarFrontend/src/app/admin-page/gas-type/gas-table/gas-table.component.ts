import { Component, OnInit } from '@angular/core';
import{Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {GasType} from "../../../model/GasType";

@Component({
  selector: 'app-gas-table',
  templateUrl: './gas-table.component.html',
  styleUrls: ['./gas-table.component.css']
})
export class GasTableComponent implements OnInit {

  router: String;
  gtm:GasType={
    name:'',
    id:0
  }

  gasTypeModelList:GasType[] = [];

  constructor(public _router: Router, private http: HttpClient) {
    this.router = _router.url;
  }
  ngOnInit(): void {
    this.getGasTypes();
  }

  getGasTypes():void{
    console.log('get');
   // let url = "http://localhost:8080/api/administrator/admin/gasType";
    let url = "http://localhost:8087/admin/gasType";
    this.http.get(url).subscribe(
      res=>{
        let i = 0
        for(let r in res){

          this.gasTypeModelList.push(res[i]);
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
    // let url = "http://localhost:8080/api/administrator/admin/gasType";
    let url = "http://localhost:8087/admin/gasType/" + id;

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
