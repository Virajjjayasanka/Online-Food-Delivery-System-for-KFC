package vj.delivery.spring.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vj.delivery.spring.rest.entity.Customerlogin;
import vj.delivery.spring.rest.repostrory.CustomerloginRepostory;
import vj.delivery.spring.rest.service.CustomerloginService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class CustomerloginServiceImpl implements CustomerloginService {


    @Autowired
    private CustomerloginRepostory customerloginRepostory;

    @Override
    public boolean canAuthenticate(String gmail, String password) {
        boolean exists = customerloginRepostory.existsById(gmail);

        if (!exists){
            return false;
        }

        Customerlogin Customerlogin = customerloginRepostory.findById(gmail).get();

        return Customerlogin.getPassword().equals(password);
    }
}
