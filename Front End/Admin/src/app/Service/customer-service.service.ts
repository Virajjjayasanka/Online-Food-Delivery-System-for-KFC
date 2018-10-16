import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CustomerDto } from '../Dto/customer-dto';


export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/customers";
@Injectable()
export class CustomerServiceService {

  constructor(private http: HttpClient,private router: Router) { }

  getAllCustomer(): Observable<Array<CustomerDto>>{
    return this.http.get<Array<CustomerDto>>(MAIN_URL + URL);
  }

  getSearchCustomer(email : string): Observable<Array<CustomerDto>>{
    return this.http.get<Array<CustomerDto>>(MAIN_URL + URL+ "/" + email);
  }
  
  deleteCustomer(id: number): Observable<boolean>{
    console.log(" delete service "+id)
    return this.http.delete<boolean>(MAIN_URL+ URL + "/" + id);
  }
}
