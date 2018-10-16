package vj.delivery.spring.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vj.delivery.spring.rest.dto.RiderLoginDto;
import vj.delivery.spring.rest.entity.Riderlogin;
import vj.delivery.spring.rest.repostrory.RiderLoginRepostroy;
import vj.delivery.spring.rest.service.RiderLoginService;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RiderLoginServiceImpl implements RiderLoginService{

    @Autowired
    private RiderLoginRepostroy repository;

    @Override
    public boolean canAuthenticate(String username, String password) {
        ArrayList<Riderlogin> riderlist = repository.findByEmailAddress(username);
        for (Riderlogin riderlogin : riderlist){
            if(password.equals(riderlogin.getPassword()))
                return true;
        }
        return false;
    }


    @Override
    public ArrayList<RiderLoginDto> getAllRiders() {
        List<Riderlogin> list = repository.findAll();
        ArrayList<RiderLoginDto> alRiders = new ArrayList<>();
        for (Riderlogin riderlogin : list) {
            RiderLoginDto riderLoginDto = new RiderLoginDto(
                    riderlogin.getRideid(),
                    riderlogin.getRidername(),
                    riderlogin.getAddress(),
                    riderlogin.getTeleponeNo(),
                    riderlogin.getUsername(),
                    riderlogin.getPassword(),
                    riderlogin.getImageUrl()
            );
            alRiders.add(riderLoginDto);
        }
        return alRiders;
    }

    @Override
    public RiderLoginDto getRiders(int id) {
        return null;
    }

    @Override
    public boolean deleteRiders(int id) {
        return false;
    }

    @Override
    public boolean saveRiders(RiderLoginDto rider) {
        Riderlogin riderlogin = new Riderlogin(
                rider.getRideid(),
                rider.getRidername(),
                rider.getAddress(),
                rider.getTeleponeNo(),
                rider.getUsername(),
                rider.getPassword(),
                rider.getImageUrl());
        repository.save(riderlogin);
        return true;
    }

    @Override
    public ArrayList<RiderLoginDto> findByEmailAddress(String username) {
        List<Riderlogin> list = repository.findByEmailAddress(username);
        ArrayList<RiderLoginDto> alRiders = new ArrayList<>();
        for (Riderlogin riderlogin : list) {
            RiderLoginDto riderLoginDto = new RiderLoginDto(
                    riderlogin.getRideid(),
                    riderlogin.getRidername(),
                    riderlogin.getAddress(),
                    riderlogin.getTeleponeNo(),
                    riderlogin.getUsername(),
                    riderlogin.getPassword(),
                    riderlogin.getImageUrl()
            );
            alRiders.add(riderLoginDto);
        }
        return alRiders;
    }

    @Override
    public long getTotalRiders() {
        return repository.getTotalRiders();
    }
}
