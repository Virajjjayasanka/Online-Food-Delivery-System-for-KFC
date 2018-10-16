import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ItemDto } from '../dto/item-dto';
import { Observable } from 'rxjs';


export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/Items";

@Injectable()
export class ItemServiceService {

  constructor(private http : HttpClient) { }

  findByGetModel(itemModel: string): Observable<Array<ItemDto>>{
    console.log("Item service :: "+ itemModel);
    return this.http.get<Array<ItemDto>>(MAIN_URL+ URL + "/" + itemModel);
  }

  getCountItem(): Observable<number>{
    return this.http.get<number>(MAIN_URL + URL + "/count");
  }

}
