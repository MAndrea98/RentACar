import { Ad } from 'src/app/_model/Ad';
import { ReviewDTO } from 'src/app/_model/ReviewDTO';
import { Message } from 'src/app/_model/Message';
import { UserModel } from 'src/app/_model/UserModel';
import { ElementRef, OnInit, ViewChild, Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Request } from 'src/app/_model/Request';

@Component({
    selector: 'app-user-requests',
    templateUrl: './user-requests.component.html',
    styleUrls: ['./user-requests.component.css']
})
export class UserRequestComponent implements OnInit {
    @ViewChild('subject') subject: ElementRef;
    @ViewChild('text') text: ElementRef;
    @ViewChild('stars') stars: ElementRef;
    @ViewChild('contentReview') contentReview: ElementRef;

    router: String;
    requests: Request[] = [];
    hiddenVehicle: Boolean = true;
    ads: Ad[] = [];
    reqID: number = 0;
    adID: number = 0;
    askOwnerHidden: Boolean = true;
    allMessagesHidden: Boolean = true;
    reviewHidden: Boolean = true;
    textMessage: string = "";
    subjectMessage: string = "";
    message: Message = new Message;
    sender: UserModel;
    receiver: UserModel;
    request: Request;
    messages: Message[] = [];
    review: ReviewDTO = null;
    requestID: number = 0;

    constructor(_router:Router, private http:HttpClient) {
        this.router=_router.url;
    }
    
    ngOnInit(): void {
        this.getAllRequest();
    }

    getAllRequest(): void {
        let url = "http://localhost:8081/reservation/endUser";
        this.http.get(url).subscribe(
            (res:Request[])=> {
                this.requests = [];
                this.requests = res;
            },
            err=> {
                alert('Something went wrong');
                console.log(err.message);
            }
        )
    }

    vehicles(req: Request): void {
        this.hiddenVehicle = false;
        this.ads = req.ads;
        this.reqID = req.id;
        this.askOwnerHidden = true;
        this.allMessagesHidden = true;
    }

    askOwner(req: Request): void {
        this.hiddenVehicle = true;
        this.askOwnerHidden = false;
        this.allMessagesHidden = true;
        this.request = req;
    }

    askOwnerSend(): void {
        this.subjectMessage = this.subject.nativeElement.value;
        this.textMessage = this.text.nativeElement.value;
        this.message.subject = this.subjectMessage;
        this.message.content = this.textMessage;
        let url = "http://localhost:8081/user/" + this.request.ads[0].vehicle.owner.idUser;
        this.http.get(url).subscribe(
            (res1:UserModel)=> {
                this.receiver = res1;
                this.message.receiver = this.receiver;
                url = "http://localhost:8081/message/" + this.request.id;
                this.http.post(url, this.message).subscribe(
                    res=> {
                        this.askOwnerHidden = true;
                    },
                    err=>{
                        alert('Something went wrong 3');
                        console.log(err.message);
                    }
                )
            },
            err=>{
                alert('Something went wrong 2');
                console.log(err.message);
            }
        )
            
    }

    allMessages(req: Request): void {
        this.hiddenVehicle = true;
        this.askOwnerHidden = true;
        let url = "http://localhost:8081/message/" + req.id;
        this.http.get(url).subscribe(
            (res:Message[])=> {
                this.messages = [];
                this.messages = res;
                this.allMessagesHidden = false;
            },
            err=>{
                alert('Something went wrong 3');
                console.log(err.message);
            }
        )
    }

    endRenting(req: Request): void {
        let url = "http://localhost:8081/reservation/endRenting";
        this.http.put(url, req).subscribe(
            res=> {
                this.getAllRequest();
            },
            err=>{
                alert('Something went wrong');
                console.log(err.message);
            }
        )
    }

    addComment(req: Request): void {
        this.review = new ReviewDTO;
        this.review.requestID = req.id;
        let url = "http://localhost:8081/user/" + req.ads[0].vehicle.owner.idUser;
        this.http.get(url).subscribe(
            (res1:UserModel)=> {
                this.review.renterUsername = res1.username;
                url = "http://localhost:8081/user/" + req.endUser.idUser;
                this.http.get(url).subscribe(
                    (res2:UserModel)=> {
                        this.review.endUserUsername = res2.username;
                        this.reviewHidden = false;
                    },
                    err=>{
                        alert('Something went wrong 3');
                        console.log(err.message);
                    }
                )
            },
            err=>{
                alert('Something went wrong 2');
                console.log(err.message);
            }
        )
    }

    sendReview(): void {
        this.review.stars = this.stars.nativeElement.value;
        this.review.content = this.contentReview.nativeElement.value;
        let url = "http://localhost:8081/review";
        this.http.post(url, this.review).subscribe(
            res=>{
                this.reviewHidden = true;
                this.getAllRequest();
            },
            err=>{
                alert('Something went wrong');
                console.log(err.message);
            }
        )
    }

}