package vj.delivery.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.RiderGetOrderDto;
import vj.delivery.spring.rest.service.RiderGetOrdrService;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/riderGetOrders")
public class RiderGetOrderController {

    @Autowired
    private RiderGetOrdrService riderGetOrdrService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRiderGetOrder(@RequestBody RiderGetOrderDto riderGetOrderDto) {
        return riderGetOrdrService.saveRiderGetOrder(riderGetOrderDto);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{riderGetOrderID}")
    private boolean deleteRiderGetOrder(@PathVariable int  riderGetOrderID) {
        return riderGetOrdrService.deleteRiderGetOrder(riderGetOrderID);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<RiderGetOrderDto> getAllRiderGetOrder() {
        return riderGetOrdrService.getAllRiderGetOrder();
    }

}
