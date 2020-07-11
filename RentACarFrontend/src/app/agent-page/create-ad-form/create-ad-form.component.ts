import { Component, OnInit } from '@angular/core';
import {DatePickerModule} from '@syncfusion/ej2-angular-calendars';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Ad} from "../../model/Ad";
import {Vehicle} from "../../model/Vehicle";
import {Model} from "../../model/Model";
import { EndUser } from 'src/app/model/EndUser';
import { Cart } from 'src/app/model/Cart';
import { Request } from 'src/app/model/Request';

@Component({
  selector: 'app-create-ad-form',
  templateUrl: './create-ad-form.component.html',
  styleUrls: ['./create-ad-form.component.css']
})
export class CreateAdFormComponent implements OnInit {

  modelName: String;
  models: Model[] =[];
  favoriteFor: EndUser[] = [];
  requests: Request[] = [];
  carts: Cart[] = [];
  ad: Ad = {
    id:0,
    place:'',
    dateTo: new Date(),
    dateFrom: new Date(),
    validTru: new Date(),
    validFrom: new Date(),
    date: new Date(),
    mileageLimit:0,
    vehicle: new Vehicle(),
    favoriteFor: this.favoriteFor,
    requests: this.requests,
    carts: this.carts
  }
  

  router:String;
  constructor(public _router: Router, private http: HttpClient) {
    this.router = _router.url;
  }

  ngOnInit(): void {
    this.getVehicles();
  }

  createAd(): void {
    console.log('create ad');
    let url="http://localhost:8081/ad/create/"+this.modelName
    this.http.post(url,this.ad, {responseType: 'json'}).subscribe(
      res=>{
        alert('success');
        //location.href="http://localhost:4200/agentPage";
      },
      err=>{
        alert('Something went wrong');
        console.log(err.message);
      }
    )
  }

  getVehicles(): void {
    console.log('get');
    let url = "http://localhost:8081/model";
    this.http.get(url).subscribe(
      (res:Model[])=>{
        let i = 0
        for(let r in res){
          this.models.push(res[i]);
          console.log(res);
          i++;
        }
      },
      err=>{
        alert('Something went wrong');
        console.log(err.message);
      }
    )
  }

}
