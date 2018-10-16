package vj.delivery.spring.rest.repostrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vj.delivery.spring.rest.entity.Customer;

import java.util.ArrayList;

    public interface CustomerRepostroy extends JpaRepository<Customer, Integer> {

    @Query("SELECT count (G.email) FROM Customer G")
    long  getTotalCustomer();

    @Query(value = "SELECT * FROM customer WHERE email = ?1", nativeQuery = true)
    ArrayList<Customer> findByEmailAddress(String email);


}
