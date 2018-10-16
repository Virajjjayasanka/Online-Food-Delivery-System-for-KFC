import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AddminLogin } from '../Dto/addmin-login';
import { Observable } from 'rxjs';
import { map } from 'rxjs/internal/operators';


export const MAIN_URL= "http://localhost:8080";
const URL= "/api/v1/Adminlogin";
@Injectable()
export class AdminServiceService {

  constructor(private http : HttpClient , private router : Router) { }

  login(addminLogin : AddminLogin): Observable<boolean> {
    console.log(addminLogin.gmail);
    console.log(addminLogin.password);
   return this.http.post<boolean>(MAIN_URL + URL, addminLogin)
     .pipe(
       map((result)=>{
        console.log("aaaaaaaaaaaaaaaaaaaaaa"+result);
         sessionStorage.setItem("token", result + "");
         if (result){
           this.router.navigate(['/main-dash-board/manage-main-dash-board']);
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
