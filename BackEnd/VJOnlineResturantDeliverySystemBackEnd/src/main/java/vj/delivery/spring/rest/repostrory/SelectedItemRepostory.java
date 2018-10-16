package vj.delivery.spring.rest.repostrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vj.delivery.spring.rest.entity.SelectItem;

import java.util.ArrayList;

public interface SelectedItemRepostory extends JpaRepository<SelectItem, Integer> {

    @Query(value = "SELECT * FROM SelectItem WHERE customerGmail = ?1", nativeQuery = true)
    ArrayList<SelectItem> customerSelectItem(String customerGmail);


    @Query(value = "SELECT * FROM SelectItem WHERE customerGmail = ?1 AND itemModel = ?2", nativeQuery = true)
    ArrayList<SelectItem> customerSelectItemModel(String customerGmail, String itemModel);


    @Query(value = "UPDATE SelectItem SET qty = ?1 WHERE selectItemID = ?2", nativeQuery = true)
    boolean updateQtry(int qty, int selectItemID);

//    @Query(value = "DELETE FROM SelectItem WHERE customerGmail = ?1", nativeQuery = true)
//    boolean  customerSelectItemDelete(String customerGmail);

//    @Query(value = "SELECT Sum(subTotal) AS Total FROM selectitem  WHERE customerGmail = ?1", nativeQuery = true)
//    long customerTotalCount(String customerGmail);



//    UPDATE CUSTOMERS
//    SET ADDRESS = 'Pune'
//    WHERE ID = 6



}
