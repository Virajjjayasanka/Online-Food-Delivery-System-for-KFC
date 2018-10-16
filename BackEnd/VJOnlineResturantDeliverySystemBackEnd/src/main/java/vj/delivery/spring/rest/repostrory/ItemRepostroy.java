package vj.delivery.spring.rest.repostrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vj.delivery.spring.rest.entity.Item;

import java.util.ArrayList;


public interface ItemRepostroy extends JpaRepository<Item, Integer> {


    @Query(value = "SELECT * FROM Item WHERE itemModel = ?1", nativeQuery = true)
    ArrayList<Item> findByEmailAddress(String itemModel);

    @Query("SELECT count (I.itemId) FROM Item I")
    long  getTotalItem();

}
