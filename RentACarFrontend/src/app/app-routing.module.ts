import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminPageComponent} from "./admin-page/admin-page.component";
import {UserPageComponent} from "./user-page/user-page.component";
import {DefaultPageComponent} from "./default-page/default-page.component";


const routes: Routes = [{
  path:'adminPage',
  component:AdminPageComponent
},
  {
    path:'userPage',
    component: UserPageComponent
  },
  {
    path:'home',
    component: DefaultPageComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
