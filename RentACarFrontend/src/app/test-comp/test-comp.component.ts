import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-test-comp',
  templateUrl: './test-comp.component.html',
  styleUrls: ['./test-comp.component.css']
})
export class TestCompComponent implements OnInit {

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {
  }

  sendTest() : void{
    console.log("sent");
    let url = "http://localhost:8080/api/administrator/test/string"
    this.http.get(url, {responseType:'text'}).subscribe(
      res =>{
        console.log("The result is" + res);
      },
      err =>{
        alert(err.message);
      }
    )
  }

}
