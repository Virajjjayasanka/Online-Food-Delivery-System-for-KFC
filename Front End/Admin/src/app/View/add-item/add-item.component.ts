import { Component, OnInit, ViewChild } from '@angular/core';
import { AdditemDto } from '../../Dto/additem-dto';
import { NgForm } from '@angular/forms';
import { FileUploadService } from '../../Service/file-upload.service';
import { HttpClient } from '@angular/common/http';
import { AdditemServiceService } from '../../Service/additem-service.service';
import { DatePipe, Time } from '@angular/common';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
 
  
  additemDto:  Array<AdditemDto> = [];
  selectedAddItem: AdditemDto = new AdditemDto();
  tempAddItem : AdditemDto = null;
  manuallySelected: boolean = false;
  @ViewChild("frmAddItem") frmAddItem: NgForm;
  date: string;
  file: File; 
  imageUrl :String ="/assets/default-thumbnail.jpg";
  fileTouupload : File=null;
  time :String; 
 
  
  constructor( private http: HttpClient , private addItemService :AdditemServiceService, private fileupload :FileUploadService, private datepipe: DatePipe ) { }

  ngOnInit() {
    this. getAllItem();
    this.time = this.datepipe.transform(new Date(), 'hh:mm:ss');
		this.date= this.datepipe.transform(new Date(), 'yyyy-MM-dd');
  }

  uploadImage(event) {
    this.file = event.target.files[0];
  }

  saveEvents(): void {
    this.selectedAddItem.itemImage;
    this.selectedAddItem.date = this.date;
    this.selectedAddItem.time = this.time;
    let formData: FormData = new FormData();
    formData.append("file", this.file);
  	formData.append("file", this.file);
    
    this.fileupload.uploadFile(formData).subscribe(result => { 
      if(result[0]!==null){      
        this.selectedAddItem.itemImage = result[0];
       
        this.addItemService.saveItem(this.selectedAddItem)
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
 
    this. getAllItem();
  }




  getAllItem(): void {
    this.addItemService.getAllItem().subscribe(
      (result) => {
        this.additemDto= result;
        console.log(this.additemDto);

      }
    )
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
