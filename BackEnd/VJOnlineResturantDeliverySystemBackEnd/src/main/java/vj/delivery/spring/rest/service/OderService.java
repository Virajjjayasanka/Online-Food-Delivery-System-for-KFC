package vj.delivery.spring.rest.service;

import vj.delivery.spring.rest.dto.OrderDitailDto;
import vj.delivery.spring.rest.dto.OrderDto;
import vj.delivery.spring.rest.dto.SelectedItemDto;

import java.util.ArrayList;

public interface OderService {

    public ArrayList<OrderDto> getAllOrders();

    public OrderDto getOrder(int oderID);



    public boolean deleteOrder(int oderID);

    public boolean addOrder(OrderDto orderDto);

    public long getTotalOrder(int customer_id);

    public ArrayList<OrderDto> getOrders(int customer_id);


    public boolean updateSelectItem(OrderDto orderDto);
//    public ArrayList<OrderDitailDto> getOrdersCutomerList(int orders_oderID);

    public ArrayList<OrderDto>  getOrderDilver(String caption);
}
