import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {FeedBack} from "../dto/feed-back";

export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/feedBacks";

@Injectable()
export class FeedBackService {

  constructor(private http: HttpClient) { }

  getAllCustomers(): Observable<Array<FeedBack>>{
    return this.http.get<Array<FeedBack>>(MAIN_URL + URL);
  }

  deleteFeedback(id: number): Observable<boolean>{
    console.log(" delete service "+id)

    return this.http.delete<boolean>(MAIN_URL+ URL + "/" + id);
  }

  findByEmailAddress(gmail: string): Observable<Array<FeedBack>>{
    console.log("service "+gmail)
    return this.http.get<Array<FeedBack>>(MAIN_URL+ URL + "/" + gmail);
  }

  saveFeedBAck(feedBack: FeedBack): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL,feedBack);
  }

  getTotalCustomers(): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + "/count");
  }
}
