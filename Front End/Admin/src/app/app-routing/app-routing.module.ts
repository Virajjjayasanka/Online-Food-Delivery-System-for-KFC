import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ReactiveFormsModule} from '@angular/forms';
import {ManageAdminLoginComponentCandeactivateGuard} from "../Guards/manage-admin-login-component-candeactivate.guard";
import {MainDashBoardAdminComponent} from "../View/main-dash-board-admin/main-dash-board-admin.component";
import {AddItemComponent} from "../View/add-item/add-item.component";
import {ManageAddItemComponentCandeactivateGuard} from "../Guards/manage-add-item-component-candeactivate.guard";
import { CustomerDetailsComponent } from '../View/customer-details/customer-details.component';
import { ManageCustomerDetailsComponentCandeactivateGuard } from '../Guards/manage-customer-details-component-candeactivate.guard';
import { AdminLoginComponent } from '../View/admin-login/admin-login.component';
import { CustomerFeedBackComponent } from '../View/customer-feed-back/customer-feed-back.component';
import { CustomerFeedbackComponentCandeactivateGuard } from '../Guards/customer-feedback-component-candeactivate.guard';
import { ManageMainDashboardComponent } from '../View/manage-main-dashboard/manage-main-dashboard.component';
import { AddRidersComponent } from '../View/add-riders/add-riders.component';


const appRoutes: Routes = [
  {
    path: 'main-dash-board',
     component: MainDashBoardAdminComponent,
     canActivate: [ManageAdminLoginComponentCandeactivateGuard],
     children: [
       {path: 'manage-main-dash-board', component: ManageMainDashboardComponent},
     

      {
        path: "manage-AddItem",
        component: AddItemComponent,
        canDeactivate: [ManageAddItemComponentCandeactivateGuard]
      },

      {
        path: "manage-Customer",
        component: CustomerDetailsComponent,
       // canDeactivate: [ManageCustomerDetailsComponentCandeactivateGuard]
      },

      {
        path: "manage-Customer-Feedback",
        component: CustomerFeedBackComponent,
        canDeactivate: [CustomerFeedbackComponentCandeactivateGuard]
      },

      {
        path: "add-Riders",
        component: AddRidersComponent,
        // canDeactivate: [CustomerFeedbackComponentCandeactivateGuard]
      },

      {
        path: "",
        pathMatch : "full",
        redirectTo: "/main-dash-board/manage-main-dash-board"
      }
    ]
  },
  {path: 'login', component: AdminLoginComponent},
 {path: '', pathMatch: 'full', redirectTo: '/main-dash-board/manage-main-dash-board'}
];


@NgModule({
  imports: [
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
