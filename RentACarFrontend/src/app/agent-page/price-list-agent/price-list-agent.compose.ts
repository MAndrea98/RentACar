import { OnInit, Component, ViewChild, ElementRef } from '@angular/core';
import { PriceList } from '../../model/PriceList';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Vehicle } from 'src/app/model/Vehicle';
import { parse, isThisISOWeek } from 'date-fns';

@Component({
    selector: 'app-price-list-agent',
    templateUrl: './price-list-agent.component.html',
    styleUrls: ['./price-list-agent.component.css']
})
export class PriceListAgentComponent implements OnInit {
    @ViewChild('fromDateInput') fromDateInput: ElementRef;
    @ViewChild('toDateInput') toDateInput: ElementRef;
    @ViewChild('pricePerMileInput') pricePerMileInput: ElementRef;
    @ViewChild('priceCDWInput') priceCDWInput: ElementRef;
    @ViewChild('itemInput') itemInput: ElementRef;
    @ViewChild('valueInput') valueInput: ElementRef;
    @ViewChild('editPriceId') editPriceId: ElementRef;
    @ViewChild('editPricePerMileInput') editPricePerMileInput: ElementRef;
    @ViewChild('editPriceCDWInput') editPriceCDWInput: ElementRef;
    @ViewChild('editFromDateInput') editFromDateInput: ElementRef;
    @ViewChild('editToDateInput') editToDateInput: ElementRef;
    @ViewChild('editOldItemInput') editOldItemInput: ElementRef;
    @ViewChild('editItemInput') editItemInput: ElementRef;
    @ViewChild('editValueInput') editValueInput: ElementRef;

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
    myVehicles: Vehicle[] = [];
    prices: Map<String, number> = new Map;
    vehicles: Vehicle[] = [];
    hiddenPrices: Boolean = true;
    hiddenVehicle: Boolean = true;
    addVehicleToPriceListVisible: Boolean = true;
    addNewPriceListFormVisible:Boolean = true;
    addNewPriceValueVisible: Boolean = true;
    editPriceListFormVisible: Boolean = true;
    editPriceValueVisible: Boolean = true;

    priceListID: number = 0;
    fromDateString: string = "";
    toDateString: string = "";
    returnMap: string[] = [];
 

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
      this.addNewPriceValueVisible = true;
      this.editPriceListFormVisible = true;
      this.editPriceValueVisible = true;
      this.addVehicleToPriceListVisible = true;
      
      this.fromDateInput.nativeElement.value = "";
      this.toDateInput.nativeElement.value = "";
      this.priceCDWInput.nativeElement.value = "";
      this.pricePerMileInput.nativeElement.value = "";
      this.itemInput.nativeElement.value = "";
      this.valueInput.nativeElement.value = "";
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

    getMyVehicles() {
      let url = "http://localhost:8080/api/izmena-oglasa/vehicle/myVehicles";
      this.http.get(url).subscribe(
        (res: Vehicle[]) => {
          this.myVehicles = [];
          this.myVehicles = res;
          this.addVehicleToPriceListVisible = false;
        },
        err=>{
          alert('Something went wrong');
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
      this.fromDateString = this.fromDateInput.nativeElement.value;
      this.toDateString = this.toDateInput.nativeElement.value;
      this.priceList.dateFrom = new Date(this.fromDateString);
      this.priceList.dateTo = new Date(this.toDateString);
      this.priceList.cdwPrice = Number.parseFloat(this.priceCDWInput.nativeElement.value);
      this.priceList.pricePerMile = Number.parseFloat(this.pricePerMileInput.nativeElement.value);
      let url = "http://localhost:8080/api/izmena-oglasa/priceList";
      this.http.post(url, this.priceList).subscribe(
        (res: PriceList)=>{
          this.home();
          this.getPriceList();
        },
        err=>{
          alert('Something went wrong');
        }
      )
    }

    addNewPriceValue(): void {
      this.addNewPriceValueVisible = false;
    }

    addNewPriceValueSend(): void {
      this.returnMap.push(this.itemInput.nativeElement.value);
      this.returnMap.push(this.valueInput.nativeElement.value);
      let url = "http://localhost:8080/api/izmena-oglasa/priceList/addPriceValue/" + this.priceListID;
      this.http.post(url, this.returnMap).subscribe(
        (res: PriceList)=>{
          this.home();
          this.getPriceList();
          this.prices = res.prices;
          this.hiddenPrices = false;
          this.returnMap = [];
        },
        err=>{
          alert('Something went wrong');
        }
      )
    }

    addVehicle(vehicle: Vehicle): void {
      let url = "http://localhost:8080/api/izmena-oglasa/priceList/addVehicleToPriceList/" + this.priceListID;
      this.http.post(url, vehicle).subscribe(
        (res: PriceList)=>{
          this.home();
          this.getPriceList();
          this.vehicles = res.vehicle;
          this.hiddenVehicle = false;
        },
        err=>{
          alert('Something went wrong');
        }
      )
    }
    

    editPriceList(price: PriceList):void {
      this.home();
      this.editPriceListFormVisible = false;
      this.editPriceId.nativeElement.value = price.id;
      this.editToDateInput.nativeElement.value = price.dateTo;
      this.editFromDateInput.nativeElement.value = price.dateFrom;
      this.editPriceCDWInput.nativeElement.value = price.cdwPrice;
      this.editPricePerMileInput.nativeElement.value = price.pricePerMile;
    }

    editPriceListSend(): void {
      this.fromDateString = this.editFromDateInput.nativeElement.value;
      this.toDateString = this.editToDateInput.nativeElement.value;
      this.priceList.dateFrom = new Date(this.fromDateString);
      this.priceList.dateTo = new Date(this.toDateString);
      this.priceList.cdwPrice = Number.parseFloat(this.editPriceCDWInput.nativeElement.value);
      this.priceList.pricePerMile = Number.parseFloat(this.editPricePerMileInput.nativeElement.value);
      this.priceList.id = this.editPriceId.nativeElement.value;
      let url = "http://localhost:8080/api/izmena-oglasa/priceList";
      this.http.put(url, this.priceList).subscribe(
        (res: PriceList)=>{
          this.home();
          this.getPriceList();
        },
        err=>{
          alert('Something went wrong');
        }
      )
    }

    editPriceListValue(key: String, value: number): void {
      this.home();
      this.hiddenPrices = false;
      this.editPriceValueVisible = false;
      this.editOldItemInput.nativeElement.value = key;
      this.editItemInput.nativeElement.value = key;
      this.editValueInput.nativeElement.value = value;
    }

    editPriceListValueSend(): void {
      this.returnMap = [];
      this.returnMap.push(this.editItemInput.nativeElement.value);
      this.returnMap.push(this.editValueInput.nativeElement.value);
      let url = "http://localhost:8080/api/izmena-oglasa/priceList/editPriceValue/" + this.priceListID + "/" + this.editOldItemInput.nativeElement.value;
      this.http.put(url, this.returnMap).subscribe(
        (res: PriceList)=>{
          this.home();
          this.getPriceList();
          this.prices = res.prices;
          this.hiddenPrices = false;
          this.returnMap = [];
        },
        err=>{
          alert('Something went wrong');
        }
      )
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