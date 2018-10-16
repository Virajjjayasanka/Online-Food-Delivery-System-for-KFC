import { Component, OnInit, ViewChild } from '@angular/core';
import { CustomerDto } from '../../Dto/customer-dto';
import { NgForm } from '@angular/forms';
import { CustomerServiceService } from '../../Service/customer-service.service';
import { FedbackServiceService } from '../../Service/fedback-service.service';
import { FeedbackDto } from '../../Dto/feedback-dto';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
  
  customers:  Array<CustomerDto> = [];
  selectedCustomer: CustomerDto = new CustomerDto();
  tempCustomers : CustomerDto = null;
  manuallySelected: boolean = false;
  @ViewChild("frmCustomer") frmCustomer: NgForm;
  date: string;



  constructor(private customersService : CustomerServiceService, private feedbackService : FedbackServiceService) { }

  ngOnInit() {
    this.getAllCustomer(); 
  }



  getAllCustomer(): void {
    this.customersService.getAllCustomer().subscribe(
      (result) => {
        this.customers= result;
        console.log(this.customers);
      }
    )
  }

  getSerachCustomer(): void {
    console.log("helo"+this.selectedCustomer.email);
    this.customersService.getSearchCustomer(this.selectedCustomer.email).subscribe(
      (result) => {
        this.customers= result;
        console.log(this.customers);
      }
    )
  }

  deleteCustomer(customers : CustomerDto): void {
    if (confirm("Are you sure you want to delete this Feed back?")) {
      this.customersService.deleteCustomer(customers.id).subscribe(
        (result) => {
          if (result) {
            alert(" Your Feed Back has been deleted successfully");
          } else {
            alert("Failed to delete the Your Feed Back ");
          }
          console.log("aaaaaaaa"+customers.id);
          
          this.getAllCustomer(); 
        }
      )
    }
  }



}
