package vj.delivery.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.customerFeedbackDto;
import vj.delivery.spring.rest.service.Feedbackservice;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/feedBacks")
public class FeedBackController {

    @Autowired
    private Feedbackservice service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<customerFeedbackDto> getAllCustomers() {
        return service.getAllCustomersFeedbck();
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{FID}")
    private boolean deleteFedback(@PathVariable int  FID) {
        return service.deleteFedback(FID);
    }

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
//    private customerFeedbackDto getFeedBack(@PathVariable String id){
//        return service.getFeedback(id);
//    }
//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public customerFeedbackDto getFeedbackDto(@PathVariable("id") String gmail) {
//        return service.getFeedback(gmail);
//    }
//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public customerFeedbackDto getFeedbackDto(@PathVariable("id") String gmail) {
//        return service.getFeedback(gmail);
//    }


//     @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{gamil}")
//        public ArrayList<customerFeedbackDto> SearchCustomerDetails(@PathVariable String gamil) throws Exception {
//            return (ArrayList<customerFeedbackDto>) service.SearchCustomerDetails(gamil);
//        }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean savefeedback(@RequestBody customerFeedbackDto customerFeedbackDto) {

        return service.saveFedback(customerFeedbackDto);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getfeedBaclCount(){
        return service.getTotalFeedBcak();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{gmail}")
    private ArrayList<customerFeedbackDto> findByEmailAddress(@PathVariable String gmail){
         return service.findByEmailAddress(gmail);
    }
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{gmail}")
//    private CustomerDto getFeedBack(@PathVariable String gmail){
//        return service.getCustomer(gmail);
//    }
}
