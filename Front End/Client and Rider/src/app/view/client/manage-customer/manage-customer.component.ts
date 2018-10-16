import { Component, OnInit } from '@angular/core';
import { ClientCustomerService } from '../../../searvice/client-customer.service';
import { CookieService } from 'ngx-cookie-service';
import { ClientCustomer } from '../../../dto/client-customer';
import { CustomerFileUploadService } from '../../../searvice/customer-file-upload.service';

@Component({
  selector: 'app-manage-customer',
  templateUrl: './manage-customer.component.html',
  styleUrls: ['./manage-customer.component.css']
})
export class ManageCustomerComponent implements OnInit {
imageUrl :String ="/assets/images/customerImage/default-avatar.png";
fileTouupload : File=null;
cookieValue = 'UNKNOWN';
Customers:  Array<ClientCustomer> = [];
selectedFeedBack: ClientCustomer = new ClientCustomer();
file: File; 

email : string ;
password: string ;
redowPasswod: string ;
teleponeNO: string ;
fullName: string ;
distriac: string ;
address: string ;
youmanssge: string ;
customerImage : string ;


constructor(private customer: ClientCustomerService,
            private cookieService: CookieService,
            private fileupload :CustomerFileUploadService


  ) { }

  ngOnInit() {
    this.cookieValue = this.cookieService.get('Test');
    this.getCustomer();
  }

  uploadImage(event) {
    this.file = event.target.files[0];
  }

  handleFileInput(file : FileList){
    this.fileTouupload=file.item(0);
    var reader = new FileReader();
    reader.onload= (event :any)=>{
    this.imageUrl=event.target.result;
    }
  reader.readAsDataURL(this.fileTouupload);
  }


  getCustomer(): void {
    this.customer.getCustomer(this.cookieValue).subscribe(
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
}
