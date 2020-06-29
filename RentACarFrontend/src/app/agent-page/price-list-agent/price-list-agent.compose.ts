import { OnInit, Component } from '@angular/core';
import { PriceList } from '../../model/PriceList';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

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

    constructor(_router:Router, private http:HttpClient) {
        this.router=_router.url;
      }

    ngOnInit(): void {
        this.getPriceList();
    }
    
    getPriceList():void {
      let url = "http://localhost:8080/api/izmena-oglasa/priceList";
      this.http.get(url).subscribe(
      res=>{
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

    editPriceList(id):void {
      
    }

    deletePriceList(id):void {

    }
}