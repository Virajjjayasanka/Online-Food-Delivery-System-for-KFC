import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/uploadFile";

@Injectable()
export class CustomerFileUploadService {

  constructor(private http: HttpClient) { }

  uploadFile(formData: FormData): Observable<Array<string>> {
    return this.http.post<Array<string>>(MAIN_URL + URL,formData);
  }
}
