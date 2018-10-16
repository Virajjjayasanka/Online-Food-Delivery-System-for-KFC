import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate} from '@angular/router';
import { Observable } from 'rxjs';
import {ManageOrderDetailsComponent} from "../view/client/manage-order-details/manage-order-details.component";

@Injectable()
export class ManageOrderDitalsComponentCandeactivateGuard implements CanDeactivate<ManageOrderDetailsComponent> {
  canDeactivate(component: ManageOrderDetailsComponent, 
    currentRoute: ActivatedRouteSnapshot, 
    currentState: RouterStateSnapshot, nextState?:
     RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return true;
  }

}
