import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { RiderOnlinedto } from '../../dto/RiderDto/rider-onlinedto';
import { Observable } from 'rxjs';

export const MAIN_URL= "http://localhost:8080";
const URL= "/api/v1/OnlineRiders";
@Injectable()
export class OnlineRidersService {

  constructor(private http: HttpClient,private router: Router) { }

  OnlineRiders(riderOnlinedto: RiderOnlinedto): Observable<boolean>{
    console.log("service riderOnlinedto save :"+ riderOnlinedto);
    return this.http.post<boolean>(MAIN_URL + URL,riderOnlinedto);
  }

  getAllOnileRiders(): Observable<Array<RiderOnlinedto>>{
    return this.http.get<Array<RiderOnlinedto>>(MAIN_URL + URL);
  }

  deleteOnileRiders(riderName: string): Observable<boolean>{
    console.log(" delete service "+riderName)
    return this.http.delete<boolean>(MAIN_URL+ URL + "/" + riderName);
  }

  getCountOnlineRiders(): Observable<number>{
    return this.http.get<number>(MAIN_URL + URL + "/count");
  }

}
