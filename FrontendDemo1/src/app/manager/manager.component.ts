import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';


@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent {
  employee:Employee = new Employee();

  EmployeeArray : any[] = [];

  name: string = "";
  dob: string = "";
  email: string = "";
  department: string = "";
  designation: string = "";
  reportingManager = "";

  constructor(private http: HttpClient,private employeeService: EmployeeService) {
    // this.getAllEmployee();
    this.getData();
  }

  // getAllEmployee(){

  //   this.http.get("http://localhost:8090/api/v1/employee/").subscribe((resultData: any)=>{
  //     console.log(resultData);
  //     this.EmployeeArray = resultData;
  //   });
  // }

  getData(){
    const id = localStorage.getItem('user_id')!;
    console.log(id);
    if(id === null) return;
    this.employeeService.getByUserId(parseInt(id)).subscribe(
      data=>{
        if(data!=null){
          this.employee=data;
          this.http.get("http://localhost:8090/api/v1/manager/reportee/"+`${this.employee.name}`).subscribe((resultData: any)=>{
          console.log(resultData);
          this.EmployeeArray = resultData;
        });       
          console.log(data);
        }
      }
    )
  }
}
