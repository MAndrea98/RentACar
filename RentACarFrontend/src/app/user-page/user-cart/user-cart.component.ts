import { OnInit, Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Vehicle } from 'src/app/model/Vehicle';

@Component({
    selector: 'app-user-cart',
    templateUrl: './user-cart.component.html',
    styleUrls: ['./user-cart.component.css']
})

export class UserCartComponent implements OnInit {

    router: String;
    cart: Vehicle[] = [];

    constructor(_router:Router, private http:HttpClient) {
        this.router=_router.url;
    }
    
    ngOnInit(): void {
        this.getCart();
    }

    getCart(): void {
        let url = "http://localhost:8080/api/rezervacija-automobila/cart";
        this.http.get(url).subscribe(
            (res: Vehicle[])=>{
                this.cart = res;
            },
            err=>{
                alert('Something went wrong');
                console.log(err.message);
            }
        )
    }

    sendRequest(id: number): void {
        let url = "http://localhost:8080/api/rezervacija-automobila/reservation/createSingle";
        this.http.post(url, id, { responseType: 'text' }).subscribe(
            (res: string)=>{
                alert(res);
                this.getCart();
            },
            err=>{
              alert('Something went wrong');
              console.log(err);
            }
          )
    }

    sendBundle(): void {

    }
    
}