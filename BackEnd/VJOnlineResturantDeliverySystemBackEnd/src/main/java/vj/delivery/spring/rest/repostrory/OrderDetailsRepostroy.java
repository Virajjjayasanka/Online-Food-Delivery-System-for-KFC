package vj.delivery.spring.rest.repostrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vj.delivery.spring.rest.entity.OrderDetail;
import vj.delivery.spring.rest.entity.Orders;

import java.util.ArrayList;

public interface OrderDetailsRepostroy extends JpaRepository<OrderDetail, Integer> {


    @Query(value = "SELECT * FROM OrderDetail WHERE orders_oderID = ?1", nativeQuery = true)
    ArrayList<OrderDetail> getOrderList(int orders_oderID);
}
