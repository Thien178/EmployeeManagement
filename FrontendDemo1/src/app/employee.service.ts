import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from './employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseUrl = 'http://localhost:8090/api/v1/employee'

  constructor(private httpClient:HttpClient) { }
  getByUserId(id:number):Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseUrl}/find-by-id/${id}`);
  }
  getById(id:number):Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseUrl}/${id}`);
  }
  

}
