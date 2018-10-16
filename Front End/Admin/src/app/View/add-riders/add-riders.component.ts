import { Component, OnInit, ViewChild } from '@angular/core';
import { AddRiders } from '../../Dto/add-riders';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { AddRidersService } from '../../Service/add-riders.service';
import { FileUploadService } from '../../Service/file-upload.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-add-riders',
  templateUrl: './add-riders.component.html',
  styleUrls: ['./add-riders.component.css']
})

export class AddRidersComponent implements OnInit {
  addRiders:  Array<AddRiders> = [];
  selectedAddRiders: AddRiders = new AddRiders();
  tempAddItem : AddRiders = null;
  manuallySelected: boolean = false;
  @ViewChild("frmAddRider") frmAddRider: NgForm;
  date: string;
  file: File; 
  imageUrl :String ="/assets/default-thumbnail.jpg";
  fileTouupload : File=null;
  time :String; 
  constructor( private http: HttpClient , private addRidersService :AddRidersService, private fileupload :FileUploadService, private datepipe: DatePipe) { }
  ngOnInit() {
  }

  uploadImage(event) {
    this.file = event.target.files[0];
  }

  saveEvents(): void {
    this.selectedAddRiders.imageUrl;
    let formData: FormData = new FormData();
    formData.append("file", this.file);
  	formData.append("file", this.file);
    this.fileupload.uploadFile(formData).subscribe(result => { 
      if(result[0]!==null){      
        this.selectedAddRiders.imageUrl = result[0];  
        this.addRidersService.saveRider(this.selectedAddRiders)
        .subscribe(
        (result)=>{
          if (result){
            alert("Item has been saved successfully");    
          }else{
            alert("Failed to save the Item");     
          }
        });      
      }else {
        alert("File upload failed");
      }
    });
    // this. getAllItem();
  }

  handleFileInput(file : FileList){
    this.fileTouupload=file.item(0);
    var reader = new FileReader();
    reader.onload= (event :any)=>{
    this.imageUrl=event.target.result;
    }
  reader.readAsDataURL(this.fileTouupload);
  }


}
