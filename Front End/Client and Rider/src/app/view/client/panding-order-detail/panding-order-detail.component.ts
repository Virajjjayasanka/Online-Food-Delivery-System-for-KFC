import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { OrdersService } from '../../../searvice/orders.service';
import { OrderDto } from '../../../dto/order-dto';
import { ClientCustomer } from '../../../dto/client-customer';
import { ClientCustomerService } from '../../../searvice/client-customer.service';
import { DatePipe } from '@angular/common';
import { OrderDetailDto } from '../../../dto/order-detail-dto';
import { OrderDitailsService } from '../../../searvice/order-ditails.service';

@Component({
  selector: 'app-panding-order-detail',
  templateUrl: './panding-order-detail.component.html',
  styleUrls: ['./panding-order-detail.component.css']
})
export class PandingOrderDetailComponent implements OnInit {
  cookieValue = 'UNKNOWN';
  customerOrdes :  Array<OrderDto> = [];
  orderDetailDto :  Array<OrderDetailDto> = [];
  Customers:  Array<ClientCustomer> = [];
  id : number;
  time :string 
  imageUrl :String ="/assets/images/customerImage/default-avatar.png";
  constructor( private cookieService: CookieService, private datepipe: DatePipe, private customer: ClientCustomerService , private orderServie : OrdersService, private orderDetailsSerive : OrderDitailsService) { }

  ngOnInit() {
    this.cookieValue = this.cookieService.get('Test');
    // this.getCustomer();
    this.getCustomerorder();
    
    this.time = this.datepipe.transform(new Date(), 'hh:mm:ss');
  }
  


 getCustomerorder(): void {  
  this.customer.getCustomer(this.cookieValue).subscribe(
    (result) => {
      this.Customers= result;
      this.Customers =  result;
      console.log(this.Customers);
      for (const Customers of this.Customers) {
        Customers.id;
        this.id =  Customers.id;

        // console.log("Abcdefghigk"+this.id);
        this.orderServie.getCustomerorder(this.id)
        .subscribe(responce => {
          this.customerOrdes= responce;
          // this.orderDetailDto = responce;
          console.log(responce);
        })
        }
      }
   );
  }

  getCustomerorderList(orderdto : OrderDto): void {  
          this.orderDetailsSerive.getOrderList(orderdto.oderID)
          .subscribe(responce => {
            this.orderDetailDto= responce;
            // this.orderDetailDto = responce;
            console.log(responce);
          }
          )
        }

      
        deletSelectItemCustomer(orderdto : OrderDto): void {
          if (confirm("Are you sure you want to delete this Select Item?")) {
            this.orderServie.DeleteSelectItems(orderdto.oderID).subscribe(
              (result) => {
                if (result) {
                  alert(" Your Select Item has been deleted successfully");
                } else {
                  alert("Failed to delete the Your Select Item ");
                }
                this.getCustomerorder();
              }
            )
          }
        }   
          
     
}
