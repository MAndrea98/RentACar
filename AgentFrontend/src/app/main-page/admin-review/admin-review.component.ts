import { OnInit, Component } from '@angular/core';
import { ReviewDTO } from 'src/app/_model/ReviewDTO';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
    selector: 'app-admin-review',
    templateUrl: './admin-review.component.html',
    styleUrls: ['./admin-review.component.css']
})

export class AdminReviewComponent implements OnInit {
  
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
      this.getReviews();
    }
  
    getReviews():void{
      let url = "http://localhost:8081/review/allReview";
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
      let url = "http://localhost:8081/review/acceptComment";
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
      let url = "http://localhost:8081/review/declineComment" ;
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
  