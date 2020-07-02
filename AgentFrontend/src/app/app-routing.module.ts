import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NavBarComponent} from "./main-page/nav-bar/nav-bar.component";
import {NewAdComponent} from "./main-page/new-ad/new-ad.component";
import {NewMessageComponent} from "./main-page/new-message/new-message.component";
import {ListAdsComponent} from "./main-page/list-ads/list-ads.component";
import {InboxComponent} from "./main-page/inbox/inbox.component";
import {PricesComponent} from "./main-page/prices/prices.component";
import {NewVehicleComponent} from "./main-page/new-vehicle/new-vehicle.component";
import {VehicleListComponent} from "./main-page/vehicle-list/vehicle-list.component";


const routes: Routes = [{
  path:'agent',
  component:NavBarComponent
},
  {
  path:'agent/ad/new',
  component:NewAdComponent
  },
  {
    path:'agent/message/new',
    component:NewMessageComponent
  },
  {
    path:'agent/ad/list',
    component:ListAdsComponent
  },
  {
    path:'agent/inbox',
    component:InboxComponent
  },
  {
    path:'agent/prices',
    component:PricesComponent
  },
  {
    path:'agent/vehicle/new',
    component:NewVehicleComponent
  },
  {
    path:'agent/vehicle/list',
    component:VehicleListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
