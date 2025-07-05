package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.ShipmentItem;
import com.waresafe.warehousemanagement.requestDTO.ShipmentItemRequestDTO;
import com.waresafe.warehousemanagement.service.ShipmentItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment-item")
@RequiredArgsConstructor
public class ShipmentItemController {
    private final ShipmentItemService shipmentItemService;

    @PostMapping("/add-shipment-item")
    public ResponseEntity<?> addShipmentItem(
            @RequestBody ShipmentItemRequestDTO shipmentItemDTO
    ){
        shipmentItemService
                .addShipmentItem(shipmentItemDTO);
        return
                ResponseEntity
                        .ok("Shipment Item added successfully");
    }

    @GetMapping("/get-all-shipment-item")
    public List<ShipmentItem> getAllShipmentItem(){
        return
                shipmentItemService
                        .getAllShipmentItem();

    }

    @GetMapping("/get-shipment-item/filter/{id}")
    public ShipmentItem getShipmentItem(
            @PathVariable int id
    ){
        return
                shipmentItemService
                        .getShipmentItem(id);
    }

    @PutMapping("/update-shipment-item/{id}")
    public ResponseEntity<?> updateShipmentItem(
            @PathVariable int id,
            @RequestBody ShipmentItemRequestDTO shipmentItemDTO
    ){
        shipmentItemService
                .updateShipmentItem(id,shipmentItemDTO);
        return
                ResponseEntity
                        .ok("Shipment Item updated successfully");
    }
    @DeleteMapping("/delete-shipment-item/{id}")
    public ResponseEntity<?> deleteShipmentItem(
            @PathVariable int id
    ){
        shipmentItemService
                .deleteShipmentItem(id);
        return
                ResponseEntity
                        .ok("Shipment Item deleted successfully");
    }
}
