import { Component, OnInit } from '@angular/core';
import { OrderDetailService } from '../../../searvice/order-detail.service';
import { OrdersService } from '../../../searvice/orders.service';
import { OrderDitailsService } from '../../../searvice/order-ditails.service';
import { ClientCustomerService } from '../../../searvice/client-customer.service';
import { DatePipe } from '@angular/common';
import { OrderDto } from '../../../dto/order-dto';
import { OrderDetailDto } from '../../../dto/order-detail-dto';
import { ClientCustomer } from '../../../dto/client-customer';
import { OnlineRidersService } from '../../../searvice/riderService/online-riders.service';
import { RiderOnlinedto } from '../../../dto/RiderDto/rider-onlinedto';
import { CookieService } from 'ngx-cookie-service';
import { RiergetallorderService } from '../../../searvice/riderService/riergetallorder.service';
import { observable, Observable } from 'rxjs';
import { RiderGetOrdersService } from '../../../searvice/riderService/rider-get-orders.service';
import { RidergetOrder } from '../../../dto/RiderDto/riderget-order';
import { AllRidersService } from '../../../searvice/riderService/all-riders.service';


@Component({
  selector: 'app-rider-main-dash-board-two',
  templateUrl: './rider-main-dash-board-two.component.html',
  styleUrls: ['./rider-main-dash-board-two.component.css']
})
export class RiderMainDashBoardTwoComponent implements OnInit {
  customerOrdes :  Array<OrderDto> = [];
  takingCustomerOrdes :  Array<OrderDto> = [];
  orderDetailDto :  Array<OrderDetailDto> = [];
  Customers:  Array<ClientCustomer> = [];
  riderOnlinedtos :  Array<RiderOnlinedto> = [];
  time :string 
  oid : number;
  imageUrl :String ="/assets/images/customerImage/default-avatar.png";
  email : string ;
  password: string ;
  redowPasswod: string ;
  teleponeNO: string ;
  fullName: string ;
  distriac: string ;
  address: string ;
  youmanssge: string ;
  customerImage : string ;
  selectedRider: RiderOnlinedto = new RiderOnlinedto();
  selectedRidername: RiderOnlinedto = new RiderOnlinedto();
  panding : string;
  cookieValue = 'UNKNOWN';
  ridername : string 
  timer: any;
  now:number;
  allRider = 0;
  onlineRiders =0;
  selectesbmitOrder: RidergetOrder = new RidergetOrder();

  constructor( private datepipe: DatePipe,private cookieService: CookieService, private customer: ClientCustomerService , private orderServie : OrdersService, private orderDetailsSerive : OrderDitailsService, private onlineRiersSerivice :OnlineRidersService, private riergetallorderService : RiergetallorderService , private riderGetOrdersService : RiderGetOrdersService, private allRidersService : AllRidersService, private onlineRidersService : OnlineRidersService ) {
    setInterval(() => {
      this.now = Date.now();
    }, 1);
   }
  ngOnInit() {
    this. getAllOnlineRiders();
    this.getpandingOrder();
    this. getTakingOrder();
    this. getTotalAllRiders();
    this. getTotalAllOnlineRider();
    this.cookieValue = this.cookieService.get('Test');
    this.time = this.datepipe.transform(new Date(), 'hh:mm:ss');
    if (this.riderOnlinedtos.length > 0) {
      this.selectedRider.riderName = this.riderOnlinedtos[0].riderName;
      console.log("Rider name Consrater : "+  this.selectedRider.riderName);
    }
  }
  getCustomerorderList(orderdto : OrderDto): void { 
    this.oid = orderdto.oderID 
    this.orderDetailsSerive.getOrderList(orderdto.oderID)
    
    .subscribe(responce => {
      this.orderDetailDto= responce;
      // this.orderDetailDto = responce;
      console.log(responce);
    }
    )
  }
  getUpdtePriceCal(riderNames : RiderOnlinedto ) : void {
   
   this. ridername =riderNames.riderName;
   console.log("rider nmae hhhhhhh"+ this. ridername);
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

  Update(orderDto : OrderDto): void {
    const orderDTO: OrderDto = new OrderDto();
    orderDTO.customerDto = new ClientCustomer();
    orderDTO.customerDto.email = orderDto.customerDto.email;
    orderDTO.oderID = orderDto.oderID ;
    console.log("order id rider : " +orderDto.oderID )
    orderDTO.total = orderDto.total;
    orderDTO.riderName = this.selectedRider.riderName;
    console.log("Rider name :"+ this.selectedRider.riderName);
    orderDTO.caption = "Taking";
    orderDTO.orderDitailDto = [];
    this.orderServie.UpdateOrder(orderDTO)
    .subscribe(result => {
      if (result) {
        alert(" Your Order has been Taking successfully");
       this.getpandingOrder();
       this.getTakingOrder();
      } else {
        alert(" Your Order has been Taking Unsuccessfully");
      } 
    })  
  }

  CansalOrder(orderDto : OrderDto): void {
    const orderDTO: OrderDto = new OrderDto();
    orderDTO.customerDto = new ClientCustomer();
    orderDTO.customerDto.email = orderDto.customerDto.email;
    console.log("customer Email"+this.cookieValue)
    orderDTO.oderID = orderDto.oderID ;
    console.log("order id rider : " +orderDto.oderID )
    orderDTO.total = orderDto.total;
    orderDTO.riderName = this.selectedRider.riderName;
    orderDTO.caption = "panding";
    orderDTO.orderDitailDto = [];
    this.orderServie.UpdateOrder(orderDTO)
    .subscribe(result => {
      if (result) {
        alert(" Your Order has been Cancel");
       this.getpandingOrder();
       this.getTakingOrder();
      } else {
        alert(" Your Order has been Cancel Unsuccessfully");
      } 
    })  
  }

  getTakingOrder(): void{
    this.panding = "Taking";
    this.riergetallorderService.getPandingOrder(this.panding).subscribe(
      (result) => {
        this.takingCustomerOrdes = result;
        console.log(this.customerOrdes);
        console.log( this.panding);
      }
    )

  } 

  getCustomer(orderdto : OrderDto): void {
    this.customer.getCustomer(orderdto.customerDto.email).subscribe(
      (result) => {
        this.Customers= result;
        this.Customers =  result;
        console.log(this.Customers);
        for (const Customers of this.Customers) {
          Customers.email;
          this.email = Customers.email;
          Customers.password;
          this.password = Customers.password;
          Customers.redowPasswod;
          this.redowPasswod =  Customers.redowPasswod;
          Customers.teleponeNO;
          this.teleponeNO =  Customers.teleponeNO;
          Customers.fullName;
          this.fullName =  Customers.fullName;
          Customers.distriac;
          this.distriac =  Customers.distriac;
          Customers.address;
          this.address =  Customers.address;
          Customers.youmanssge;
          this.youmanssge =  Customers.youmanssge;
          Customers.customerImage;
          this.imageUrl= Customers.customerImage;
          }
        }
     );
  }



  getAllOnlineRiders(): void{
    this.onlineRiersSerivice.getAllOnileRiders().subscribe(
      (result) => {
        this.riderOnlinedtos = result;
        //console.log(this.orderDetailDto);
      }
    )

  } 

  sbmitRiderOrder(orderDto : OrderDto): void {
   this.selectesbmitOrder.oderID = orderDto.oderID;
   this.selectesbmitOrder.customerID = orderDto.customerDto.id;
   this.selectesbmitOrder.riderName =  orderDto.riderName;
   this.selectesbmitOrder.total = orderDto.total;
   this.selectesbmitOrder.payament = this.selectesbmitOrder.payament;
   this.riderGetOrdersService.SaveGetRiderOrder(this.selectesbmitOrder)
    .subscribe(result => {
      if (result) {
        alert(" Your Order has been Submit successfully");
          const orderDTO: OrderDto = new OrderDto();
          orderDTO.customerDto = new ClientCustomer();
          orderDTO.customerDto.email = orderDto.customerDto.email;
          orderDTO.oderID = orderDto.oderID ;
          orderDTO.total = orderDto.total;
          orderDTO.riderName = this.selectedRider.riderName;
          orderDTO.caption = "Submit";
          orderDTO.orderDitailDto = [];
          this.orderServie.UpdateOrder(orderDTO)
          .subscribe(result => {
            if (result) {   
             this.getpandingOrder();
             this.getTakingOrder();
            } else {
            } 
          })  
       this.getpandingOrder();
       this.getTakingOrder();
      } else {
        alert(" Your Order has been Submit Unsuccessfully");
      } 
    })  
  }



  getTotalAllRiders(): void{
    this.allRidersService.getCountAllRiders().subscribe(
      (count) =>{
        this.allRider = count;
      }
    )
  }

  getTotalAllOnlineRider(): void{
    this.onlineRidersService.getCountOnlineRiders().subscribe(
      (count) =>{
        this.onlineRiders = count;
      }
    )
  }


  
}
