import { Component, OnInit } from '@angular/core';
import { ItemDto } from '../../../dto/item-dto';
import { OrderDto } from '../../../dto/order-dto';
import { RiergetallorderService } from '../../../searvice/riderService/riergetallorder.service';
import { DatePipe } from '@angular/common';
import { CookieService } from 'ngx-cookie-service';
import { OrderDitailsService } from '../../../searvice/order-ditails.service';

@Component({
  selector: 'app-manage-order-details',
  templateUrl: './manage-order-details.component.html',
  styleUrls: ['./manage-order-details.component.css']
})
export class ManageOrderDetailsComponent implements OnInit {
// itemDtos : Array<ItemDto>=[]
takingCustomerOrdes :  Array<OrderDto> = [];
customerOrdes :  Array<OrderDto> = [];
panding : string ;
oid : number;
  constructor(private riergetallorderService : RiergetallorderService, private datepipe: DatePipe, private cookieService: CookieService ,private orderDetailsSerive : OrderDitailsService) { }

  ngOnInit() {
    //this. getpandingOrder();
  }
  getpandingOrder(): void{
    this.panding = "panding";
    this.riergetallorderService.getPandingOrder(this.panding).subscribe(
      (result) => {
        this.customerOrdes = result;
        console.log(this.customerOrdes);
        console.log( this.panding);
      }
    )

  } 

  

}
