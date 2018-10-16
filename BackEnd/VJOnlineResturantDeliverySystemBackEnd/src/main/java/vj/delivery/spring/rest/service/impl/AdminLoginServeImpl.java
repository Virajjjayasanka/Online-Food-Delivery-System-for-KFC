package vj.delivery.spring.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vj.delivery.spring.rest.entity.AdminLogin;
import vj.delivery.spring.rest.repostrory.AdminLoginRepostory;
import vj.delivery.spring.rest.service.AdminLoginService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class AdminLoginServeImpl implements AdminLoginService {

   @Autowired
   private AdminLoginRepostory adminLoginRepostory;

    @Override
    public boolean canAuthenticate(String gmail, String password) {

        boolean exists = adminLoginRepostory.existsById(gmail);
        if (!exists){
            return false;
        }
        AdminLogin adminLogin = adminLoginRepostory.findById(gmail).get();
        return adminLogin.getPassword().equals(password);
    }

}
