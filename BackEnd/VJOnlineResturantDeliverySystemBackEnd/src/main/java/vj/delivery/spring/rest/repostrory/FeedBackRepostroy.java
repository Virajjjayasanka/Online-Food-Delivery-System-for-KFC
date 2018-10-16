package vj.delivery.spring.rest.repostrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vj.delivery.spring.rest.entity.FeedBack;

import java.util.ArrayList;

public interface FeedBackRepostroy extends JpaRepository<FeedBack, Integer> {

    @Query("SELECT count (F.FID) FROM FeedBack F")
    long getTotalFeedBcak();




    @Query(value = "SELECT * FROM feedBack WHERE Gmail = ?1", nativeQuery = true)
    ArrayList<FeedBack> findByEmailAddress(String gmail);

//    @Query("SELECT t FROM FeedBack t WHERE t.gmail = 'title'")
//    public List<FeedBack> findById(String g);

//    String findTitleById(@Param("id") Long id);
}
