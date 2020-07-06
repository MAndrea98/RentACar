import { OnInit, Component, ElementRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Vehicle } from 'src/app/model/Vehicle';

@Component({
    selector: 'app-user-cart',
    templateUrl: './user-cart.component.html',
    styleUrls: ['./user-cart.component.css']
})

export class UserCartComponent implements OnInit {
    @ViewChild('ownerID') ownerID: ElementRef;

    router: String;
    cart: Vehicle[] = [];
    ids: number[] = [];
    bundle: Vehicle[] = [];
 
    constructor(_router:Router, private http:HttpClient) {
        this.router=_router.url;
    }
    
    ngOnInit(): void {
        this.getCart();
    }

    getCart(): void {
        this.cart = [];
        this.ids = [];
        let url = "http://localhost:8080/api/rezervacija-automobila/cart";
        this.http.get(url).subscribe(
            (res: Vehicle[])=>{
                this.cart = res;
                for (var i: number = 0; i < this.cart.length; i++) {
                    if (!this.ids.includes(this.cart[i].owner.id)) {
                        this.ids.push(this.cart[i].owner.id);
                    }
                }
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
        this.bundle = [];
        for (var i: number = 0; i < this.cart.length; i++) {
            if (this.cart[i].owner.id == this.ownerID.nativeElement.value) {
                this.bundle.push(this.cart[i]);
            }
        }
        let url = "http://localhost:8080/api/rezervacija-automobila/reservation/createBundle";
        this.http.post(url, this.bundle, { responseType: 'text' }).subscribe(
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

    removeFromCart(id: number): void {
        let url = "http://localhost:8080/api/rezervacija-automobila/cart/" + id;
        this.http.delete(url).subscribe(
            res=> {
                this.getCart();
            },
            err=> {
                alert('Something went wrong');
                console.log(err);
            }
        )
    }
    
}