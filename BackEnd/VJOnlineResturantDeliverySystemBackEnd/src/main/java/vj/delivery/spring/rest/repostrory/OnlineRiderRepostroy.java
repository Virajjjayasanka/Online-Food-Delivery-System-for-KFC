package vj.delivery.spring.rest.repostrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vj.delivery.spring.rest.entity.OnlineRider;

public interface OnlineRiderRepostroy  extends JpaRepository<OnlineRider, String> {

    @Query("SELECT count (r.riderName) FROM OnlineRider r")
    long  getTotalAllRiders();


}
