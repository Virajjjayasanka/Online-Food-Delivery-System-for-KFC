import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { ItemServiceService } from '../../../searvice/item-service.service';
import { ClientCustomerService } from '../../../searvice/client-customer.service';
import { OrderDto } from '../../../dto/order-dto';
import { OrdersService } from '../../../searvice/orders.service';
import { ClientCustomer } from '../../../dto/client-customer';

@Component({
  selector: 'app-manage-main-dash-board',
  templateUrl: './manage-main-dash-board.component.html',
  styleUrls: ['./manage-main-dash-board.component.css']
})
export class ManageMainDashBoardComponent implements OnInit {
  cookieValue = 'UNKNOWN';
  allItem: number = 0;
  totalCustomers : number=0;
  customerOrdes :  Array<OrderDto> = [];
  Customers:  Array<ClientCustomer> = [];
  id : number;
  subtotalAllItem = 0;
  totalamount : number;
  customerId : number
  constructor( private cookieService: CookieService,  private itemService : ItemServiceService, private customerDetailsService : ClientCustomerService, private orderService : OrdersService ,private customer: ClientCustomerService ) { }

  ngOnInit() {
    this.cookieValue = this.cookieService.get('Test');
    console.log("aabbssdfd"+this.cookieService.get('Test'));
    this.getAllItem();
    this.getTotalCustomers();
    this. CustomerTotalCountall();
  }
  getAllItem(): void{
    this.itemService.getCountItem().subscribe(
      (count) =>{
        this.allItem = count;
      }
    )
  }

  getTotalCustomers(): void{
    this.customerDetailsService.getCountTotal().subscribe(
      (count) =>{
        this.totalCustomers = count;
      }
    )
  }

  CustomerTotalCountall(): void{
    this.customer.getCustomer(this.cookieValue).subscribe(
      (result) => {
        this.Customers= result;
        this.Customers =  result;
        console.log(this.Customers);
        for (const Customers of this.Customers) {
          Customers.id;
          this.customerId =  Customers.id;
          this.orderService.getCustomerorder(this.customerId).subscribe(responce => {
            this.customerOrdes= responce; 
            for (const customerOrdes of this.customerOrdes ) {
              customerOrdes.total 
              this.subtotalAllItem = customerOrdes.total
              let total = 0;
              for (var i = 0; i < this.customerOrdes.length; i++) {
                  if (this.customerOrdes[i].total) {
                      total += this.customerOrdes[i].total;
                      this.totalamount = total;
                  }
              }  
              return total; 
            }
            console.log(responce);
          })
          }
        }
     );
    }
}
