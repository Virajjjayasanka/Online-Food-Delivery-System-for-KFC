package vj.delivery.spring.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.OnlineRiderDto;
import vj.delivery.spring.rest.service.OnlineRiderService;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/OnlineRiders")
public class OnlineRiderController {

    @Autowired
    private OnlineRiderService onlineRiderService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveOnlieRider(@RequestBody OnlineRiderDto onlineRiderDto) {
//        System.out.println("controller"+itemDto);
        return onlineRiderService.saveOnlineRider(onlineRiderDto);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{riderName}")
    private boolean deleteOnlieRider(@PathVariable String  riderName) {
        return onlineRiderService.deleteOnlirRider(riderName);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<OnlineRiderDto> getAllCustomers() {
        return onlineRiderService.getAllRiders();
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalRiders(){
        return onlineRiderService.getTotalAllRiders();
    }
}
