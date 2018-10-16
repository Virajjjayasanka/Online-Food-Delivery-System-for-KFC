package vj.delivery.spring.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vj.delivery.spring.rest.dto.OnlineRiderDto;
import vj.delivery.spring.rest.entity.OnlineRider;
import vj.delivery.spring.rest.repostrory.OnlineRiderRepostroy;
import vj.delivery.spring.rest.service.OnlineRiderService;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OnlineRiderServiceImpl implements OnlineRiderService{

    @Autowired
    private OnlineRiderRepostroy riderRepostroy;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveOnlineRider(OnlineRiderDto onlineRiderDto) {
        OnlineRider onlineRider = new OnlineRider(
                onlineRiderDto.getRiderName(),
                onlineRiderDto.getOnline(),
                onlineRiderDto.getDate(),
                onlineRiderDto.getTime());
        riderRepostroy.save(onlineRider);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteOnlirRider(String riderName) {
        riderRepostroy.deleteById(riderName);
        return true;
    }

    @Override
    public ArrayList<OnlineRiderDto> getAllRiders() {
        List<OnlineRider> onlineRiderList = riderRepostroy.findAll();
        ArrayList<OnlineRiderDto> riderDtoArrayList = new ArrayList<>();
        for (OnlineRider onlineRider : onlineRiderList) {
            OnlineRiderDto onlineRiderDto = new OnlineRiderDto(
                    onlineRider.getRiderName(),
                    onlineRider.getOnline(),
                    onlineRider.getDate(),
                    onlineRider.getTime());
            riderDtoArrayList.add(onlineRiderDto);
        }
        return riderDtoArrayList;
    }

    @Override
    public long getTotalAllRiders() {
        return riderRepostroy.getTotalAllRiders();
    }
}
