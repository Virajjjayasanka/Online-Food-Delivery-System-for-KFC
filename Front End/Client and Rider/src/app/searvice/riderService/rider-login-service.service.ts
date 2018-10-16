import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { RiderLoginDto } from '../../dto/RiderDto/rider-login-dto';
import { Observable } from 'rxjs';
import { map } from 'rxjs/internal/operators';

export const MAIN_URL= "http://localhost:8080";
const URL= "/api/v1/loginRider";
@Injectable()
export class RiderLoginServiceService {

  constructor(private http: HttpClient, private router: Router) {
  }

  login(riderlogin : RiderLoginDto): Observable<boolean> {
    console.log(riderlogin.username);
    console.log(riderlogin.password);
   return this.http.post<boolean>(MAIN_URL + URL, riderlogin)
     .pipe(
       map((result)=>{
         sessionStorage.setItem("token", result + "");
         if (result){
           this.router.navigate(['/rider-main-dash-board/rider-manage-main-dash-board']);
         }
         return result;
       })
     )
 }

 isAuthenticated(): boolean{
  if (sessionStorage.getItem("token")){
    return sessionStorage.getItem("token") == 'false' ? false: true;
  }
}

logout(): void{
  sessionStorage.removeItem("token");
  this.router.navigate(['/login']);
}

}
