import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { RidergetOrder } from '../../dto/RiderDto/riderget-order';
import { Observable } from 'rxjs';

export const MAIN_URL= "http://localhost:8080";
const URL= "/api/v1/riderGetOrders";
@Injectable()
export class RiderGetOrdersService {

  constructor(private http : HttpClient , private router : Router) { }

  SaveGetRiderOrder(ridergetOrder: RidergetOrder): Observable<boolean>{
    console.log("service riderOnlinedto save :"+ ridergetOrder);
    return this.http.post<boolean>(MAIN_URL + URL,ridergetOrder);
  }

  getRiderOrders(): Observable<Array<RidergetOrder>>{
    return this.http.get<Array<RidergetOrder>>(MAIN_URL + URL);
  }

  deleteOnileRiders(oderID: number): Observable<boolean>{
    console.log(" delete service "+oderID)
    return this.http.delete<boolean>(MAIN_URL+ URL + "/" + oderID);
  }

  



}
