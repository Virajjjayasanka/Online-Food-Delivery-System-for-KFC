import { Component, OnInit, ViewChild } from '@angular/core';
import {ClientLogin} from "../../dto/client-login";
import {ClientLoginService} from "../../searvice/client-login.service";
import { Output, EventEmitter } from '@angular/core';
import {NavigationExtras, Router} from "@angular/router";
import { ClientCustomer } from '../../dto/client-customer';
import { NgForm } from '@angular/forms';
import { ClientCustomerService } from '../../searvice/client-customer.service';
import { CookieService } from 'ngx-cookie-service';
import { CustomerFileUploadService } from '../../searvice/customer-file-upload.service';
import { RiderLoginServiceService } from '../../searvice/riderService/rider-login-service.service';
import { RiderLoginDto } from '../../dto/RiderDto/rider-login-dto';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],


})
export class LoginComponent implements OnInit {
  customer: Array<ClientCustomer> = [];
  selectedcustomer: ClientCustomer = new ClientCustomer();
  selectRider : RiderLoginDto  = new RiderLoginDto();
  tempFeedBack : ClientCustomer = null;
  manuallySelected: boolean = false;
  @ViewChild("frmCustomer") frmCustomer: NgForm;
  date: string;
  cookieValue = 'UNKNOWN';
  fileTouupload : File=null;
  file: File;

    // user: ClientLogin = new ClientLogin();

    failed: boolean;
    constructor(private clientLoginService: ClientLoginService,
    private Roter:Router,
    private customerService: ClientCustomerService,
    private cookieService: CookieService,
    private fileupload : CustomerFileUploadService,
    private loinRider : RiderLoginServiceService
    ) {}


  ngOnInit() {
    // this.cookieService.set( 'Test', this.selectedcustomer.email);
    // this.cookieValue = this.cookieService.get('Test');
  }

  uploadImage(event) {
    this.file = event.target.files[0];
    console.log("this.file = event.target.files[0];"+ this.file);
  }
 //login Customer
  login(): void{
    this.cookieService.set( 'Test', this.selectedcustomer.email);
    this.cookieValue = this.cookieService.get('Test');
    this.clientLoginService.login(this.selectedcustomer).subscribe(
      (result)=>{
        this.failed = !result;
      }
    );
    console.log("aaaaaaaaalogin"+this.cookieValue);
  }
 //End

 // save customer
  saveCustomer(): void{
    this.selectedcustomer.customerImage;
    console.log("Save customer tc :" + this.selectedcustomer.customerImage);
    let formData: FormData = new FormData();
    formData.append("file", this.file);
    formData.append("file", this.file);    
    console.log("Save customer tc :" + formData);
    this.fileupload.uploadFile(formData).subscribe(result => {
      if(result[0]!==null){
        this.selectedcustomer.customerImage = result[0];
        console.log("Save customer tcaaaaaa :" + this.selectedcustomer.customerImage);
        this.customerService.saveCustomer(this.selectedcustomer)
        .subscribe(
        (result)=>{
          if (result){
            alert("Login successfully");
                  //console.log("Save customer tc :" + result);
          }else{
            alert("Failed to save the customer");
          }
        });
      }else {
        alert("Login Unsuccessfully");
      }
    });
  }

// End

//cler text Filed
clear(): void {
  let index = this.customer.indexOf(this.selectedcustomer);
  if (index !== -1) {
    this.customer[index] = this.tempFeedBack;
    this.tempFeedBack = null;
  }
  this.selectedcustomer = new ClientCustomer();
  this.manuallySelected = false;
}
//End


 //login Rider
 loginRider(): void{
  this.cookieService.set( 'Test', this.selectRider.username);
  this.cookieValue = this.cookieService.get('Test');
  this.loinRider.login(this.selectRider).subscribe(
    (result)=>{
      this.failed = !result;
      if (result){
        alert("Login successfully");
              //console.log("Save customer tc :" + result);
      }else{
        alert("Login Unsuccessfully");
      }
    }


  );
  console.log("login cooki value : "+this.cookieValue);
}
//End




}
