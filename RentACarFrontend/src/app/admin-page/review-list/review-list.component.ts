import { Component, OnInit } from '@angular/core';
import {ReviewDTO} from "../../model/ReviewDTO";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-review-list',
  templateUrl: './review-list.component.html',
  styleUrls: ['./review-list.component.css']
})
export class ReviewListComponent implements OnInit {

  router: String;
  reviewModel:ReviewDTO ={
    id:0,
    endUserUsername:null,
    renterUsername:null,
    stars:0,
    content:null,
    accepted:false,
    deleted:false
  }
  reviewModelList:ReviewDTO[] = [];

  constructor(_router:Router, private http:HttpClient) {
    this.router=_router.url;
  }

  ngOnInit(): void {
    this.getReviews();
  }

  getReviews():void{
    let url = "http://localhost:8087/admin/allReview";
    this.http.get(url).subscribe(
      res=>{
        let i = 0
        for(let r in res) {
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

  acceptComment(id):void{
    let url = "http://localhost:8087/admin/acceptComment/";
    this.reviewModel.id = id;
    this.http.put(url,this.reviewModel,{responseType:'text'}).subscribe(
      res=>{
        location.reload();
      },
      err => {
        alert("Something went wrong");
      })


  }
  declineComment(id):void{
    let url = "http://localhost:8087/admin/declineComment" ;
    this.reviewModel.id = id;
    this.http.put(url,this.reviewModel,{responseType:'text'}).subscribe(
      res=>{
        location.reload();
      },
      err => {
        alert("Something went wrong");
      })

  }
}
