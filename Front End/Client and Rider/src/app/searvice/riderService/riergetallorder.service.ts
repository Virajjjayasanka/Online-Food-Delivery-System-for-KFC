import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OrderDto } from '../../dto/order-dto';

export const MAIN_URL= "http://localhost:8080";
const URL= "/api/v1/customerAllOrdrs";
@Injectable()
export class RiergetallorderService {

  constructor(private  http: HttpClient) { }

  getPandingOrder(caption: string): Observable<Array<OrderDto>>{
    console.log("service ordeer dilver "+caption)
    return this.http.get<Array<OrderDto>>(MAIN_URL+ URL + "/" + caption);
  }
}
