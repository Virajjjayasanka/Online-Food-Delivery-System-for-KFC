import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {MainDashBoardComponent} from "../view/client/main-dash-board/main-dash-board.component";
import {ManageCustomerComponent} from "../view/client/manage-customer/manage-customer.component";
import {ManageOrderMenuComponent} from "../view/client/manage-order-menu/manage-order-menu.component";
import {ManageMainDashBoardComponent} from "../view/client/manage-main-dash-board/manage-main-dash-board.component";
import {ManageOrderMenuComponentCandeactivateGuard} from "../guards/manage-order-menu-component-candeactivate.guard";
import {ManageOrderDetailsComponent} from "../view/client/manage-order-details/manage-order-details.component";
import {ManageOrderDitalsComponentCandeactivateGuard} from "../guards/manage-order-ditals-component-candeactivate.guard";
import {ManageFeedbackComponentCandeactivateGuard} from "../guards/manage-feedback-component-candeactivate.guard";
import {ManageFeedBackComponent} from "../view/client/manage-feed-back/manage-feed-back.component";
import {ManageLoginComponentCandeactivateGuard} from "../guards/manage-login-component-candeactivate.guard";
import {LoginComponent} from "../view/login/login.component";
import {ReactiveFormsModule} from "@angular/forms";
import { ManageCustomerComponentCandeactivateGuard } from '../guards/manage-customer-component-candeactivate.guard';
import {MangeOrderChickenComponent} from "../view/client/manage-order-menu/mange-order-chicken/mange-order-chicken.component";
import {MenuChickenComponentCandeactivateGuard} from "../guards/menu-chicken-component-candeactivate.guard";
import {MenuRiceComponentCandeactivateGuard} from "../guards/menu-rice-component-candeactivate.guard";
import {ManageOrderRiceComponent} from "../view/client/manage-order-menu/manage-order-rice/manage-order-rice.component";
import {MangeOrderBeveragesComponent} from "../view/client/manage-order-menu/mange-order-beverages/mange-order-beverages.component";
import {MenuBeveragesComponentCandeactivateGuard} from "../guards/menu-beverages-component-candeactivate.guard";
import { MangeMainDashBoardTwoComponent } from '../view/client/manage-main-dash-board/mange-main-dash-board-two/mange-main-dash-board-two.component';
import { PandingOrderDetailComponent } from '../view/client/panding-order-detail/panding-order-detail.component';


const appRoutes: Routes = [

  {
    path: "main-dash-board",
    component: MainDashBoardComponent,
    canActivate: [ManageLoginComponentCandeactivateGuard],
    children: [
      {path: "manage-main-dash-board", component: ManageMainDashBoardComponent},

      {
        path: "manage-main-Dashbord-two",
        component: MangeMainDashBoardTwoComponent,
        // canDeactivate: [ManageCustomerComponentCandeactivateGuard]
      },

      
      {
        path: "manage-customer",
        component: ManageCustomerComponent,
        canDeactivate: [ManageCustomerComponentCandeactivateGuard]
      },
      {
        path: "manage-order-menu",
        component: ManageOrderMenuComponent,
        canDeactivate: [ManageOrderMenuComponentCandeactivateGuard]
      },

      {
        path: "manage-order-details",
        component: ManageOrderDetailsComponent,
        canDeactivate: [ManageOrderDitalsComponentCandeactivateGuard]
      },

      {
        path: "manage-feed-back",
        component: ManageFeedBackComponent,
        canDeactivate: [ManageFeedbackComponentCandeactivateGuard]
      },

      {
        path: "menu-Item-Chicken",
        component: MangeOrderChickenComponent,
        canDeactivate: [MenuChickenComponentCandeactivateGuard]
      },

      {
        path: "menu-Item-Rice",
        component: ManageOrderRiceComponent,
        canDeactivate: [MenuRiceComponentCandeactivateGuard]
      },

      {
        path: "menu-Item-Beverages",
        component: MangeOrderBeveragesComponent,
        canDeactivate: [MenuBeveragesComponentCandeactivateGuard]
      },

      {
        path: "menu-Order-Details",
        component: PandingOrderDetailComponent,
        // canDeactivate: [MenuBeveragesComponentCandeactivateGuard]
      },

      {
        path: "",
        pathMatch : "full",
        redirectTo: "/main-dash-board/manage-main-dash-board"
      }
    ]
  },
   {path: "login", component: LoginComponent},
   {path: "", pathMatch: "full", redirectTo: "/main-dash-board/manage-main-dash-board"}
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

