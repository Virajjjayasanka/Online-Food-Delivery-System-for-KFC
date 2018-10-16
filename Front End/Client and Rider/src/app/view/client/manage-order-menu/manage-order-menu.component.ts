import { Component, OnInit, ViewChild } from '@angular/core';
import { ItemDto } from '../../../dto/item-dto';
import { NgForm } from '@angular/forms';
import { ItemServiceService } from '../../../searvice/item-service.service';
import { SelectItemService } from '../../../searvice/select-item.service';
import { SelectItem } from '../../../dto/select-item';
import { CookieService } from 'ngx-cookie-service';
import { ClientCustomer } from '../../../dto/client-customer';
import { OrdersService } from '../../../searvice/orders.service';
import { ClientCustomerService } from '../../../searvice/client-customer.service';
import { OrderDto } from '../../../dto/order-dto';

@Component({
  selector: 'app-manage-order-menu',
  templateUrl: './manage-order-menu.component.html',
  styleUrls: ['./manage-order-menu.component.css']
})

export class ManageOrderMenuComponent implements OnInit {
 

  Items :  Array<ItemDto> = [];
  selectItemDTOS : Array<SelectItem> = [];
  allSelectItem : Array<SelectItem> = [];
  allSelectItemDelete : Array<SelectItem> = [];
  deletAllItemDTO : Array<SelectItem> = [];
  selectedItem: ItemDto = new ItemDto();
  selecteCustomerItems: SelectItem = new SelectItem();
  tempItem : ItemDto = null;
  manuallySelected: boolean = false;
  @ViewChild("frmOrders") frmOrders: NgForm;
  date: string;
  ItemModel = "Bouns";
  cookieValue = 'UNKNOWN';
  SubTotal = 0.00;
  ItemPrice =  this.selecteCustomerItems.price;
  getContity = this.selecteCustomerItems.qty;
  imageUrl :String ="/assets/images/customerImage/default-avatar.png";
  fileTouupload : File=null;
  Customers:  Array<ClientCustomer> = [];
  subTotal = 0.00;
  updateSubTotal = 0.00;

  teleponeNO: string ;
  fullName: string ;
  distriac: string ;
  address: string ;
  customerImage : string ;

  Itemid= 0;
  subtotalAllItem = 0;
  SubTotalItem=0;
  totalamount : number;
  diliverAmount : number;
  allOrderSubtoal : number;

  constructor(private orderService: OrdersService, private itemService : ItemServiceService ,private selectItemService : SelectItemService, private cookieService: CookieService, private customer: ClientCustomerService) { }

    ngOnInit() {
      this.cookieValue = this.cookieService.get('Test');
      this.SelectItemGetAll();
      this.itemSelectModelGet();
      this.getCustomer();
      this.CustomerTotalCount();
      this.itemModelGet();
    
  }

  itemModelGet(): void {
    this.itemService.findByGetModel(this.ItemModel).subscribe(
      (result) => {
        this.Items= result;
        console.log(this.Items);
      }
    )
  }


  itemSelectModelGet(): void {  
    this.selectItemService.getSelectItemGmail(this.cookieValue, this.ItemModel)
      .subscribe(responce => {
        this.selectItemDTOS= responce;
        console.log(responce);
      })
  }

  saveSelctItem(itemDto:ItemDto): void{
    this.selecteCustomerItems.customerGmail= this.cookieValue;
    this.selecteCustomerItems.itemModel= this.ItemModel;
    this.selecteCustomerItems.itemName= itemDto.itemName;
    this.selecteCustomerItems.price= itemDto.itemprice;
    this.selecteCustomerItems.imageURL= itemDto.itemImage;
    this.selecteCustomerItems.subTotal= itemDto.subtotal;
    this.selecteCustomerItems.qty = itemDto.qty;
    this.selectItemService.saveSelectItem(this.selecteCustomerItems)
      .subscribe(
      (result)=>{
        if (result){
          alert("Item Selected successfully");
        }else{
          alert("Failed to Selected");
        }
      }
    )
   this.CustomerTotalCount();
  }

  getPriceCal(price : number , qty : number) : number {
    return this.subTotal = price * qty;
   }


SelectItemGetAll(): void {  
  this.selectItemService.getSelectItem(this.cookieValue)
    .subscribe(responce => {
      this.allSelectItem= responce;
      console.log(responce);
    })
}

save(): void {
  const orderDTO: OrderDto = new OrderDto();
  orderDTO.customerDto = new ClientCustomer();
  orderDTO.customerDto.email = this.cookieValue;
  orderDTO.total = this.totalamount;
  orderDTO.caption = "Panding" ;
  orderDTO.riderName = "null" ;
  orderDTO.orderDitailDto = [];
  for(const allSelectItem of this.allSelectItem){
    orderDTO.orderDitailDto.push({orderDitailDtoID: 0, itemModel: allSelectItem.itemModel, itemName: allSelectItem.itemName, imageURL: allSelectItem.imageURL, customerEmail:allSelectItem.customerGmail, price: allSelectItem.price, qty: allSelectItem.qty, subTotal: allSelectItem.subTotal 
      ,orders:null}); 
  }
  this.orderService.saveOrder(orderDTO)
  .subscribe(result => {
    if (result) {
      alert(" Your Order has been Added successfully");
    } else {

      alert(" Your Order has been Added Unsuccessfully");
    }
   
  })
 this.SaveItemsDeletForItemID(); 
}


getCustomer(): void {
  this.customer.getCustomer(this.cookieValue).subscribe(
    (result) => {
      this.Customers= result;
      this.Customers =  result;
      console.log(this.Customers);
      for (const Customers of this.Customers) {
        Customers.teleponeNO;
        this.teleponeNO =  Customers.teleponeNO;
        Customers.fullName;
        this.fullName =  Customers.fullName;
        Customers.distriac;
        this.distriac =  Customers.distriac;
        Customers.address;
        this.address =  Customers.address;
        Customers.customerImage;
        this.imageUrl= Customers.customerImage;
        }
      }
   );
}

SaveItemsDeletForItemID(): void{
  this.selectItemService.getSelectItem(this.cookieValue)
    .subscribe(responce => {
      this.allSelectItem= responce;
        for (const allSelectItem of this.allSelectItem) {
          allSelectItem.selectItemID
          this.Itemid = allSelectItem.selectItemID
          this.selectItemService.deleteItem(this.Itemid).subscribe(
              (result) => {
                if (result) {                
                } else {                 
                }
                this.SelectItemGetAll();
              }
            )
        }
    })
    this.CustomerTotalCount();
}


deletSelectItem(selectItems: SelectItem): void {
  if (confirm("Are you sure you want to delete this Select Item?")) {
    this.selectItemService.deleteItem(selectItems.selectItemID).subscribe(
      (result) => {
        if (result) {
          alert(" Your Select Item has been deleted successfully");
        } else {
          alert("Failed to delete the Your Select Item ");
        }
        console.log("aaaaaaaa"+selectItems.selectItemID); 
        this.SelectItemGetAll();
        this.CustomerTotalCount();
      }
    )
  }
}


deletSelectItemCustomer(): void {
  if (confirm("Are you sure you want to delete this Select Item?")) {
    this.selectItemService.DeleteSelectItems(this.cookieValue).subscribe(
      (result) => {
        if (result) {
          alert(" Your Select Item has been deleted successfully");
        } else {
          alert("Failed to delete the Your Select Item ");
        }
        this.SelectItemGetAll();
      }
    )
  }
}

CustomerTotalCount(): void{
  this.totalamount = 0.00;
  this.diliverAmount = 0.00;
  this.allOrderSubtoal = 0.00;
  this.selectItemService.getSelectItem(this.cookieValue)
  .subscribe(responce => {
    this.allSelectItem= responce;
      for (const allSelectItem of this.allSelectItem ) {
        allSelectItem.subTotal 
        this.subtotalAllItem = allSelectItem.subTotal 
        let total = 0;
        for (var i = 0; i < this.allSelectItem.length; i++) {
            if (this.allSelectItem[i].subTotal) {
                total += this.allSelectItem[i].subTotal;
                this.totalamount = total;
            }
        }
        console.log("all b : "+total );
        this.diliverAmount = 2.00;
        this.allOrderSubtoal = this.totalamount + this.diliverAmount; 
        return total;
       
      }

    })
}


updateItem(itemselectItemDTOS: SelectItem): void{
   this.selecteCustomerItems.selectItemID= itemselectItemDTOS.selectItemID;
   this.selecteCustomerItems.customerGmail= itemselectItemDTOS.customerGmail;
   this.selecteCustomerItems.itemModel= itemselectItemDTOS.itemModel;
   this.selecteCustomerItems.itemName= itemselectItemDTOS.itemName;
   this.selecteCustomerItems.imageURL= itemselectItemDTOS.imageURL;
   this.selecteCustomerItems.price= itemselectItemDTOS.price;
   this.selecteCustomerItems.qty = itemselectItemDTOS.qty;
   this.selecteCustomerItems.subTotal =itemselectItemDTOS.subTotal;
   this.selectItemService.UpdateSelectItem(this.selecteCustomerItems)
     .subscribe(
     (result)=>{
       if (result){
         alert("Item Selected Update successfully");
         this.CustomerTotalCount();
       }else{
         alert("Failed to Selected Item Update");
       }
     }
   )
  
 }

 //seletItemcunt(): void{}

 getUpdtePriceCal(price : number , qty : number) : number {
  return this.updateSubTotal = price * qty;
 }



}
