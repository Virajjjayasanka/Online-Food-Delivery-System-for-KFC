import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate} from '@angular/router';
import { Observable } from 'rxjs';
import {MangeOrderChickenComponent} from "../view/client/manage-order-menu/mange-order-chicken/mange-order-chicken.component";

@Injectable()

export class MenuChickenComponentCandeactivateGuard implements CanDeactivate<MangeOrderChickenComponent> {
  canDeactivate(component: MangeOrderChickenComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return true;
  }
}
