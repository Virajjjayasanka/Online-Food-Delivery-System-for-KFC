package vj.delivery.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.SelectedItemDto;
import vj.delivery.spring.rest.service.SelectedItemService;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/SelectItems")
public class SelectItemController {


    @Autowired
    private SelectedItemService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveSelectItem(@RequestBody SelectedItemDto selectedItemDto) {
        return service.saveSelectItem(selectedItemDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{customerGmail}")
    private ArrayList<SelectedItemDto> selectedItem(@PathVariable String customerGmail) {
        return service.customerSelectItem(customerGmail);

    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{selectItemID}")
    private boolean deleteSelectItem(@PathVariable int selectItemID) {
        return service.DelectSelectItem(selectItemID);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/selectedItemModelCustomer")
    private ArrayList<SelectedItemDto> selectedItemModelCustomer(@RequestParam("customerGmail") String customerGmail, @RequestParam("itemModel") String itemModel) {
        System.out.println("customerGmail : " + customerGmail + "/" + "itemModel : " + itemModel);
        return service.customerSelectItemModel(customerGmail, itemModel);
    }

//    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{customerGmail}")
//    private boolean deleteSelectItemCustomer(@PathVariable String customerGmail) {
//        System.out.println("customerGmail Delete Qure  : " +customerGmail) ;
//        return service.customerSelectItemDelete(customerGmail);
//    }
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public boolean saveSelectItem(@RequestBody SelectedItemDto selectedItemDto) {
//        return service.updateQtry(qty,selectItemID);
//    }

    @PatchMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateSelectItem(@RequestBody SelectedItemDto selectedItemDto) {
        System.out.println("/update : dto : " + selectedItemDto);
        return service.updateSelectItem(selectedItemDto);
    }

  }
