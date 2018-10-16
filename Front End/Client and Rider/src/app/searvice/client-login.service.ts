import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs/index";
import {ClientLogin} from "../dto/client-login";
import {map} from "rxjs/internal/operators";
import {MAIN_URL} from "./client-customer.service";
import { ClientCustomer } from '../dto/client-customer';


const URL= "/api/v1/login";
@Injectable()
export class ClientLoginService {



  constructor(private http: HttpClient, private router: Router) { }



  login(clientCustomer: ClientCustomer): Observable<boolean> {
    console.log(clientCustomer.email);
    console.log(clientCustomer.password);
   return this.http.post<boolean>(MAIN_URL + URL, clientCustomer)
     .pipe(
       map((result)=>{
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

  // login(user: ClientLogin): Observable<boolean> {
  //    // console.log(user.gmail);
  //   // console.log(user.password);
  //   return this.http.post<boolean>(MAIN_URL + URL, user)
  //     .pipe(
  //       map((result)=>{
  //         // console.log(result);
  //         sessionStorage.setItem("token", result + "");
  //         if (result){
  //           this.router.navigate(['/main-dash-board'],{
  //             queryParams:{data:JSON.stringify(user.gmail)}
  //           });
  //         }
  //         return result;

  //       })
  //     )
  // }


  // // GetData(gmail: string): void{
  // //   console.log("aaaaaaaaaaaaaaaaaaaaaaa"+gmail);
  // //   sessionStorage.setItem(gmail);
  // // }
  // // GetData(gmail: string): Observable<Array<ClientLogin>>{
  // //   return this.http.get<Array<ClientLogin>>(MAIN_URL + URL+ "/" + gmail);
  // // }

  // isAuthenticated(): boolean{
  //   if (sessionStorage.getItem("token")){
  //     return sessionStorage.getItem("token") == 'false' ? false: true;
  //   }
  // }


}
