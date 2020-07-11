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
import { UserNavComponent } from './main-page/user-nav/user-nav.component';
import { UserCartComponent } from './main-page/user-cart/user-cart.component';
import { HttpClientModule } from '@angular/common/http';
import { AllRequestsComponent } from './main-page/all-requests/all-requests.component';
import { UserRequestComponent } from './main-page/user-requests/user-requests.component';
import { AdminNavComponent } from './main-page/admin-nav/admin-nav.component';
import { AdminReviewComponent } from './main-page/admin-review/admin-review.component';

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
    VehicleListComponent,
    UserNavComponent,
    UserCartComponent,
    AllRequestsComponent,
    UserRequestComponent,
    AdminNavComponent,
    AdminReviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
