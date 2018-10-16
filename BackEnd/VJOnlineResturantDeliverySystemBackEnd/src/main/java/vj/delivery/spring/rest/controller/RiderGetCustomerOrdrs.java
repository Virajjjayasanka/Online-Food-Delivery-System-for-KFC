package vj.delivery.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.OrderDto;
import vj.delivery.spring.rest.service.OderService;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/customerAllOrdrs")
public class RiderGetCustomerOrdrs {

    @Autowired
    private OderService oderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{caption}")
    private ArrayList<OrderDto> getOrdersDeliver(@PathVariable String caption) {
        return oderService.getOrderDilver(caption);
    }
}
