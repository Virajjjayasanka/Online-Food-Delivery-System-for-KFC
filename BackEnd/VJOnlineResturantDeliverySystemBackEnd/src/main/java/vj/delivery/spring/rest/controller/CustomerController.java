package vj.delivery.spring.rest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.CustomerDto;
import vj.delivery.spring.rest.service.CustomerService;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCustomer(@RequestBody CustomerDto CustomerDto) {
        System.out.println("controller"+ CustomerDto);
        return service.saveCustomer(CustomerDto);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDto> getAllCustomers() {
        return service.getAllCustomers();
    }



//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{gmail}")
//    private CustomerDto getCustomer(@PathVariable String gmail){
//        return service.getCustomer(gmail);
//    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    private boolean deleteCustomer(@PathVariable int email) {
        return service.deleteCustomer(email);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalCustomer(){
        return service.getTotalCustomer();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{email}")
    private ArrayList<CustomerDto> findByEmailAddress(@PathVariable String email){
        return service.findByEmailAddress(email);
    }
}