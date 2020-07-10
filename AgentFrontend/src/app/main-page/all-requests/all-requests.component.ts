import { Component, OnInit } from '@angular/core';
import { Ad } from 'src/app/_model/Ad';
import { Request } from 'src/app/_model/Request';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-all-requests',
  templateUrl: './all-requests.component.html',
  styleUrls: ['./all-requests.component.css']
})
export class AllRequestsComponent implements OnInit {

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
    let url = "http://localhost:8081/reservation";
    this.http.get(url).subscribe(
        (res: Request[])=>{
          this.requests = [];
          this.requests = res;
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
    let url = "http://localhost:8081/reservation/accept";
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
    let url = "http://localhost:8081/reservation/decline";
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