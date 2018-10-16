import { OrderDto } from "./order-dto";

export class OrderDetailDto {

    orderDitailDtoID : number ;
    itemModel : string ;
    itemName : string ;
    imageURL : string ;
    customerEmail : string;
    price : number ;
    qty : number ;
    subTotal : number ;
    orders: OrderDto = new OrderDto();
}
