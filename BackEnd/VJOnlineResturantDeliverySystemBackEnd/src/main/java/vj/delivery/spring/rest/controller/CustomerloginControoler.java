package vj.delivery.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.CustomerDto;
import vj.delivery.spring.rest.service.CustomerService;


@RestController
@CrossOrigin
public class CustomerloginControoler {

    @Autowired
    private CustomerService service;

    @PostMapping(value="api/v1/login", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
            public boolean canAuthenticate(@RequestBody CustomerDto user){
            return service.canAuthenticate(user.getEmail(), user.getPassword());

    }

}
