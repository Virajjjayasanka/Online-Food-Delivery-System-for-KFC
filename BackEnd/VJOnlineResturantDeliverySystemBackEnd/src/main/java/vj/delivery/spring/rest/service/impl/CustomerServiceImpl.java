package vj.delivery.spring.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vj.delivery.spring.rest.dto.CustomerDto;
import vj.delivery.spring.rest.entity.Customer;
import vj.delivery.spring.rest.repostrory.CustomerRepostroy;
import vj.delivery.spring.rest.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepostroy repository;


    @Override
    public ArrayList<CustomerDto> getAllCustomers() {

        List<Customer> customerList = repository.findAll();
        ArrayList<CustomerDto> alCustomers = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDto CustomerDto = new CustomerDto(
                    customer.getId(),
                    customer.getEmail(),
                    customer.getPassword(),
                    customer.getRedowPasswod(),
                    customer.getTeleponeNO(),
                    customer.getFullName(),
                    customer.getDistriac(),
                    customer.getAddress(),
                    customer.getYoumanssge(),
                    customer.getCustomerImage()
            );
            alCustomers.add(CustomerDto);
        }
        return alCustomers;
    }

    @Override
    public CustomerDto getCustomer(int id) {
        Customer customer = repository.findById(id).get();
        CustomerDto CustomerDto = new CustomerDto(
                customer.getId(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getRedowPasswod(),
                customer.getTeleponeNO(),
                customer.getFullName(),
                customer.getDistriac(),
                customer.getAddress(),
                customer.getYoumanssge(),
                customer.getCustomerImage()
        );
        return CustomerDto;
    }

    @Override
    public boolean deleteCustomer(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveCustomer(CustomerDto customer) {
        Customer customer1 = new Customer(
                customer.getId(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getRedowPasswod(),
                customer.getTeleponeNO(),
                customer.getFullName(),
                customer.getDistriac(),
                customer.getAddress(),
                customer.getYoumanssge(),
                customer.getCustomerImage()
        );

        repository.save(customer1);
        return true;

    }

    @Override
    public boolean canAuthenticate(String email, String password) {
        List<Customer> customerList = repository.findByEmailAddress(email);
        for (Customer customer : customerList){
            if(password.equals(customer.getPassword()))
                return true;
        }
        return false;
//        Customer customerlogin = repository.findById(id).get();
//        return customerlogin.getPassword().equals(password);
    }

    @Override
    public ArrayList<CustomerDto> findByEmailAddress(String email) {
        List<Customer> customerList = repository.findByEmailAddress(email);
        ArrayList<CustomerDto> alCustomers = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDto CustomerDto = new CustomerDto(
                    customer.getId(),
                    customer.getEmail(),
                    customer.getPassword(),
                    customer.getRedowPasswod(),
                    customer.getTeleponeNO(),
                    customer.getFullName(),
                    customer.getDistriac(),
                    customer.getAddress(),
                    customer.getYoumanssge(),
                    customer.getCustomerImage()
            );
            alCustomers.add(CustomerDto);
        }
        return alCustomers;
    }


    @Override
    public long getTotalCustomer() {
        return repository.getTotalCustomer();
    }

}
