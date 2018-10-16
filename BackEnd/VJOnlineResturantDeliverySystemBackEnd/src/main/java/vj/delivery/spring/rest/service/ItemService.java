package vj.delivery.spring.rest.service;

import vj.delivery.spring.rest.dto.ItemDto;

import java.util.ArrayList;

public interface ItemService {

    public ArrayList<ItemDto> getAllItems();

//    public CustomerDto getCustomer(String gamil);

    public boolean deleteCustomer(int itemId);

    public boolean saveItem(ItemDto itemDto);

    public ArrayList<ItemDto> findByModel(String  itemModel);

    public long  getTotalItem();
}
