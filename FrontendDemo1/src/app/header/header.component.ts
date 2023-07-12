import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from '../common.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{

  menuType: String = 'default';

  constructor(
    private router: Router,
    private commonService: CommonService
  ){
    this.checkMenuType();
  }

  ngOnInit(): void {
    
  }

  checkMenuType(){
    this.router.events.subscribe(
      (val: any) => {
        if(localStorage.getItem('role') === 'employee'){
          this.menuType = 'employee';
        }else if(localStorage.getItem('role') === 'manager'){
          this.menuType = 'manager';
        }else if(localStorage.getItem('role') === 'admin'){
          this.menuType = 'admin';
        }
      }
    )
  }
  
  logOut(){
    localStorage.removeItem('role');
    localStorage.removeItem('user_id');
    this.router.navigate(['login']);
    localStorage.clear();
  }

  changeMainTab(kind:string):void{
    this.commonService.changeMainTab(kind);
  }
  reportPage(){
    this.commonService.next('default');
  }
}
