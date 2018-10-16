package vj.delivery.spring.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vj.delivery.spring.rest.dto.ItemDto;
import vj.delivery.spring.rest.entity.Item;
import vj.delivery.spring.rest.repostrory.ItemRepostroy;
import vj.delivery.spring.rest.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepostroy repository;

    @Override
    public ArrayList<ItemDto> getAllItems() {
        List<Item> itemList = repository.findAll();
        ArrayList<ItemDto> alItem = new ArrayList<>();
        for (Item item : itemList) {
            ItemDto itemDto = new ItemDto(
                    item.getItemId(),
                    item.getItemImage(),
                    item.getItemName(),
                    item.getItemprice(),
                    item.getItemModel(),
                    item.getDiscription(),
                    item.getDate(),
                    item.getTime()
            );
            alItem.add(itemDto);
        }
        return alItem;

    }

    @Override
    public boolean deleteCustomer(int itemId) {
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveItem(ItemDto itemDto) {
        Item item = new Item(
                itemDto.getItemImage(),
                itemDto.getItemName(),
                itemDto.getItemprice(),
                itemDto.getItemModel(),
                itemDto.getDiscription(),
                itemDto.getDate(),
                itemDto.getTime());
        System.out.println("Service Impl"+item);
        repository.save(item);
        return true;
    }

    @Override
    public ArrayList<ItemDto> findByModel(String itemModel) {
        List<Item> itemList = repository.findByEmailAddress(itemModel);
        ArrayList<ItemDto> alItem = new ArrayList<>();
        for (Item item : itemList) {
            ItemDto itemDto = new ItemDto(
                    item.getItemId(),
                    item.getItemImage(),
                    item.getItemName(),
                    item.getItemprice(),
                    item.getItemModel(),
                    item.getDiscription(),
                    item.getDate(),
                    item.getTime()
            );
            alItem.add(itemDto);
        }
        return alItem;
    }

    @Override
    public long getTotalItem() {
    return repository.getTotalItem();
    }
}
