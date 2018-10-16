package vj.delivery.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.OrderDitailDto;
import vj.delivery.spring.rest.dto.OrderDto;
import vj.delivery.spring.rest.dto.SelectedItemDto;
import vj.delivery.spring.rest.service.OderService;

import java.awt.*;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/Orders")
public class OrderController {

    @Autowired
    private OderService oderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addOrder(@RequestBody OrderDto orderDto){
        return oderService.addOrder(orderDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{customer_id}")
    private ArrayList<OrderDto> getOrders(@PathVariable int customer_id) {
//        System.out.println("Order controlwe Iml get"+customer_id  );
        return oderService.getOrders(customer_id);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{oderID}")
    private boolean deleteOrder(@PathVariable int oderID) {
        return oderService.deleteOrder(oderID);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<OrderDto> getAllOrders() {
        return oderService.getAllOrders();
    }

//    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
//    public long getTotalOrder(){
//        return oderService.getTotalOrder();
//    }


//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/selectCustomerOrder")
//    private ArrayList<OrderDitailDto> getOrdersCutomerList(@RequestParam("customerEmail") String customerEmail, @RequestParam("oderIDss") int oderID) {
//        System.out.println("customerGmail : " + customerEmail + "/" + "itemModel : " + oderID);
//        return oderService.getOrdersCutomerList(customerEmail,oderID);
//    }

    @PatchMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateSelectItem(@RequestBody OrderDto orderDto) {
        System.out.println("/update : dto : " + orderDto);
        return oderService.updateSelectItem(orderDto);
    }

}
