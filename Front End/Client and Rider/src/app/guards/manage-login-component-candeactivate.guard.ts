import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate, Router} from '@angular/router';
import { Observable } from 'rxjs';
import { ClientCustomerService } from '../searvice/client-customer.service';
import { ClientLoginService } from '../searvice/client-login.service';


@Injectable()
export class ManageLoginComponentCandeactivateGuard implements CanActivate {

  constructor(private authService: ClientLoginService,
              private router: Router){

  }


  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    if (!this.authService.isAuthenticated()){
      this.router.navigate(['/login']);
      return false;
    }

    return true;

  }

}

