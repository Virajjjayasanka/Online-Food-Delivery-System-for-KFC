import { Component, OnInit } from '@angular/core';
import {ClientLoginService} from "../../../searvice/client-login.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs/index";
import { ClientCustomer } from '../../../dto/client-customer';
import { CookieService } from 'ngx-cookie-service';
import { ClientCustomerService } from '../../../searvice/client-customer.service';
import { ItemServiceService } from '../../../searvice/item-service.service';

@Component({
  selector: 'app-main-dash-board',
  templateUrl: './main-dash-board.component.html',
  styleUrls: ['./main-dash-board.component.css']
})

export class MainDashBoardComponent implements OnInit {
 
  sessionId: Observable<string>;
  token: Observable<string>;
  user: ClientCustomer = new ClientCustomer();
  cookieValue = 'UNKNOWN';
  Customers:  Array<ClientCustomer> = [];
  imageUrl : String ="/assets/images/customerImage/default-avatar.png";
  allItem: number = 20;

  constructor(private authService: ClientLoginService,
              private Roter:Router,
              private rote: ActivatedRoute,
              private cookieService: CookieService ,
              private customer: ClientCustomerService,
             
  ) { }

  ngOnInit() {
   this.cookieValue = this.cookieService.get('Test');

    this.getCustomer();
  }


  login(): void {
    this.authService.login(this.user).subscribe(
      (result) => {
       console.log(this.user);
      }
    )
  }


  logout(): void{
    this.cookieService.delete('test');
    this.authService.logout();
  }

  getCustomer(): void {
    this.customer.getCustomer(this.cookieValue).subscribe(
      (result) => {
        this.Customers= result;
        this.Customers =  result;
        console.log(this.Customers);
        for (const Customers of this.Customers) {
          Customers.customerImage;
          this.imageUrl = Customers.customerImage;
          console.log("service :"+ this.imageUrl  );
        }
      }
     );
  }

 


}
