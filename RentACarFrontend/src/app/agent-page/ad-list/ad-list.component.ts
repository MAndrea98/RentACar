import { Component, OnInit } from '@angular/core';
import {DatePickerModule} from '@syncfusion/ej2-angular-calendars';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Ad} from "../../model/Ad";

@Component({
  selector: 'app-ad-list',
  templateUrl: './ad-list.component.html',
  styleUrls: ['./ad-list.component.css']
})
export class AdListComponent implements OnInit {

  ads:Ad[] = [];
  dateFrom:Date;
  dateTo:Date;
  router:String;
  constructor(public _router: Router, private http: HttpClient) {
    this.router = _router.url;
  }

  ngOnInit(): void {
    this.getAds();
  }

  getAds(): void {
     console.log('get');
    let url = "http://localhost:8081/ad/all";
    this.http.get(url).subscribe(
      (res:Ad[])=>{
        let i = 0
        for(let r in res){
          this.ads.push(res[i]);
          i++;
        }
      },
      err=>{
        alert('Something went wrong');
        console.log(err.message);
      }
    )
  }

  addDiscount(adId): void {
    let url = "http://localhost:8081/ad/discount/" + adId;
    this.http.post(url,null,{responseType:'text'}).subscribe(
      res=>{

      },
      err =>{
        
      }
    )
  }

  occupy(adId) {

    let url = "http://localhost:8081/ad/occupy/"+ this.dateFrom + "/" + this.dateTo  + "/" + adId;
    this.http.put(url,null, {responseType:'text'}).subscribe(
      res=>{
        alert('success');
        this.ads = [];
        this.getAds();
      },
      err=>{
        alert('Something went wrong');
        console.log(err.message);
      }
    )

    
  }

}
