package vj.delivery.spring.rest.service;

import vj.delivery.spring.rest.dto.OrderDitailDto;

import java.util.ArrayList;

public interface OderDetailService {

    public ArrayList<OrderDitailDto> getAllOrderDetails();

    public OrderDitailDto getOrderDetail(int orderDitailDtoID);

    public boolean deleteOrderDetail(int orderDitailDtoID);

    public boolean addOrderDetail(OrderDitailDto orderDitailDto);

    public  ArrayList<OrderDitailDto>  getOrderList(int orders_oderID);
}
