package vj.delivery.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.OrderDitailDto;
import vj.delivery.spring.rest.service.OderDetailService;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/OrderDitals")
public class OrderDetailsController {

    @Autowired
    private OderDetailService oderDetailService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{orders_oderID}")
    private ArrayList<OrderDitailDto> getOrderList(@PathVariable int orders_oderID) {
        return oderDetailService.getOrderList(orders_oderID);
    }
}
