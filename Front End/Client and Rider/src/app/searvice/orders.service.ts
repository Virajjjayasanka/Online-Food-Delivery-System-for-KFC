import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { OrderDto } from '../dto/order-dto';
import { Observable } from 'rxjs';
import { OrderDetailDto } from '../dto/order-detail-dto';


export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/Orders";
@Injectable()
export class OrdersService {

  constructor(private  http: HttpClient) { }

  saveOrder(order: OrderDto): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL,order);
  }

  getCustomerorder(id: number): Observable<Array<OrderDto>>{
    console.log("service ordeer "+id)
    return this.http.get<Array<OrderDto>>(MAIN_URL+ URL + "/" + id);
  }

  getSelectItemCustomerOrder(customerEmail: string, oderID: number): Observable<Array<OrderDetailDto>>{
    console.log("service ordeer two :"+customerEmail);
    console.log("service ordeer two :"+oderID);
    return this.http.get<Array<OrderDetailDto>>(MAIN_URL+ URL + "/selectCustomerOrder", {params: new HttpParams().append('customerEmail', customerEmail).append('oderIDss' ,""+ oderID)});
  }

  getAllOrders(): Observable<Array<OrderDto>>{
    return this.http.get<Array<OrderDto>>(MAIN_URL + URL);
  }

  DeleteSelectItems(oderID: number): Observable<boolean>{
    console.log("service Delete"+oderID)
    return this.http.delete<boolean>(MAIN_URL+ URL + "/" + oderID);
  }
  UpdateOrder(orderDto : OrderDto ): Observable<boolean> {
    return this.http.patch<boolean>(MAIN_URL + URL + '/update', orderDto);
  }

  

}
