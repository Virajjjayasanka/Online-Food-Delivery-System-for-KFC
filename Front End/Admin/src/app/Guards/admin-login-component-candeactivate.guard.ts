import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AdminServiceService } from '../Service/admin-service.service';

@Injectable({
  providedIn: 'root'
})
export class AdminLoginComponentCandeactivateGuard implements CanActivate {
 
  constructor(private AdminloginService: AdminServiceService,
    private router: Router){

}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      if (!this.AdminloginService.isAuthenticated()){
        this.router.navigate(['/login']);
        return true;
     }
  }
}
