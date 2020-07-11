import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbDropdown} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DefaultNavComponent } from './default-nav/default-nav.component';

import { UserNavComponent } from './user-nav/user-nav.component';
import { UserPageComponent } from './user-page/user-page.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { DefaultPageComponent } from './default-page/default-page.component';

import {Router, Routes} from "@angular/router";
import {AdminNavComponent} from "./admin-nav/admin-nav.component";
import { TestCompComponent } from './test-comp/test-comp.component';

import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { GasTypeComponent } from './admin-page/gas-type/gas-type.component';
import { ManufacturerComponent } from './admin-page/manufacturer/manufacturer.component';
import { ModelFormComponent } from './admin-page/model-form/model-form.component';
import { VehicleClassFormComponent } from './admin-page/vehicle-class-form/vehicle-class-form.component';
import { VehicleFormComponent } from './admin-page/vehicle-form/vehicle-form.component';
import { UserTableComponent } from './admin-page/user-table/user-table.component';
import { GasTableComponent } from './admin-page/gas-type/gas-table/gas-table.component';
import { ModelTableComponent } from './admin-page/model-form/model-table/model-table.component';
import { ManufacturerTableComponent } from './admin-page/manufacturer/manufacturer-table/manufacturer-table.component';
import { VehicleClassTableComponent } from './admin-page/vehicle-class-form/vehicle-class-table/vehicle-class-table.component';
import { NewAdFormComponent } from './user-page/new-ad-form/new-ad-form.component';
import { NewVehicleFormComponent } from './user-page/new-vehicle-form/new-vehicle-form.component';
import { VehicleTableComponent } from './user-page/vehicle-table/vehicle-table.component';
import { AdTableComponent } from './user-page/ad-table/ad-table.component';
import { ReviewListComponent } from './admin-page/review-list/review-list.component';
import { AgentPageComponent } from './agent-page/agent-page.component';
import { AgentNavComponent } from './agent-nav/agent-nav.component';
import { ReviewListAgentComponent } from './agent-page/review-list-agent/review-list-agent.component';
import { UserReviewFormComponent } from './user-page/user-review-form/user-review-form.component';
import { PriceListAgentComponent } from './agent-page/price-list-agent/price-list-agent.compose';
import { UserCartComponent } from './user-page/user-cart/user-cart.component';
import { RequestListAgentComponent } from './agent-page/request-list-agent/request-list-agent.component';
import { UserRequestComponent } from './user-page/user-requests/user-requests.component';
import { UserMessagesComponent } from './user-page/user-messages/user-messages.component';
import { AgentRegisterComponent } from './agent-register/agent-register.component';
import { CompanyRegisterComponent } from './company-register/company-register.component';


const appRoutes : Routes = [];

@NgModule({
  declarations: [
    AppComponent,
    DefaultNavComponent,
    UserNavComponent,
    UserPageComponent,
    AdminPageComponent,
    DefaultPageComponent,
    AdminNavComponent,
    TestCompComponent,
    GasTypeComponent,
    ManufacturerComponent,
    ModelFormComponent,
    VehicleClassFormComponent,
    VehicleFormComponent,
    UserTableComponent,
    GasTableComponent,
    ModelTableComponent,
    ManufacturerTableComponent,
    VehicleClassTableComponent,
    NewAdFormComponent,
    NewVehicleFormComponent,
    VehicleTableComponent,
    AdTableComponent,
    ReviewListComponent,
    RequestListAgentComponent,
    AgentPageComponent,
    AgentNavComponent,
    ReviewListAgentComponent,
    UserReviewFormComponent,
    PriceListAgentComponent,
    UserCartComponent,
    UserRequestComponent,
    UserMessagesComponent,
    AgentRegisterComponent,
    CompanyRegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
