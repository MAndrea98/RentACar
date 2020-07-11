import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { Ad } from 'src/app/_model/Ad';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { VehicleImage } from 'src/app/_model/VehicleImage';

@Component({
    selector: 'app-user-cart',
    templateUrl: './user-cart.component.html',
    styleUrls: ['./user-cart.component.css']
})

export class UserCartComponent implements OnInit {
    @ViewChild('ownerID') ownerID: ElementRef;

    router: String;
    cart: Ad[] = [];
    ids: number[] = [];
    bundle: Ad[] = [];
 
    constructor(_router:Router, private http:HttpClient) {
        this.router=_router.url;
    }
    
    ngOnInit(): void {
        this.getCart();
    }

    getCart(): void {
        this.cart = [];
        this.ids = [];
        let url = "http://localhost:8081/cart";
        this.http.get(url).subscribe(
            (res: Ad[])=>{
                this.cart = res;
                for (var i: number = 0; i < this.cart.length; i++) {
                    if (!this.ids.includes(this.cart[i].vehicle.owner.id)) {
                        this.ids.push(this.cart[i].vehicle.owner.id);
                    }
                    for (let j = 0; j < this.cart.length; j++) {
                        url = "http://localhost:8081/images/" + this.cart[j].vehicle.id;
                        this.http.get(url).subscribe(
                            (res1: VehicleImage[]) => {
                                this.cart[j].vehicle.images = [];
                                this.cart[j].vehicle.images = res1;
                            },
                            err=> {
                                alert('Something went wrong 1');
                                console.log(err.message);
                            }
                        )
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
        let url = "http://localhost:8081/vehicle/sendSingleRequest";
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
            if (this.cart[i].vehicle.owner.id == this.ownerID.nativeElement.value) {
                this.bundle.push(this.cart[i]);
            }
        }
        let url = "http://localhost:8081/vehicle/sendBundle";
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
        let url = "http://localhost:8081/cart/" + id;
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