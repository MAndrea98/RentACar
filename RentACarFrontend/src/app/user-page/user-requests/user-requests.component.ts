import { OnInit, Component, ElementRef, ViewChild } from '@angular/core';
import { Request } from 'src/app/model/Request';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Ad } from 'src/app/model/Ad';

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
    askOwnerHidden: Boolean = true;
    textMessage: string = "";
    subjectMessage: string = "";

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
    }

    askOwner(): void {
        this.hiddenVehicle = true;
        this.reqID = 0;
        this.askOwnerHidden = false;
    }

    askOwnerSend(): void {
        this.subjectMessage = this.subject.nativeElement.value;
        this.textMessage = this.text.nativeElement.value;
        alert(this.subjectMessage + " " + this.textMessage);
    }

    allMessages(): void {
        alert('All messages');
        this.hiddenVehicle = true;
        this.askOwnerHidden = true;
    }

}