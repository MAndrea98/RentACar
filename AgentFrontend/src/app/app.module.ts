import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ListAdsComponent} from "./main-page/list-ads/list-ads.component";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import { NavBarComponent } from './main-page/nav-bar/nav-bar.component';
import { DefNavBarComponent } from './main-page/def-nav-bar/def-nav-bar.component';
import { NewAdComponent } from './main-page/new-ad/new-ad.component';
import { NewMessageComponent } from './main-page/new-message/new-message.component';
import { InboxComponent } from './main-page/inbox/inbox.component';
import { PricesComponent } from './main-page/prices/prices.component';
import { NewVehicleComponent } from './main-page/new-vehicle/new-vehicle.component';
import { VehicleListComponent } from './main-page/vehicle-list/vehicle-list.component';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    NavBarComponent,
    DefNavBarComponent,
    NewAdComponent,
    NewMessageComponent,
    ListAdsComponent,
    InboxComponent,
    PricesComponent,
    NewVehicleComponent,
    VehicleListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
