package vj.delivery.spring.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vj.delivery.spring.rest.dto.customerFeedbackDto;
import vj.delivery.spring.rest.entity.FeedBack;
import vj.delivery.spring.rest.repostrory.FeedBackRepostroy;
import vj.delivery.spring.rest.service.Feedbackservice;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FeedbackServeImpl implements Feedbackservice {

    @Autowired
    private FeedBackRepostroy repository;


    @Override
    public ArrayList<customerFeedbackDto> getAllCustomersFeedbck() {
        List<FeedBack> feedBackList = repository.findAll();
        ArrayList<customerFeedbackDto> alCustomers = new ArrayList<>();
        for (FeedBack FeedBack : feedBackList) {
            customerFeedbackDto customerFeedbackDto = new customerFeedbackDto(
                    FeedBack.getFID(),
                    FeedBack.getGmail(),
                    FeedBack.getCustomerName(),
                    FeedBack.getTeleponeNo(),
                    FeedBack.getUverFeedBack(),
                    FeedBack.getSuggesant(),
                    FeedBack.getDate()
            );
            alCustomers.add(customerFeedbackDto);
        }
        return alCustomers;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteFedback(int FID) {
        repository.deleteById(FID);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveFedback(customerFeedbackDto customerFeedbackDto) {
        FeedBack feedBack1 = new FeedBack(customerFeedbackDto.getGmail(), customerFeedbackDto.getCustomerName(),customerFeedbackDto.getTeleponeNo(),customerFeedbackDto.getUverFeedBack(),customerFeedbackDto.getSuggesant(),customerFeedbackDto.getDate());
        repository.save(feedBack1);
        return true;
    }

    @Override
    public long getTotalFeedBcak() {
        return repository.getTotalFeedBcak();
    }

    @Override
    public  ArrayList<customerFeedbackDto> findByEmailAddress(String gmail) {
        List<FeedBack> feedBackList = repository.findByEmailAddress(gmail);
        ArrayList<customerFeedbackDto> alCustomers = new ArrayList<>();
        for (FeedBack FeedBack : feedBackList) {
            customerFeedbackDto customerFeedbackDto = new customerFeedbackDto(
                    FeedBack.getFID(),
                    FeedBack.getGmail(),
                    FeedBack.getCustomerName(),
                    FeedBack.getTeleponeNo(),
                    FeedBack.getUverFeedBack(),
                    FeedBack.getSuggesant(),
                    FeedBack.getDate()
            );
            alCustomers.add(customerFeedbackDto);
        }
        return alCustomers;
    }

//    @Override
//    public ArrayList<customerFeedbackDto> findByGmail(String gamil) {
//        List<FeedBack> feedBackList = repository.findByGmail(gamil);
//        ArrayList<customerFeedbackDto> alCustomers = new ArrayList<>();
//        for (FeedBack FeedBack : feedBackList) {
//            customerFeedbackDto customerFeedbackDto = new customerFeedbackDto(
//                    FeedBack.getFID(),
//                    FeedBack.getGmail(),
//                    FeedBack.getCustomerName(),
//                    FeedBack.getTeleponeNo(),
//                    FeedBack.getUverFeedBack(),
//                    FeedBack.getSuggesant(),
//                    FeedBack.getDate()
//            );
//            alCustomers.add(customerFeedbackDto);
//        }
//        return alCustomers;
//    }

//    @Override
//    public String findTitleById(String gamil) {
//        return repository.findTitleById(gamil);
//    }


}
