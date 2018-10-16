import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

export const MAIN_URL= "http://localhost:8080";
const URL= "/api/v1/Riders";
@Injectable()
export class AllRidersService {

  constructor(private http : HttpClient, private router : Router) { }

  getCountAllRiders(): Observable<number>{
    return this.http.get<number>(MAIN_URL + URL + "/count");
  }

}
