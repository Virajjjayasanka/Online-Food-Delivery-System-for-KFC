import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SelectItem } from '../dto/select-item';

export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/SelectItems";
@Injectable()
export class SelectItemService {

  constructor(private http:HttpClient) { }



  saveSelectItem(selectItem: SelectItem): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL,selectItem);
  }

  getSelectItem(gmail: string): Observable<Array<SelectItem>>{
    console.log("service "+gmail)
    return this.http.get<Array<SelectItem>>(MAIN_URL+ URL + "/" + gmail);
  }
  
  getSelectItemGmail(gmail: string, item: string): Observable<Array<SelectItem>>{
    console.log("service Select :"+gmail);
    console.log("service  Select :"+item);
    return this.http.get<Array<SelectItem>>(MAIN_URL+ URL + "/selectedItemModelCustomer", {params: new HttpParams().append('customerGmail', gmail).append('itemModel', item)});
  }

  deleteItem(selectItemID: number): Observable<boolean>{
    console.log(" delete service "+selectItemID)
    return this.http.delete<boolean>(MAIN_URL+ URL + "/" + selectItemID);
  }

  DeleteSelectItems(id: string): Observable<boolean>{
    console.log("service Delete"+id)
    return this.http.delete<boolean>(MAIN_URL+ URL + "/" + id);
  }

  UpdateSelectItem(selectItem : SelectItem ): Observable<boolean> {
    return this.http.patch<boolean>(MAIN_URL + URL + '/update', selectItem);
  }

}
