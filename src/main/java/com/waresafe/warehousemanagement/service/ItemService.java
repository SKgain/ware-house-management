package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.Item;
import com.waresafe.warehousemanagement.entity.Supplier;
import com.waresafe.warehousemanagement.repository.ItemRepository;
import com.waresafe.warehousemanagement.repository.SupplierRepository;
import com.waresafe.warehousemanagement.requestDTO.ItemRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final SupplierRepository supplierRepository;

//    add item
    public void addItem(
            ItemRequestDTO itemDTO
    ){
        Item item = new Item();
        Supplier supplier = supplierRepository
                .findById(itemDTO.getSupplierId())
                .orElseThrow(()->new RuntimeException("Supplier not found"));
        item
                .setSku(itemDTO.getSku());
        item
                .setUnitPrice(itemDTO.getPrice());
        item
                .setName(itemDTO.getName());
        item
                .setDescription(itemDTO.getDescription());
        item
                .setSupplier(supplier);
        itemRepository
                .save(item);
    }
//    get all item
    public List<Item> getAllItem() {
        return
                itemRepository
                        .findAll();
    }

// get item by id
    public Item getItemById(
            int id
    ) {
        return
                itemRepository
                        .findById(id)
                        .orElseThrow(()->new RuntimeException("Employee not found"));
    }
// update item
    public void updateItem(
            int id,
            ItemRequestDTO itemRequestDTO
    ){
        Item item = itemRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found"));
        Supplier supplier = supplierRepository
                .findById(itemRequestDTO.getSupplierId())
                .orElseThrow(()->new RuntimeException("Supplier not found"));
        item
                .setName(itemRequestDTO.getName());
        item
                .setDescription(itemRequestDTO.getDescription());
        item
                .setSku(itemRequestDTO.getSku());
        item
                .setUnitPrice(itemRequestDTO.getPrice());
        item
                .setSupplier(supplier);
        itemRepository
                .save(item);
    }
// delete item
    public void deleteItem(
            int id
    ) {
        Item item = itemRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found"));
        itemRepository
                .delete(item);
    }
}
