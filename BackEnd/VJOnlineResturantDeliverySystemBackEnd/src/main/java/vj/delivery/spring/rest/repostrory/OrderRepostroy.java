package vj.delivery.spring.rest.repostrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vj.delivery.spring.rest.entity.OrderDetail;
import vj.delivery.spring.rest.entity.Orders;


import java.util.ArrayList;

public interface OrderRepostroy extends JpaRepository<Orders, Integer> {

    @Query(value = "SELECT * FROM Orders WHERE customer_id = ?1", nativeQuery = true)
    ArrayList<Orders> getOrders(int customer_id);

    @Query("SELECT count (G.oderID) FROM Orders G WHERE customer_id = ?1")
    long  getTotalOrder(int customer_id);

    @Query(value = "SELECT * FROM Orders WHERE caption = ?1", nativeQuery = true)
    ArrayList<Orders> getOrderDilver(String caption);
//    @Query(value = "SELECT * FROM OrderDetail WHERE customerEmail = ?1 AND orders_oderID = ?2", nativeQuery = true)
//    ArrayList<OrderDetail> getOrdersCutomerList(String customerEmail, int orders_oderID);

}
