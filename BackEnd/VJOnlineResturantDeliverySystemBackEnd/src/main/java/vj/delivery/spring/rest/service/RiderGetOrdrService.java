package vj.delivery.spring.rest.service;


import vj.delivery.spring.rest.dto.RiderGetOrderDto;

import java.util.ArrayList;

public interface RiderGetOrdrService {

    public boolean saveRiderGetOrder(RiderGetOrderDto riderGetOrderDto);

    public boolean deleteRiderGetOrder(int riderOrdersID);

    public ArrayList<RiderGetOrderDto> getAllRiderGetOrder();

}
