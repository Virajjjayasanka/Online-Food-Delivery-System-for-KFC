import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { RiderLoginServiceService } from '../../../searvice/riderService/rider-login-service.service';
import { RiderLoginDto } from '../../../dto/RiderDto/rider-login-dto';
import { RiderOnlinedto } from '../../../dto/RiderDto/rider-onlinedto';
import { OnlineRidersService } from '../../../searvice/riderService/online-riders.service';
import { DatePipe } from '@angular/common';
import { AllRidersService } from '../../../searvice/riderService/all-riders.service';

@Component({
  selector: 'app-rider-main-dash-board',
  templateUrl: './rider-main-dash-board.component.html',
  styleUrls: ['./rider-main-dash-board.component.css']
})
export class RiderMainDashBoardComponent implements OnInit {
  cookieValue = 'UNKNOWN';
  selectRider : RiderLoginDto  = new RiderLoginDto();
  selectedRiderOnline: RiderOnlinedto = new RiderOnlinedto();
  orderDetailDto :  Array<RiderOnlinedto> = [];
  riderOnlinedtos :  Array<RiderOnlinedto> = [];
  selectedRider: RiderOnlinedto = new RiderOnlinedto();
  failed: boolean;
  
  constructor(private cookieService: CookieService ,
    private riderLoginServiceService: RiderLoginServiceService,
    private loinRiderService : RiderLoginServiceService,
    private onlineRiersSerivice :OnlineRidersService,
    private datePipe: DatePipe) { }

  ngOnInit() {
    this.cookieValue = this.cookieService.get('Test');
    this.getAllOnlineRiders();
    this.getOnlineRiders();
    if (this.riderOnlinedtos.length > 0) {
      this.selectedRider.riderName = this.riderOnlinedtos[0].riderName;
    }
  }

  getOnlineRiders(): void{
    this.onlineRiersSerivice.getAllOnileRiders().subscribe(
      (result) => {
        this.riderOnlinedtos = result;
        //console.log(this.orderDetailDto);
      }
    )

  } 

  deleteFeedback(): void {
    if (confirm("Are you sure you want to  Logout ?")) {
      this.onlineRiersSerivice.deleteOnileRiders(this.selectedRider.riderName).subscribe(
        (result) => {
          if (result) {
            alert(" logout has been  successfully");
            this.getAllOnlineRiders();
            this.getOnlineRiders();
            this. getAllOnlineRiders(); 
          } else {
            alert("Failed to logout");
          }
        }
      )
    }
  }

  logout(): void{
    this.cookieService.delete('test');
    this.riderLoginServiceService.logout();
  }

  loginRider(): void{
    this.cookieService.set( 'Test', this.selectRider.username);
    this.cookieValue = this.cookieService.get('Test');
    this. selectedRiderOnline.riderName =  this.selectRider.username;
    this. selectedRiderOnline.online =  "Online" ;
    this.loinRiderService.login(this.selectRider).subscribe(
      (result)=>{
        this.failed = !result;
        if (result){
            this.onlineRiersSerivice.OnlineRiders(this. selectedRiderOnline)
              .subscribe(
              (result)=>{
                if (result){
                  alert("Rider is login");
                  this. getAllOnlineRiders(); 
                }else{
                  alert("Failed to login the login");
                }
              
              }
            )
              //console.log("Save customer tc :" + result);
        }else{
          alert("Password InCreart");
        }
      }
    );
  }
  //End

  getAllOnlineRiders(): void{
    this.onlineRiersSerivice.getAllOnileRiders().subscribe(
      (result) => {
        this.orderDetailDto = result;
        //console.log(this.orderDetailDto);
      }
    )

  } 
}
