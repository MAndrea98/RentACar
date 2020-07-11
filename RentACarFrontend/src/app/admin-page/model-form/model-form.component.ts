import { Component, OnInit } from '@angular/core';
import {Model} from "../../model/Model";
import {Manufacturer} from "../../model/Manufacturer";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-model-form',
  templateUrl: './model-form.component.html',
  styleUrls: ['./model-form.component.css']
})
export class ModelFormComponent implements OnInit {

  selectedMan:string;

  manufacturerList:Manufacturer[] = [];

  manufacturer:Manufacturer = {
    id: 0,
    name: ''
  }

  model:Model = {
    id: 0,
    name: '',
    manufacturer: {id: 0, name : ''}
  }

  constructor(private http:HttpClient) {

  }


  ngOnInit(): void {
    let url = "http://localhost:8087/admin/manufacturer";

    this.http.get(url).subscribe(
      res=>{
        this.manufacturerList = res as Manufacturer[];
      },
      err=>{alert("Something went wrong"); console.log(err.message);}
    )

  }

  sendModel():void{
    let url = "http://localhost:8087/admin/model";
    let manUrl = "http://localhost:8087/admin/manufacturer/" + this.selectedMan;


    console.log(manUrl);
    this.http.get(manUrl).subscribe(
      res=>{
        this.manufacturer = res as Manufacturer;
        console.log("RES: " + res);
        console.log("MAN: " + JSON.stringify(this.manufacturer));
      }
    )
    console.log("BEFORE "  + JSON.stringify(this.model));
    this.model.manufacturer.name = this.manufacturer.name;
    this.model.manufacturer.id = this.manufacturer.id;
    console.log("AFTER "  + JSON.stringify(this.model));

    if(localStorage.getItem("modelID") != null){

    }else{
     this.http.post(url,this.model, {responseType:'text'}).subscribe(
       res=>{alert("Added model");},
       err=>{alert("Something went wrong"); console.log(err.message);}
     )
    }

  }

}
