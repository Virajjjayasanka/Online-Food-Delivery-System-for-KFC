package vj.delivery.spring.rest.repostrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vj.delivery.spring.rest.entity.Riderlogin;

import java.util.ArrayList;

public interface RiderLoginRepostroy extends JpaRepository<Riderlogin, Integer> {

    @Query(value = "SELECT * FROM Riderlogin WHERE username = ?1", nativeQuery = true)
    ArrayList<Riderlogin> findByEmailAddress(String username);

    @Query("SELECT count (G.rideid) FROM Riderlogin G")
    long  getTotalRiders();

}
