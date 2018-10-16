import { ClientCustomer } from "./client-customer";
import { OrderDetailDto } from "./order-detail-dto";

export class OrderDto {
    oderID: number ;
    date: Date ;
    total : number ;
    caption : string ;
    riderName : string;
    customerDto: ClientCustomer = new ClientCustomer();
    orderDitailDto: Array<OrderDetailDto>;

}
