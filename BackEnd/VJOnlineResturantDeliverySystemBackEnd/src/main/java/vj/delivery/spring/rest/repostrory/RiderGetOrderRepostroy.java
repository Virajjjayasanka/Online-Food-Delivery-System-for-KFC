package vj.delivery.spring.rest.repostrory;

import org.springframework.data.jpa.repository.JpaRepository;
import vj.delivery.spring.rest.entity.RiderGetOrder;


public interface RiderGetOrderRepostroy  extends JpaRepository<RiderGetOrder, Integer> {
}
