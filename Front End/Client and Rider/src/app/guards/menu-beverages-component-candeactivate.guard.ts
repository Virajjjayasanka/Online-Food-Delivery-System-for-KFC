import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate} from '@angular/router';
import { Observable } from 'rxjs';
import {MangeOrderBeveragesComponent} from "../view/client/manage-order-menu/mange-order-beverages/mange-order-beverages.component";

@Injectable()
export class MenuBeveragesComponentCandeactivateGuard implements CanDeactivate<MangeOrderBeveragesComponent> {

  canDeactivate(component: MangeOrderBeveragesComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return true;
  }
}
