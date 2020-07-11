import {Component, OnInit} from '@angular/core';
import {UserModel} from "../../model/UserModel";
import {HttpClient} from "@angular/common/http";
import {UserType} from "../../model/UserType";

@Component({
  selector: 'app-user-action-table',
  templateUrl: './user-action-table.component.html',
  styleUrls: ['./user-action-table.component.css']
})
export class UserActionTableComponent implements OnInit {

  userList:UserModel[] = [];
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    let url = "http://localhost:8087/admin/user";
    this.http.get(url).subscribe(
      res=>{
        let i = 0
        for(let r in res){
          let temp:UserModel = res[i] as UserModel;
          if(temp.uloga.toString() === 'REMOVED'){
            i++;
            continue;
          }
          this.userList.push(res[i] as UserModel);
          i++;
        }

      }
    )
  }

  blockUser(id):void{
    let url = "http://localhost:8087/admin/user/" + id;
    this.http.put(url, null, {responseType:'text'}).subscribe(
      res=>{
        alert("User blocked");
        location.reload();
      },
      err=>{
        alert('Something went wrong');
        console.log(err.message);
      }
    )
  }

  removeUser(id):void{
    let url = "http://localhost:8087/admin/user/" + id;
    this.http.delete(url,{responseType:'text'}).subscribe(
      res=>{alert("User deleted");
      location.reload();},
      err=>{alert("Something went wrong"); console.log(err.message);}
    )
  }

}
