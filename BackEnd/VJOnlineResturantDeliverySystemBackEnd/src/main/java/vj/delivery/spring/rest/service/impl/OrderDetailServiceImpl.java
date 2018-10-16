package vj.delivery.spring.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vj.delivery.spring.rest.dto.OrderDitailDto;
import vj.delivery.spring.rest.entity.OrderDetail;
import vj.delivery.spring.rest.repostrory.OrderDetailsRepostroy;
import vj.delivery.spring.rest.service.OderDetailService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrderDetailServiceImpl implements OderDetailService {

    @Autowired
    private OrderDetailsRepostroy repository;

    @Override
    public ArrayList<OrderDitailDto> getAllOrderDetails() {
        return null;
    }

    @Override
    public OrderDitailDto getOrderDetail(int orderDitailDtoID) {
        return null;
    }

    @Override
    public boolean deleteOrderDetail(int orderDitailDtoID) {
        return false;
    }

    @Override
    public boolean addOrderDetail(OrderDitailDto orderDitailDto) {
        return false;
    }

    @Override
    public ArrayList<OrderDitailDto> getOrderList(int orders_oderID) {
        List<OrderDetail> orderDetails = repository.getOrderList(orders_oderID);
        ArrayList<OrderDitailDto> alCustomers = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            OrderDitailDto orderDitailDto = new OrderDitailDto(
                    orderDetail.getOrderDitailDtoID(),
                    orderDetail.getItemModel(),
                    orderDetail.getItemName(),
                    orderDetail.getImageURL(),
                    orderDetail.getCustomerEmail(),
                    orderDetail.getPrice(),
                    orderDetail.getQty(),
                    orderDetail.getSubTotal()
            );
            alCustomers.add(orderDitailDto);
        }
        System.out.println("aaaaaaaaaaaaa"+ alCustomers);
        return alCustomers;
    }
}
