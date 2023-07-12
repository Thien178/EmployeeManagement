import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
  employee:Employee = new Employee();

  employeeForm = new FormGroup({
    id : new FormControl(''),
    name : new FormControl(''),
    dob : new FormControl(''),
    email : new FormControl(''),
    department : new FormControl(''),
    designation : new FormControl(''),
    reportingManager : new FormControl('')
  },{validators: Validators.required})

  constructor(private employeeService: EmployeeService){

  }

  ngOnInit(): void {
    this.getData();
  }

  getData(){
    const id = localStorage.getItem('user_id')!;
    console.log(id);
    if(id === null) return;
    this.employeeService.getByUserId(parseInt(id)).subscribe(
      data=>{
        if(data!=null){
          this.employee=data;
          this.employeeForm.value.name=this.employee.name;
          this.employeeForm.value.dob=this.employee.dob;
          this.employeeForm.value.email=this.employee.email;          
          this.employeeForm.value.department=this.employee.department;          
          this.employeeForm.value.designation=this.employee.designation;          
          this.employeeForm.value.reportingManager=this.employee.reportingManager;          
          console.log('profile: '+data);
        }
      }
    )
  }
}

