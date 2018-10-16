import {Component, OnInit, ViewChild} from '@angular/core';
import {FeedBack} from "../../../dto/feed-back";
import {NgForm} from "@angular/forms";
import {FeedBackService} from "../../../searvice/feed-back.service";
import {DatePipe} from "@angular/common";
import {MainDashBoardComponent} from "../main-dash-board/main-dash-board.component";
import {ActivatedRoute, Router} from "@angular/router";
import {extractStyleParams} from "@angular/animations/browser/src/util";
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-manage-feed-back',
  templateUrl: './manage-feed-back.component.html',
  styleUrls: ['./manage-feed-back.component.css']

})
export class ManageFeedBackComponent implements OnInit {

  feddback:  Array<FeedBack> = [];
  selectedFeedBack: FeedBack = new FeedBack();
  tempFeedBack : FeedBack = null;
  manuallySelected: boolean = false;
  @ViewChild("frmFeedBack") frmFeedBack: NgForm;
  date: string;
  cookieValue = 'UNKNOWN';
  constructor(private feedBackService: FeedBackService ,private datepipe: DatePipe, private  MainDashBoardComponent :MainDashBoardComponent,
              private Roter:Router,
              private rote: ActivatedRoute,
              private cookieService: CookieService

  ) { }

  ngOnInit() {
    this.rote.queryParams.subscribe((params)=>{
      console.log(params);

    this.cookieValue = this.cookieService.get('Test');
    console.log("aabbssdfd"+this.cookieService.get('Test'));
    this.findByEmailAddress();
    })

    // this.date = this.datepipe.transform(new Date(), 'yyyy-MM-d');
  }


  saveFeedBAck(): void{
    this.selectedFeedBack.gmail= this.cookieValue;
    this.selectedFeedBack.uverFeedBack = "Empty";
    this.selectedFeedBack.date = new Date();
    // console.log("bbbbbbbbbbbb"+this.selectedFeedBack);

    this.feedBackService.saveFeedBAck(this.selectedFeedBack)
      .subscribe(
      (result)=>{
        if (result){
          alert("feedback has been saved successfully");
        }else{
          alert("Failed to save the feedback");
        }
        this.findByEmailAddress();
      }
    )
  }

   findByEmailAddress(): void {
    this.feedBackService.findByEmailAddress(this.cookieValue).subscribe(
      (result) => {
        this.feddback= result;
        console.log(this.feddback);

      }
    )
  }

  clear(): void {
    let index = this.feddback.indexOf(this.selectedFeedBack);
    if (index !== -1) {
      this.feddback[index] = this.tempFeedBack;
      this.tempFeedBack = null;
    }
    this.selectedFeedBack = new FeedBack();
    this.manuallySelected = false;
  }
  selectCustomer(customer: FeedBack): void {
    this.clear();
    this.selectedFeedBack = customer;
    this.tempFeedBack = Object.assign({}, customer);
    this.manuallySelected = true;
  }


  deleteFeedback(feedBackr: FeedBack): void {
    if (confirm("Are you sure you want to delete this Feed back?")) {
      this.feedBackService.deleteFeedback(feedBackr.fid).subscribe(
        (result) => {
          if (result) {
            alert(" Your Feed Back has been deleted successfully");
          } else {
            alert("Failed to delete the Your Feed Back ");
          }
          console.log("aaaaaaaa"+feedBackr.fid);
          
          this.findByEmailAddress();
        }
      )
    }
  }
}
