import { Component, OnInit } from '@angular/core';
import {ReviewDTO} from "../../model/ReviewDTO";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-review-list-agent',
  templateUrl: './review-list-agent.component.html',
  styleUrls: ['./review-list-agent.component.css']
})
export class ReviewListAgentComponent implements OnInit {

  router: String;
  reviewModel:ReviewDTO ={
    id:0,
    endUserUsername:null,
    renterUsername:null,
    stars:0,
    content:null,
    accepted:false,
    deleted:false,
    requestID:0
  }
  reviewModelList:ReviewDTO[] = [];

  constructor(_router:Router, private http:HttpClient) {
    this.router=_router.url;
  }

  ngOnInit(): void {
    this.getReviewsAgent();
  }

  getReviewsAgent():void{
    let url = "http://localhost:8081/review";
    this.http.get(url).subscribe(
      res=>{
        let i = 0
        for(let r in res){

          this.reviewModelList.push(res[i]);
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
