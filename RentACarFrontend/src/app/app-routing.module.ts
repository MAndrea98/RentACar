import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminPageComponent} from "./admin-page/admin-page.component";
import {UserPageComponent} from "./user-page/user-page.component";
import {DefaultPageComponent} from "./default-page/default-page.component";
import {GasTypeComponent} from "./admin-page/gas-type/gas-type.component";
import {GasTableComponent} from "./admin-page/gas-type/gas-table/gas-table.component";
import {ManufacturerComponent} from "./admin-page/manufacturer/manufacturer.component";
import {ManufacturerTableComponent} from "./admin-page/manufacturer/manufacturer-table/manufacturer-table.component";
import {VehicleClassFormComponent} from "./admin-page/vehicle-class-form/vehicle-class-form.component";
import {VehicleClassTableComponent} from "./admin-page/vehicle-class-form/vehicle-class-table/vehicle-class-table.component";
import {NewAdFormComponent} from "./user-page/new-ad-form/new-ad-form.component";
import {ReviewListComponent} from "./admin-page/review-list/review-list.component";
import {AgentPageComponent} from "./agent-page/agent-page.component";
import {ReviewListAgentComponent} from "./agent-page/review-list-agent/review-list-agent.component";
import { PriceListAgentComponent } from './agent-page/price-list-agent/price-list-agent.compose';
import { UserCartComponent } from './user-page/user-cart/user-cart.component';


const routes: Routes = [
  {
    path:'adminPage',
    component:AdminPageComponent
  },
  {
    path:'userPage',
    component: UserPageComponent
  },
  {
    path:'agentPage',
    component: AgentPageComponent
  },
  {
    path:'home',
    component: DefaultPageComponent
  },
  {
    path:'adminPage/gasType/add',
    component: GasTypeComponent
  },
  {
    path:'adminPage/gasType/list',
    component: GasTableComponent
  },
  {
    path:'adminPage/manufacturer/add',
    component: ManufacturerComponent
  },
  {
    path:'adminPage/manufacturer/list',
    component: ManufacturerTableComponent
  },
  {
    path:'adminPage/vehicleClass/add',
    component: VehicleClassFormComponent
  },
  {
    path:'adminPage/vehicleClass/list',
    component: VehicleClassTableComponent
  },
  {
    path:'userPage/ad/new',
    component: NewAdFormComponent
  },
  {
    path:'adminPage/review/list',
    component: ReviewListComponent
  },
  {
    path:'agentPage/review/list',
    component: ReviewListAgentComponent
  },
  {
    path:'agentPage/priceList/list',
    component: PriceListAgentComponent
  },
  {
    path:'userPage/review/add',
    component: UserPageComponent
  },
  {
    path:'userPage/cart',
    component: UserCartComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
