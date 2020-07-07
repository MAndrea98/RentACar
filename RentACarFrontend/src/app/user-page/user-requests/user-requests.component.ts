import { OnInit, Component, ElementRef, ViewChild } from '@angular/core';
import { Request } from 'src/app/model/Request';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Ad } from 'src/app/model/Ad';
import { Message } from 'src/app/model/Message';
import { UserModel } from 'src/app/model/UserModel';

@Component({
    selector: 'app-user-requests',
    templateUrl: './user-requests.component.html',
    styleUrls: ['./user-requests.component.css']
})

export class UserRequestComponent implements OnInit {
    @ViewChild('subject') subject: ElementRef;
    @ViewChild('text') text: ElementRef;

    router: String;
    requests: Request[] = [];
    hiddenVehicle: Boolean = true;
    ads: Ad[] = [];
    reqID: number = 0;
    adID: number = 0;
    askOwnerHidden: Boolean = true;
    allMessagesHidden: Boolean = true;
    textMessage: string = "";
    subjectMessage: string = "";
    message: Message = new Message;
    sender: UserModel;
    receiver: UserModel;
    request: Request;
    messages: Message[] = [];

    constructor(_router:Router, private http:HttpClient) {
        this.router=_router.url;
    }
    
    ngOnInit(): void {
        this.getAllRequest();
    }

    getAllRequest(): void {
        let url = "http://localhost:8080/api/rezervacija-automobila/request/endUser";
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
        let url = "http://localhost:8080/api/razmena-poruka/user/" + this.request.ads[0].vehicle.owner.idUser;
        this.http.get(url).subscribe(
            (res1:UserModel)=> {
                this.receiver = res1;
                this.message.receiver = this.receiver;
                url = "http://localhost:8080/api/razmena-poruka/message/" + this.request.id;
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

    allMessages(): void {
        this.hiddenVehicle = true;
        this.askOwnerHidden = true;
        let url = "http://localhost:8080/api/razmena-poruka/message/" + this.request.id;
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

}