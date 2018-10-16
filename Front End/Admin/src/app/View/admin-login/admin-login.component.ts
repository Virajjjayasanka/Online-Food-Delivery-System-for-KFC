import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from '../../Service/admin-service.service';
import { AddminLogin } from '../../Dto/addmin-login';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  selectedAmin: AddminLogin = new AddminLogin();
  failed: boolean;
  constructor(private adminLoginService:AdminServiceService,
    private Roter:Router) { }

  ngOnInit() {
  }

  login(): void{
    this.adminLoginService.login(this.selectedAmin).subscribe(
      (result)=>{
        this.failed = !result;
      }
    );
   
  }

}
