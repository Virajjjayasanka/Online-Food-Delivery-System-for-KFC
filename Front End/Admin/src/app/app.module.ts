import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MainDashBoardAdminComponent } from './View/main-dash-board-admin/main-dash-board-admin.component';
import { AddItemComponent } from './View/add-item/add-item.component';
import {AdditemServiceService} from './Service/additem-service.service';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing/app-routing.module';
import {ManageAddItemComponentCandeactivateGuard} from './Guards/manage-add-item-component-candeactivate.guard';
import {ManageAdminLoginComponentCandeactivateGuard} from './Guards/manage-admin-login-component-candeactivate.guard';
import {ManageCustomerDetailsComponentCandeactivateGuard} from './Guards/manage-customer-details-component-candeactivate.guard';
import { FileUploadService } from './Service/file-upload.service';
import { CustomerDetailsComponent } from './View/customer-details/customer-details.component';
import { CustomerServiceService } from './Service/customer-service.service';
import {NgxPaginationModule} from 'ngx-pagination';
import { FedbackServiceService } from './Service/fedback-service.service';
import { AdminLoginComponent } from './View/admin-login/admin-login.component';
import { DatePipe } from '@angular/common';
import { CustomerFeedBackComponent } from './View/customer-feed-back/customer-feed-back.component';
import { CustomerFeedbackComponentCandeactivateGuard } from './Guards/customer-feedback-component-candeactivate.guard';
import { ManageMainDashboardComponent } from './View/manage-main-dashboard/manage-main-dashboard.component';
import { AddRidersComponent } from './View/add-riders/add-riders.component';
import { AddRidersService } from './Service/add-riders.service';
import { AdminServiceService } from './Service/admin-service.service';
import { AdminLoginComponentCandeactivateGuard } from './Guards/admin-login-component-candeactivate.guard';

@NgModule({
  declarations: [
    AppComponent,
    MainDashBoardAdminComponent,
    AddItemComponent,
    CustomerDetailsComponent,
    AdminLoginComponent,
    CustomerFeedBackComponent,
    ManageMainDashboardComponent,
    AddRidersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    NgxPaginationModule
  ],
  providers: [
    AdditemServiceService,
    ManageAddItemComponentCandeactivateGuard,
    ManageAdminLoginComponentCandeactivateGuard,
    ManageCustomerDetailsComponentCandeactivateGuard,
    CustomerFeedbackComponentCandeactivateGuard,
    AdminLoginComponentCandeactivateGuard,
    FileUploadService,
    CustomerServiceService,
    FedbackServiceService,
    DatePipe,
    AddRidersService,
    AdminServiceService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
