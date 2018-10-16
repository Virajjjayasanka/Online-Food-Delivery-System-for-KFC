import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate} from '@angular/router';
import { Observable } from 'rxjs';
import {ManageOrderDetailsComponent} from "../view/client/manage-order-details/manage-order-details.component";
import {ManageOrderMenuComponent} from "../view/client/manage-order-menu/manage-order-menu.component";

@Injectable()
export class ManageOrderMenuComponentCandeactivateGuard implements CanDeactivate<ManageOrderMenuComponent> {
  canDeactivate(component: ManageOrderMenuComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return true;
  }


}
