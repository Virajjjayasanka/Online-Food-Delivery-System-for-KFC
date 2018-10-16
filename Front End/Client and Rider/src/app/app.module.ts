import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MainDashBoardComponent } from './view/client/main-dash-board/main-dash-board.component';
import { ManageCustomerComponent } from './view/client/manage-customer/manage-customer.component';
import { ManageOrderMenuComponent } from './view/client/manage-order-menu/manage-order-menu.component';
import { ManageOrderDetailsComponent } from './view/client/manage-order-details/manage-order-details.component';
import { ManageFeedBackComponent } from './view/client/manage-feed-back/manage-feed-back.component';

import {ManageCustomerComponentCandeactivateGuard} from "./guards/manage-customer-component-candeactivate.guard";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

import {ManageOrderMenuComponentCandeactivateGuard} from "./guards/manage-order-menu-component-candeactivate.guard";

import { ManageMainDashBoardComponent } from './view/client/manage-main-dash-board/manage-main-dash-board.component';
import {ManageOrderDitalsComponentCandeactivateGuard} from "./guards/manage-order-ditals-component-candeactivate.guard";
import { MangeMainDashBoardTwoComponent } from './view/client/manage-main-dash-board/mange-main-dash-board-two/mange-main-dash-board-two.component';
import {ManageFeedbackComponentCandeactivateGuard} from "./guards/manage-feedback-component-candeactivate.guard";
import { ManageAdminMainComponent } from './view/admin/manage-admin-main/manage-admin-main.component';
import { ManageAdminDashboardComponent } from './view/admin/manage-admin-dashboard/manage-admin-dashboard.component';
import { ManageAdminItemsComponent } from './view/admin/manage-admin-items/manage-admin-items.component';
import { ManageAdminOrdersComponent } from './view/admin/manage-admin-orders/manage-admin-orders.component';
import { ManageAdminProblamsComponent } from './view/admin/manage-admin-problams/manage-admin-problams.component';
import { LoginComponent } from './view/login/login.component';

import {ManageLoginComponentCandeactivateGuard} from "./guards/manage-login-component-candeactivate.guard";
import {ClientLoginService} from "./searvice/client-login.service";
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {FeedBackService} from "./searvice/feed-back.service";
import {DatePipe} from "@angular/common";
import { ClientCustomerService } from './searvice/client-customer.service';
import { CookieService } from 'ngx-cookie-service';
import {NgxPaginationModule} from "bluestoneapp-ngx-pagination";
import { ItemServiceService } from './searvice/item-service.service';
import { SelectItemService } from './searvice/select-item.service';
import { MangeOrderChickenComponent } from './view/client/manage-order-menu/mange-order-chicken/mange-order-chicken.component';
import { MangeOrderBeveragesComponent } from './view/client/manage-order-menu/mange-order-beverages/mange-order-beverages.component';
import { ManageOrderRiceComponent } from './view/client/manage-order-menu/manage-order-rice/manage-order-rice.component';
import {MenuRiceComponentCandeactivateGuard} from "./guards/menu-rice-component-candeactivate.guard";
import { MenuChickenComponentCandeactivateGuard } from './guards/menu-chicken-component-candeactivate.guard';
import { MenuBeveragesComponentCandeactivateGuard } from './guards/menu-beverages-component-candeactivate.guard';
import { OrderDetailService } from './searvice/order-detail.service';
import { OrdersService } from './searvice/orders.service';
import { CustomerFileUploadService } from './searvice/customer-file-upload.service';
import { OrderDetailsComponent } from './view/client/order-details/order-details.component';
import { PandingOrderDetailComponent } from './view/client/panding-order-detail/panding-order-detail.component';
import { OrderDitailsService } from './searvice/order-ditails.service';
import { AppRoutingRiderModule } from './app-routing/app-routing-rider/app-routing-rider.module';
import { RiderLoginServiceService } from './searvice/riderService/rider-login-service.service';
import { LoginComponentCandeactivateGuard } from './guards/rider-guards/login-component-candeactivate.guard';
import { RiderMainDashBoardComponent } from './view/rider/rider-main-dash-board/rider-main-dash-board.component';
import { RiderMainDashBoardTwoComponent } from './view/rider/rider-main-dash-board-two/rider-main-dash-board-two.component';
import { OnlineRidersService } from './searvice/riderService/online-riders.service';
import { RiderGetOrdersService } from './searvice/riderService/rider-get-orders.service';
import { RiergetallorderService } from './searvice/riderService/riergetallorder.service';
import { SimpleTimer } from 'ng2-simple-timer';
import { AllRidersService } from './searvice/riderService/all-riders.service';







@NgModule({
  declarations: [
    AppComponent,
    MainDashBoardComponent,
    ManageCustomerComponent,
    ManageOrderMenuComponent,
    ManageOrderDetailsComponent,
    ManageFeedBackComponent,
    ManageMainDashBoardComponent,
    MangeMainDashBoardTwoComponent,
    ManageAdminMainComponent,
    ManageAdminDashboardComponent,
    ManageAdminItemsComponent,
    ManageAdminOrdersComponent,
    ManageAdminProblamsComponent,
    LoginComponent,
    MangeOrderChickenComponent,
    MangeOrderBeveragesComponent,
    ManageOrderRiceComponent,
    OrderDetailsComponent,
    PandingOrderDetailComponent,
    RiderMainDashBoardComponent,
    RiderMainDashBoardTwoComponent
    
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    NgxPaginationModule,
    AppRoutingRiderModule
  ],

  providers: [
    ManageCustomerComponentCandeactivateGuard,
    ManageOrderMenuComponentCandeactivateGuard,
    ManageOrderDitalsComponentCandeactivateGuard,
    ManageFeedbackComponentCandeactivateGuard,
    ManageLoginComponentCandeactivateGuard,
    MenuRiceComponentCandeactivateGuard,
    MenuChickenComponentCandeactivateGuard,
    MenuBeveragesComponentCandeactivateGuard,
    LoginComponentCandeactivateGuard,
    ClientLoginService,
    FeedBackService,
    DatePipe,
    ClientCustomerService,
    CookieService,
    ItemServiceService,
    SelectItemService,
    OrderDetailService,
    OrdersService,
    CustomerFileUploadService,
    OrderDitailsService,
    RiderLoginServiceService,
    OnlineRidersService,
    RiderGetOrdersService,
    RiergetallorderService,
    SimpleTimer,
    AllRidersService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
