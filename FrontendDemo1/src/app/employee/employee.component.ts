import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent {
  EmployeeArray : any[] = [];

  name: string = "";
  dob: string = "";
  email: string = "";
  department: string = "";
  designation: string = "";
  reportingManager = "";

  constructor(private http: HttpClient) {
    this.getAllEmployee();
  }

  getAllEmployee(){

    this.http.get("http://localhost:8090/api/v1/employee/").subscribe((resultData: any)=>{
      console.log(resultData);
      this.EmployeeArray = resultData;
    });
  }
}
