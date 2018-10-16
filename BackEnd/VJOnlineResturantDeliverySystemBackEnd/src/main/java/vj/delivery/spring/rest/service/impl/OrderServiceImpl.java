package vj.delivery.spring.rest.service.impl;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vj.delivery.spring.rest.dto.CustomerDto;
import vj.delivery.spring.rest.dto.OrderDitailDto;
import vj.delivery.spring.rest.dto.OrderDto;
import vj.delivery.spring.rest.entity.Customer;
import vj.delivery.spring.rest.entity.Orders;
import vj.delivery.spring.rest.entity.OrderDetail;
import vj.delivery.spring.rest.repostrory.CustomerRepostroy;
import vj.delivery.spring.rest.repostrory.OrderRepostroy;
import vj.delivery.spring.rest.service.OderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrderServiceImpl implements OderService {

    @Autowired
    private OrderRepostroy orderRepostroy;
    @Autowired
    private CustomerRepostroy customerRepostroy;

    @Autowired
    private CustomerRepostroy customerRepository;


    @Override
    public ArrayList<OrderDto> getAllOrders() {
        List<Orders> ordersList = orderRepostroy.findAll();
        ArrayList<OrderDto> ordersDTOS = new ArrayList<>();
        for (Orders orders : ordersList) {
            List<OrderDitailDto> orderDetailDTOS = new ArrayList<>();
            for (OrderDetail orderDetail : orders.getOrderDetail()) {
                OrderDitailDto orderDetailDTO = new OrderDitailDto(
                        orderDetail.getOrderDitailDtoID(),
                        orderDetail.getItemModel(),
                        orderDetail.getItemName(),
                        orderDetail.getImageURL(),
                        orderDetail.getCustomerEmail(),
                        orderDetail.getPrice(),
                        orderDetail.getQty(),
                        orderDetail.getSubTotal()
                );
                orderDetailDTOS.add(orderDetailDTO);
            }
            OrderDto ordersDTO = new OrderDto(
                    orders.getOderID(),
                    orders.getDate(),
                    orders.getTotal(),
                    orders.getCaption(),
                    orders.getRiderName(),
                    new CustomerDto(
                            orders.getCustomer().getId(),
                            orders.getCustomer().getEmail(),
                            orders.getCustomer().getPassword(),
                            orders.getCustomer().getRedowPasswod(),
                            orders.getCustomer().getTeleponeNO(),
                            orders.getCustomer().getFullName(),
                            orders.getCustomer().getDistriac(),
                            orders.getCustomer().getAddress(),
                            orders.getCustomer().getYoumanssge(),
                            orders.getCustomer().getCustomerImage()
                    ),
                    orderDetailDTOS);

            ordersDTOS.add(ordersDTO);
        }
        return ordersDTOS;
    }

    @Override
    public OrderDto getOrder(int oderID) {
       // System.out.println("impl order dital : " + oderID);
      //  System.out.println("impl order dital orders_oderID : " + oderID);
        Orders orders = orderRepostroy.findById(oderID).get();
        List<OrderDitailDto> orderDetailDTOS = new ArrayList<>();
        for (OrderDetail orderDetail: orders.getOrderDetail()) {
            OrderDitailDto orderDetailDTO = new OrderDitailDto(
                    orderDetail.getOrderDitailDtoID(),
                    orderDetail.getItemModel(),
                    orderDetail.getItemName(),
                    orderDetail.getImageURL(),
                    orderDetail.getCustomerEmail(),
                    orderDetail.getPrice(),
                    orderDetail.getQty(),
                    orderDetail.getSubTotal()

            );
            orderDetailDTOS.add(orderDetailDTO);
        }
        return new OrderDto(
                orders.getOderID(),
                orders.getDate(),
                orders.getTotal(),
                orders.getCaption(),
                orders.getRiderName(),
                new CustomerDto(
                        orders.getCustomer().getId(),
                        orders.getCustomer().getEmail(),
                        orders.getCustomer().getPassword(),
                        orders.getCustomer().getRedowPasswod(),
                        orders.getCustomer().getTeleponeNO(),
                        orders.getCustomer().getFullName(),
                        orders.getCustomer().getDistriac(),
                        orders.getCustomer().getAddress(),
                        orders.getCustomer().getYoumanssge(),
                        orders.getCustomer().getCustomerImage()
                ),
                orderDetailDTOS);
    }

    @Override

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteOrder(int oderID) {
        orderRepostroy.deleteById(oderID);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addOrder(OrderDto orderDto) {
        System.out.println("order service impl order ; " + orderDto);
        orderDto.setDate(new Date());
        Orders orders = new Orders(0, orderDto.getDate(), orderDto.getTotal(), orderDto.getCaption(), orderDto.getRiderName(), customerRepository.findByEmailAddress(orderDto.getCustomerDto().getEmail()).get(0));
        System.out.println("order service impl orders muin eka  ; " + orders);
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDitailDto orderDetailDto : orderDto.getOrderDitailDto()) {
            OrderDetail orderDetail = new OrderDetail(
                    0,
                    orderDetailDto.getItemModel(),
                    orderDetailDto.getItemName(),
                    orderDetailDto.getImageURL(),
                    orderDetailDto.getCustomerEmail(),
                    orderDetailDto.getPrice(), orderDetailDto.getQty(),
                    orderDetailDto.getSubTotal(),
                    orders
            );
            System.out.println("order service impl order ; " + orderDetails);
            orderDetails.add(orderDetail);
        }
        orders.setOrderDetail(orderDetails);
        orderRepostroy.save(orders);
        return true;
    }

    @Override
    public long getTotalOrder(int customer_id) {
        return 0;
    }

//    @Override
//    public long getTotalOrder() {
//        return orderRepostroy.getTotalOrder();
//    }


    @Override
    public ArrayList<OrderDto> getOrders(int customer_id) {
        System.out.println("Order Service Iml get" + customer_id);
        List<Orders> ordersList = orderRepostroy.getOrders(customer_id);
        ArrayList<OrderDto> alorders = new ArrayList<>();
        for (Orders orders : ordersList) {
            OrderDto orderDto = new OrderDto(
                    orders.getOderID(),
                    orders.getDate(),
                    orders.getTotal(),
                    orders.getCaption(),
                    orders.getRiderName()
            );
            alorders.add(orderDto);
        }
        return alorders;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateSelectItem(OrderDto orderDto) {
            System.out.println("Update Order eka : "+orderDto);
            orderDto.setDate(new Date());
            Orders orders = new Orders(orderDto.getOderID(), orderDto.getDate(), orderDto.getTotal(), orderDto.getCaption(), orderDto.getRiderName(), customerRepository.findByEmailAddress(orderDto.getCustomerDto().getEmail()).get(0));
            System.out.println("Update Order eka  id : "+orderDto.getOderID());
            System.out.println("Update Order eka customer  id : "+customerRepository.findByEmailAddress(orderDto.getCustomerDto().getEmail()).get(0));

            orders.setOrderDetail(orderRepostroy.findById(orderDto.getOderID()).get().getOrderDetail());
            orders.setOrderDetail(null);
            orderRepostroy.saveAndFlush(orders);
            return true;
     //   findById(orderDto.etORderID()).get().getOrderDetaios()
    }

    @Override
    public ArrayList<OrderDto> getOrderDilver(String caption) {
        List<Orders> ordersList = orderRepostroy.getOrderDilver(caption);
        ArrayList<OrderDto> alorders = new ArrayList<>();
        for (Orders orders : ordersList) {
            OrderDto orderDto = new OrderDto(
                    orders.getOderID(),
                    orders.getDate(),
                    orders.getTotal(),
                    orders.getCaption(),
                    orders.getRiderName(),
                    new CustomerDto(
                            orders.getCustomer().getId(),
                            orders.getCustomer().getEmail(),
                            orders.getCustomer().getPassword(),
                            orders.getCustomer().getRedowPasswod(),
                            orders.getCustomer().getTeleponeNO(),
                            orders.getCustomer().getFullName(),
                            orders.getCustomer().getDistriac(),
                            orders.getCustomer().getAddress(),
                            orders.getCustomer().getYoumanssge(),
                            orders.getCustomer().getCustomerImage()

                    ));
            alorders.add(orderDto);
        }
        return alorders;
    }
}
//    @Override
//    public ArrayList<OrderDitailDto> getOrdersCutomerList(orders_oderID) {
//
//}

