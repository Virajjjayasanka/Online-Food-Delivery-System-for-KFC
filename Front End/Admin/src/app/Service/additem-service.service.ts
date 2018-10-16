import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AdditemDto } from '../Dto/additem-dto';
import { Observable } from 'rxjs';

export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/Items";
@Injectable()
export class AdditemServiceService {

  constructor(private http: HttpClient,private router: Router) { }

  saveItem(additem: AdditemDto): Observable<boolean>{
    console.log("Service"+additem.itemImage);
    return this.http.post<boolean>(MAIN_URL + URL,additem);
  }

  getAllItem(): Observable<Array<AdditemDto>>{
    return this.http.get<Array<AdditemDto>>(MAIN_URL + URL);
  }


}
