package vj.delivery.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vj.delivery.spring.rest.dto.ItemDto;
import vj.delivery.spring.rest.service.ItemService;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/Items")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveItem(@RequestBody ItemDto itemDto) {
        System.out.println("controller"+itemDto);
        return service.saveItem(itemDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{itemModel}")
    private ArrayList<ItemDto> findByEmailAddress(@PathVariable String itemModel){
        return service.findByModel(itemModel);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ItemDto> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalItem(){
        return service.getTotalItem();
    }
}
