import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  name!: string;
  password!:string;

  user:User = new User();
  constructor(private userService :UserServiceService, private router:Router){}
  ngOnInit(): void {
    
  }
  onSubmit(){
    this.user.name=this.name;
    this.user.password=this.password;
    this.userService.checkLogin(this.user).subscribe(
      data=>{
        // console.log(data);
        // console.log(data['role']);
        if(data != null){
          if(data.role === 0){
            localStorage.setItem('role','employee');
            this.router.navigate(['employee']);
          }else if(data.role === 1){
            localStorage.setItem('role','manager');
            this.router.navigate(['manager']);
          }else if(data.role === 2) {
            localStorage.setItem('role','admin');
            this.router.navigate(['admin']);
          }
          localStorage.setItem('user_id',data.id);
        }
        console.log(data);
      }
    )
    console.log(this.user);
  }

}
