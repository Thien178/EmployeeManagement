import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  private mainTab:Subject<any> = new Subject<any>();
  private data$:Subject<any> = new Subject<any>();

  constructor() { }
  next(data:any):void{
    this.data$.next(data);
  }
  select():Observable<any>{
    return this.data$.asObservable();
  }
  changeMainTab(data:any):void{
    return this.mainTab.next(data);
  }
  mainTabStatus():Observable<any>{
    return this.mainTab.asObservable();
  }
}
