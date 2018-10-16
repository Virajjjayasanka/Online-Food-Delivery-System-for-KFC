package vj.delivery.spring.rest.repostrory;

import org.springframework.data.jpa.repository.JpaRepository;
import vj.delivery.spring.rest.entity.Customerlogin;

public interface CustomerloginRepostory extends JpaRepository <Customerlogin, String> {
}
