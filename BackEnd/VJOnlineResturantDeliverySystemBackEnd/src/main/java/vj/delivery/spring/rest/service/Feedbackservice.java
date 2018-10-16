package vj.delivery.spring.rest.service;

import vj.delivery.spring.rest.dto.customerFeedbackDto;

import java.util.ArrayList;

public interface Feedbackservice {

    public ArrayList<customerFeedbackDto> getAllCustomersFeedbck();

//    public customerFeedbackDto getFeedback(String gmail);

    public boolean deleteFedback(int FID);

    public boolean saveFedback(customerFeedbackDto customerFeedbackDto);

    public long getTotalFeedBcak();

    public ArrayList<customerFeedbackDto> findByEmailAddress(String gmail);
//

//    public List<customerFeedbackDto>SearchFeedback(String gmail);

//    public List<customerFeedbackDto>SearchCustomerDetails(String name);

}
