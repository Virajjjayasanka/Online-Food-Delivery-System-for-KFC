package vj.delivery.spring.rest.service;

import vj.delivery.spring.rest.dto.OnlineRiderDto;

import java.util.ArrayList;

public interface OnlineRiderService {

    public boolean saveOnlineRider(OnlineRiderDto onlineRiderDto);

    public boolean deleteOnlirRider(String riderName);

    public ArrayList<OnlineRiderDto> getAllRiders();

    public  long  getTotalAllRiders();
}
