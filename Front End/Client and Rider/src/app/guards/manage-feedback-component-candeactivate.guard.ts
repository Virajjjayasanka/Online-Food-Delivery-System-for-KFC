import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate} from '@angular/router';
import { Observable } from 'rxjs';
import {ManageFeedBackComponent} from "../view/client/manage-feed-back/manage-feed-back.component";

@Injectable()
export class ManageFeedbackComponentCandeactivateGuard implements CanDeactivate<ManageFeedBackComponent> {
  canDeactivate(component: ManageFeedBackComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    
    if (component.frmFeedBack.dirty){
     return confirm("Are you sure you want to discard your changes?");

    }
    return true;
  }
}
