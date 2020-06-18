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

const appRoutes : Routes = [];

@NgModule({
  declarations: [
    AppComponent,
    DefaultNavComponent,
    UserNavComponent,
    UserPageComponent,
    AdminPageComponent,
    DefaultPageComponent,
    AdminNavComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
