import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OrderDetailDto } from '../dto/order-detail-dto';

export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/OrderDitals";
@Injectable()
export class OrderDitailsService {

  constructor(private http:HttpClient) { }



  getOrderList(orderDitailDtoID: number): Observable<Array<OrderDetailDto>>{
    console.log("service "+orderDitailDtoID)
    return this.http.get<Array<OrderDetailDto>>(MAIN_URL+ URL + "/" + orderDitailDtoID);
  }
}
