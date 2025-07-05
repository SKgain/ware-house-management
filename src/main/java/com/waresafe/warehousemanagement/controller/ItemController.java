package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.Item;
import com.waresafe.warehousemanagement.requestDTO.ItemRequestDTO;
import com.waresafe.warehousemanagement.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

//    add item
    @PostMapping("/add-item")
    public ResponseEntity<String> addItem(
            @RequestBody ItemRequestDTO itemDTO
    ){
        itemService
                .addItem(itemDTO);
        return
                ResponseEntity
                        .ok("Item added successfully");
    }
//    Get item
    @GetMapping("/get-all-item")
    public List<Item> getAllItem(){

        return
                itemService
                        .getAllItem();
    }
//    get item by id
    @GetMapping("/get-item/filter/{id}")
    public Item getItemById(
            @PathVariable int id
    ){
        return
                itemService
                        .getItemById(id);
    }
//    update item
    @PutMapping("/update-item/{id}")
    public ResponseEntity<String> updateItem(
            @PathVariable int id,
            @RequestBody ItemRequestDTO itemDTO
    ){
        itemService
                .updateItem(id, itemDTO);
        return
                ResponseEntity
                        .ok("Item updated successfully");
    }

//    delete item
    @DeleteMapping("/delete-item/{id}")
    public ResponseEntity<String> deleteItem(
            @PathVariable int id
    ){
        itemService
                .deleteItem(id);
        return
                ResponseEntity
                        .ok("Item deleted successfully");
    }
}
