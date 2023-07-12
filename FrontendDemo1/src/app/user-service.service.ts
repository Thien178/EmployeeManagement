import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  baseUrl='http://localhost:8090/api/v1/user'
  constructor(private http :HttpClient) { }
  checkLogin(user:User):Observable<any>{
    return this.http.post(`${this.baseUrl}/login`,user);
  }
}
