package vj.delivery.spring.rest.service;

import vj.delivery.spring.rest.dto.SelectedItemDto;

import java.util.ArrayList;

public interface SelectedItemService  {

    public boolean saveSelectItem(SelectedItemDto selectedItemDto);

    public boolean DelectSelectItem(int selectItemID);

    public ArrayList<SelectedItemDto> customerSelectItem(String customerGmail);

    public ArrayList<SelectedItemDto> customerSelectItemModel(String customerGmail , String itemModel);

//    public  boolean  customerSelectItemDelete(String customerGmail);
    public long  customerTotalCount(String customerGmail);

    public boolean  updateQtry(int qty, int selectItemID);

    public boolean updateSelectItem(SelectedItemDto selectedItemDto);


}
