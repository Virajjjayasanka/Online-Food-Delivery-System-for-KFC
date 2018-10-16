import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { RiderMainDashBoardTwoComponent } from '../../view/rider/rider-main-dash-board-two/rider-main-dash-board-two.component';
import { RiderMainDashBoardComponent } from '../../view/rider/rider-main-dash-board/rider-main-dash-board.component';
import { LoginComponent } from '../../view/login/login.component';




const riderappRoutes: Routes = [

  {
    path: "rider-main-dash-board",
    component: RiderMainDashBoardComponent,
  //  canActivate: [ManageLoginComponentCandeactivateGuard],
    children: [
     {path: "rider-manage-main-dash-board", component:RiderMainDashBoardTwoComponent },

    ]
  },
   {path: "login", component: LoginComponent},
   {path: "", pathMatch: "full", redirectTo: "/rider-main-dash-board/rider-manage-main-dash-board"}
];

@NgModule({
  imports: [
    ReactiveFormsModule,
    RouterModule.forRoot(riderappRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingRiderModule { }
