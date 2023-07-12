import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {

  EmployeeArray : any[] = [];

  name: string = "";
  dob: string = "";
  email: string = "";
  department: string = "";
  designation: string = "";
  reportingManager:string = "";
  username: string = "";
  password: string = "";
  role: number = 0;

  currentEmployeeID = "";

  constructor(private http: HttpClient) {
    this.getAllEmployee();
  }

  getAllEmployee(){

    this.http.get("http://localhost:8090/api/v1/employee/").subscribe((resultData: any)=>{
      console.log(resultData);
      this.EmployeeArray = resultData;
    });
  }

  register(){
    
    let bodyData = {
      "name" : this.name,
      "dob" : this.dob,
      "email" : this.email,
      "department" : this.department,
      "designation" : this.designation,
      "reportingManager" : this.reportingManager,
      "user" : {
        "name" : this.username,
        "password" : this.password,
        "role" : this.role
      }
    };

    this.http.post("http://localhost:8090/api/v1/employee/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>{
      console.log(resultData);
      alert("Employee Registered Successfully");
      this.getAllEmployee();

      this.name = "";
      this.dob = "";
      this.email = "";
      this.department = "";
      this.designation = "";
      this.reportingManager = "";
      this.username = "";
      this.password = "";
      this.role = 0;
    });
  }

  clearData(){
      this.name = "";
      this.dob = "";
      this.email = "";
      this.department = "";
      this.designation = "";
      this.reportingManager = "";
      this.username = "";
      this.password = "";
      this.role = 0;
  }

  setUpdate(data: any){
    this.name = data.name;
    this.dob = data.dob;
    this.email = data.email;
    this.department = data.department;
    this.designation = data.designation;
    this.reportingManager = data.reportingManager;
    this.currentEmployeeID = data.id;
  }

  UpdateRecords(){
    let bodyData = {
      "id" : this.currentEmployeeID,
      "name" : this.name,
      "dob" : this.dob,
      "email" : this.email,
      "department" : this.department,
      "designation" : this.designation,
      "reportingManager" : this.reportingManager,
      "user" : {
        "name" : this.username,
        "password" : this.password,
        "role" : this.role
      }
    };

    this.http.put("http://localhost:8090/api/v1/employee/update",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>{
      console.log(resultData);
      alert("Employee Registered Updated")
      this.getAllEmployee();
      this.name = "";
      this.dob = "";
      this.email = "";
      this.department = "";
      this.designation = "";
      this.reportingManager = "";
      this.username = "";
      this.password = "";
      this.role = 0;
    });
  }

  save(){
    if(this.currentEmployeeID == ''){
      this.register();
    }else{
      this.UpdateRecords();
    }
  }

  setDelete(data: any){
    this.http.delete("http://localhost:8090/api/v1/employee/delete" + "/" + data.id,{responseType: 'text'}).subscribe((resultData: any)=>{
      console.log(resultData);
      alert("Employee Deleted")
      this.getAllEmployee();

      this.name = "";
      this.dob = "";
      this.email = "";
      this.department = "";
      this.designation = "";
      this.reportingManager = "";
      this.username = "";
      this.password = "";
      this.role = 0;
    });
  }
}
