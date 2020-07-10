import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserModel} from "../../model/UserModel";
import {UserType} from "../../model/UserType";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(public _router:Router, private http:HttpClient) { }

  um:UserModel ={
    id: 0,
    username: '',
    password:'',
    uloga:UserType.NOT_ACTIVE,
    inbox: null,
    outbox: null,
    permissions: null
  }
  ngOnInit(): void {
  }

  login():void{
    let url = "http://localhost:8087/user/log_in;"
    this.http.post(url, this.um, {responseType:'text'}).subscribe(
      res=>{
        alert("Logged in");
        location.href = "userPage";
        localStorage.setItem("user", this.um.username.toString());

        },
      err=>{ console.log(err.message);
      alert("Something went wrong");}
    )
  }

  signup():void{
    let url = ""
  }

}
