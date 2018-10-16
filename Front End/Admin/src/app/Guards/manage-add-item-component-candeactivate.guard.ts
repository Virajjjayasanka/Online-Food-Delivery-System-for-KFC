import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate } from '@angular/router';
import { Observable } from 'rxjs';
import { AddItemComponent } from '../View/add-item/add-item.component';

@Injectable()
export class ManageAddItemComponentCandeactivateGuard implements CanDeactivate<AddItemComponent> {
  canDeactivate(component: AddItemComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return true;
  }

}
