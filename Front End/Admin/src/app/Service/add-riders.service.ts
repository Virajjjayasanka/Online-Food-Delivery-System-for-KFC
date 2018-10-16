import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AddRiders } from '../Dto/add-riders';
import { Observable } from 'rxjs';

export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/Riders";
@Injectable()
export class AddRidersService {

  constructor(private http: HttpClient,private router: Router) { }

  saveRider(addRider: AddRiders): Observable<boolean>{
    console.log("Service"+addRider.address);
    return this.http.post<boolean>(MAIN_URL + URL,addRider);
  }
}
