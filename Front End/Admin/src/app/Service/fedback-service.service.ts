import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FeedbackDto } from '../Dto/feedback-dto';
import { HttpClient } from '@angular/common/http';

export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/feedBacks";
@Injectable()
export class FedbackServiceService {

  constructor(private http: HttpClient) { }


  findByEmailAddress(gmail: string): Observable<Array<FeedbackDto>>{
    return this.http.get<Array<FeedbackDto>>(MAIN_URL+ URL + "/" + gmail);
  }
  

}
