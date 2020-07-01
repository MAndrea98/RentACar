import { OnInit, Component } from '@angular/core';
import { PriceList } from '../../model/PriceList';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Vehicle } from 'src/app/model/Vehicle';

@Component({
    selector: 'app-price-list-agent',
    templateUrl: './price-list-agent.component.html',
    styleUrls: ['./price-list-agent.component.css']
})
export class PriceListAgentComponent implements OnInit {

    router: String;
    priceList: PriceList = {
      id: 0,
      vehicle:null,
      dateFrom:null,
      dateTo:null,
      pricePerMile:-1,
      cdwPrice:-1,
      prices:null
    }

    priceListModelList:PriceList[] = [];
    prices: Map<String, number> = new Map;
    vehicles: Vehicle[] = [];
    hiddenPrices: Boolean = true;
    hiddenVehicle: Boolean = true;
    addNewPriceListFormVisible:Boolean = true;
    priceListID: number = 0;
    myDate: Date = new Date;


    constructor(_router:Router, private http:HttpClient) {
      this.router=_router.url;
    }

    ngOnInit(): void {
      this.getPriceList();
    }

    home(): void {
      this.hiddenPrices = true;
      this.hiddenVehicle = true;
      this.addNewPriceListFormVisible = true;
    }
    
    getPriceList():void {
      let url = "http://localhost:8080/api/izmena-oglasa/priceList";
      this.http.get(url).subscribe(
      res=>{
        this.priceListModelList = [];
        let i = 0
        for(let r in res){
          this.priceListModelList.push(res[i]);
          i++;
        }
      },
      err=>{
        alert('Something went wrong');
        console.log(err.message);
      }
    )
    }

    pricesOf(price: PriceList): void {
      this.prices = price.prices;
      this.home();
      this.hiddenPrices = false;
      this.priceListID = price.id;
    }

    vehicleOf(price: PriceList): void {
      this.vehicles = price.vehicle;
      this.home();
      this.hiddenVehicle = false;
      this.priceListID = price.id;
    }

    addNewPriceForm(): void {
      this.home();
      this.addNewPriceListFormVisible = false;
    }

    addNewPrice(): void {
      
    }

    editPriceList(price: PriceList):void {
      
    }

    deletePriceList(id: number):void {
      let url = "http://localhost:8080/api/izmena-oglasa/priceList/" + id;
      this.http.delete(url).subscribe(
        res=>{
          this.getPriceList();
        },
        err=>{
          alert('Something went wrong');
        }
      )
    }

    deletePrice(key: string):void {
      let url = "http://localhost:8080/api/izmena-oglasa/priceList/removePrice/" + this.priceListID + "/" + key;
      this.http.delete(url).subscribe(
        (res: PriceList)=>{
          this.getPriceList();
          this.prices = res.prices;
          this.hiddenPrices = false;
        },
        err=>{
          alert('Something went wrong');
        }
      )
    }

    deleteVehicle(id: number): void {
      let url = "http://localhost:8080/api/izmena-oglasa/priceList/removeVehicle/" + this.priceListID + "/" + id;
      this.http.delete(url).subscribe(
        (res: PriceList)=>{
          this.getPriceList();
          this.vehicles = res.vehicle;
          this.hiddenVehicle = false;
        },
        err=>{
          alert('Something went wrong');
        }
      )
    }
}