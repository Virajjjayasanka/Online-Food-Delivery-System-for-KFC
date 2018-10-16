import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate} from '@angular/router';
import { Observable } from 'rxjs';
import {ManageCustomerComponent} from '../view/client/manage-customer/manage-customer.component';

@Injectable()
export class ManageCustomerComponentCandeactivateGuard implements CanDeactivate<ManageCustomerComponent> {

  canDeactivate(component: ManageCustomerComponent,
     currentRoute: ActivatedRouteSnapshot,
      currentState: RouterStateSnapshot, 
      nextState?: RouterStateSnapshot):
       Observable<boolean> | Promise<boolean> | boolean {
      return true;
  }

}
