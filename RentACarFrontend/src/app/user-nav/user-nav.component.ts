import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-user-nav',
  templateUrl: './user-nav.component.html',
  styleUrls: ['./user-nav.component.css']
})
export class UserNavComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  logout():void{
    let url = "http://localhost:8087/user/log_out";

    this.http.get(url, {responseType:'text'}).subscribe(
      res=>{
        alert("Logged out");
        localStorage.removeItem("user");
        location.href = "";
      },
      err=>{
        console.log(err.message);
        alert("Something went wrong");
      }
    )
  }
}
