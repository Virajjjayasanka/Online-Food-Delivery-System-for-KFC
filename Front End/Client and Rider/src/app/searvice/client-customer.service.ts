import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ClientCustomer} from "../dto/client-customer";
import {Observable} from "rxjs/index";
import { Router } from '@angular/router';
import { map } from 'rxjs/internal/operators';




export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/customers";

@Injectable()
export class ClientCustomerService {

  constructor(private http: HttpClient,private router: Router) { }

  saveCustomer(clientCustomer: ClientCustomer): Observable<boolean>{
    console.log("service Customer save :"+ clientCustomer);
    return this.http.post<boolean>(MAIN_URL + URL,clientCustomer);
  }

    getCustomer(email: string): Observable<Array<ClientCustomer>>{
    console.log("service Customer:"+ email);
    return this.http.get<Array<ClientCustomer>>(MAIN_URL+ URL + "/" + email);
  }

  getCountTotal(): Observable<number>{
    return this.http.get<number>(MAIN_URL + URL + "/count");
  }





}

