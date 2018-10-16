package vj.delivery.spring.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vj.delivery.spring.rest.dto.RiderGetOrderDto;
import vj.delivery.spring.rest.entity.RiderGetOrder;
import vj.delivery.spring.rest.repostrory.RiderGetOrderRepostroy;
import vj.delivery.spring.rest.service.RiderGetOrdrService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiderGetOrderServiceImpl implements RiderGetOrdrService{

    @Autowired
    private RiderGetOrderRepostroy repository;

    @Override
    public boolean saveRiderGetOrder(RiderGetOrderDto riderGetOrderDto) {
        RiderGetOrder riderGetOrder = new RiderGetOrder(
                riderGetOrderDto.getOderID(),
                riderGetOrderDto.getCustomerID(),
                riderGetOrderDto.getRiderName(),
                riderGetOrderDto.getTotal(),
                riderGetOrderDto.getPayament(),
                riderGetOrderDto.getPaymentModel(),
                riderGetOrderDto.getDate());
        repository.save(riderGetOrder);
        return true;
    }

    @Override
    public boolean deleteRiderGetOrder(int getRiderGetOrderID) {
        repository.deleteById(getRiderGetOrderID);
        return true;
    }

    @Override
    public ArrayList<RiderGetOrderDto> getAllRiderGetOrder() {
        List<RiderGetOrder> riderGetOrderList = repository.findAll();
        ArrayList<RiderGetOrderDto> orderDtoArrayList = new ArrayList<>();
        for (RiderGetOrder getOrder : riderGetOrderList) {
            RiderGetOrderDto riderGetOrderDto = new RiderGetOrderDto(
                   getOrder.getRiderGetOrderID(),
                    getOrder.getOderID(),
                    getOrder.getCustomerID(),
                    getOrder.getRiderName(),
                    getOrder.getTotal(),
                    getOrder.getPayament(),
                    getOrder.getPaymentModel(),
                    getOrder.getDate()
            );
            orderDtoArrayList.add(riderGetOrderDto);
        }
        return orderDtoArrayList;
    }


}
