package vj.delivery.spring.rest.service;

import vj.delivery.spring.rest.dto.CustomerDto;

import java.util.ArrayList;

public interface CustomerService {

    public ArrayList<CustomerDto> getAllCustomers();

    public CustomerDto getCustomer(int id);

    public boolean deleteCustomer(int id);

    public boolean saveCustomer(CustomerDto customer);

    boolean canAuthenticate(String email, String password);

    public ArrayList<CustomerDto> findByEmailAddress(String email);

    public long  getTotalCustomer();
}
