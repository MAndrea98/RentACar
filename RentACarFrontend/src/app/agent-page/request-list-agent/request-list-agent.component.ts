import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Ad } from 'src/app/model/Ad';
import { Request } from 'src/app/model/Request';
import { VehicleImage } from 'src/app/model/VehicleImage';

@Component({
    selector: 'app-request-list-agent',
    templateUrl: './request-list-agent.component.html',
    styleUrls: ['./request-list-agent.component.css']
})

export class RequestListAgentComponent implements OnInit {

    router: String;
    requests: Request[] = [];
    hiddenVehicle: Boolean = true;
    ads: Ad[] = [];
    reqID: number = 0;

    constructor(_router:Router, private http:HttpClient) {
      this.router=_router.url;
    }

    ngOnInit(): void {
      this.getAllRequest();
    }

    getAllRequest(): void {
      let url = "http://localhost:8080/api/rezervacija-automobila/request";
      this.http.get(url).subscribe(
          (res: Request[])=>{
            this.requests = [];
            this.requests = res;
            for (let i = 0; i < this.requests.length; i++) {
              for (let j = 0; j < this.requests[i].ads.length; j++) {
                  url = "http://localhost:8080/api/rezervacija-automobila/images/" + this.requests[i].ads[j].vehicle.id;
                  this.http.get(url).subscribe(
                      (res1: VehicleImage[]) => {
                          this.requests[i].ads[j].vehicle.images = [];
                          this.requests[i].ads[j].vehicle.images = res1;
                      },
                      err=> {
                          alert('Something went wrong 1');
                          console.log(err.message);
                      }
                  )
              }
            }
          },
          err=>{
            alert('Something went wrong');
            console.log(err.message);
          }
      )
    }

    vehicles(req: Request): void {
      this.hiddenVehicle = false;
      this.ads = req.ads;
      this.reqID = req.id;
    }

    accept(): void {
      let url = "http://localhost:8080/api/rezervacija-automobila/reservation/accept";
      this.http.put(url, this.reqID).subscribe(
          res=>{
            this.hiddenVehicle = true;
            this.getAllRequest();
          },
          err=>{
            alert('Something went wrong');
            console.log(err.message);
          }
      )
      
    }

    deny(): void {
      let url = "http://localhost:8080/api/rezervacija-automobila/reservation/decline";
      this.http.put(url, this.reqID).subscribe(
          res=>{
            this.hiddenVehicle = true;
            this.getAllRequest();
          },
          err=>{
            alert('Something went wrong');
            console.log(err.message);
          }
      )
    }
    
}