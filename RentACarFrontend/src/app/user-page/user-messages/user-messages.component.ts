import { OnInit, Component, ElementRef, ViewChild } from '@angular/core';
import { Message } from 'src/app/model/Message';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'app-user-messages',
    templateUrl: './user-messages.component.html',
    styleUrls: ['./user-messages.component.css']
})

export class UserMessagesComponent implements OnInit {
    
    router: String;
    messages: Message[] = [];

    constructor(_router:Router, private http:HttpClient) {
        this.router=_router.url;
    }
    
    ngOnInit(): void {
        this.getAllMessages();
    }
    
    getAllMessages(): void {
        let url = "http://localhost:8080/api/razmena-poruka/message";
        this.http.get(url).subscribe(
            (res:Message[])=> {
                this.messages = [];
                this.messages = res;
            },
            err=>{
                alert('Something went wrong 3');
                console.log(err.message);
            }
        )
    }
}