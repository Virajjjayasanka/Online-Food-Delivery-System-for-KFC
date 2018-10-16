package vj.delivery.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.RiderLoginDto;
import vj.delivery.spring.rest.service.RiderLoginService;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/Riders")

public class LoginRiderController{

    @Autowired
    private RiderLoginService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRider(@RequestBody RiderLoginDto RiderLoginDto) {
        System.out.println("controller"+ RiderLoginDto);
        return service.saveRiders(RiderLoginDto);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<RiderLoginDto> getAllRider() {
        return service.getAllRiders();
    }


    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    private boolean deleteCustomer(@PathVariable int email) {
        return service.deleteRiders(email);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalRiders(){
        return service.getTotalRiders();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{username}")
    private ArrayList<RiderLoginDto> findByEmailAddress(@PathVariable String username){
        return service.findByEmailAddress(username);
    }

}
