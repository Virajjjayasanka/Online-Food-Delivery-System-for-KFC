package vj.delivery.spring.rest.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vj.delivery.spring.rest.dto.SelectedItemDto;
import vj.delivery.spring.rest.entity.SelectItem;
import vj.delivery.spring.rest.repostrory.SelectedItemRepostory;
import vj.delivery.spring.rest.service.SelectedItemService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SelectItemServiceImpl implements SelectedItemService {

    @Autowired
    private SelectedItemRepostory repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveSelectItem(SelectedItemDto selectedItemDto) {
        SelectItem selectItem = new SelectItem(
                selectedItemDto.getCustomerGmail(),
                selectedItemDto.getItemModel(),
                selectedItemDto.getItemName(),
                selectedItemDto.getImageURL(),
                selectedItemDto.getPrice(),
                selectedItemDto.getQty(),
                selectedItemDto.getSubTotal());
        repository.save(selectItem);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean DelectSelectItem(int selectItemID) {
        repository.deleteById(selectItemID);
        return true;
    }

    @Override
    public ArrayList<SelectedItemDto> customerSelectItem(String customerGmail) {
        List<SelectItem> itemList = repository.customerSelectItem(customerGmail);
        ArrayList<SelectedItemDto> alItem = new ArrayList<>();
        for (SelectItem item : itemList) {
            SelectedItemDto itemDto = new SelectedItemDto(
                    item.getSelectItemID(),
                    item.getCustomerGmail(),
                    item.getItemModel(),
                    item.getItemName(),
                    item.getImageURL(),
                    item.getPrice(),
                    item.getQty(),
                    item.getSubTotal());
            alItem.add(itemDto);
        }
        return alItem;
    }

    @Override
    public ArrayList<SelectedItemDto> customerSelectItemModel(String customerGmail, String itemModel) {
        List<SelectItem> itemList = repository.customerSelectItemModel(customerGmail, itemModel);
        ArrayList<SelectedItemDto> alItem = new ArrayList<>();
        for (SelectItem item : itemList) {
            SelectedItemDto itemDto = new SelectedItemDto(
                    item.getSelectItemID(),
                    item.getCustomerGmail(),
                    item.getItemModel(),
                    item.getItemName(),
                    item.getImageURL(),
                    item.getPrice(),
                    item.getQty(),
                    item.getSubTotal());
            alItem.add(itemDto);
//            System.out.println("Service Impl Select Item :" + alItem );
        }
        return alItem;
    }

    @Override
    public long customerTotalCount(String customerGmail) {
        return 0;
    }

    @Override
    public boolean updateQtry(int qty, int selectItemID) {
        repository.updateQtry(qty, selectItemID);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateSelectItem(SelectedItemDto selectedItemDto) {
        SelectItem selectItem = new SelectItem(
                selectedItemDto.getSelectItemID(),
                selectedItemDto.getCustomerGmail(),
                selectedItemDto.getItemModel(),
                selectedItemDto.getItemName(),
                selectedItemDto.getImageURL(),
                selectedItemDto.getPrice(),
                selectedItemDto.getQty(),
                selectedItemDto.getSubTotal());
        repository.saveAndFlush(new SelectItem(
                selectedItemDto.getSelectItemID(),
                selectedItemDto.getCustomerGmail(),
                selectedItemDto.getItemModel(),
                selectedItemDto.getItemName(),
                selectedItemDto.getImageURL(),
                selectedItemDto.getPrice(),
                selectedItemDto.getQty(),
                selectedItemDto.getSubTotal()));

        return true;
    }
}
