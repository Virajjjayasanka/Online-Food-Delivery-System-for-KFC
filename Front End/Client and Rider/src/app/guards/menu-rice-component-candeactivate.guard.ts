import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate } from '@angular/router';
import { Observable } from 'rxjs';
import { ManageOrderRiceComponent } from '../view/client/manage-order-menu/manage-order-rice/manage-order-rice.component';

@Injectable()
export class MenuRiceComponentCandeactivateGuard implements CanDeactivate<ManageOrderRiceComponent> {
  canDeactivate(component: ManageOrderRiceComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return true;
  }

}
