package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.Shipment;
import com.waresafe.warehousemanagement.requestDTO.ShipmentRequestDTO;
import com.waresafe.warehousemanagement.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment")
@RequiredArgsConstructor
public class ShipmentController {
    private final ShipmentService shipmentService;

    //    add shipment
    @PostMapping("/add-shipment")
    public ResponseEntity<String> addShipment(
            @RequestBody ShipmentRequestDTO shipmentDTO
    ) {
        shipmentService
                .addShipment(shipmentDTO);
        return
                ResponseEntity
                        .ok("Shipment added successfully");
    }
    //    Get shipment
    @GetMapping("/get-all-shipment")
    public List<Shipment> getAllShipment() {
        return
                shipmentService
                        .getAllShipment();
    }
    //    Get shipment by id
    @GetMapping("/get-shipment/{id}")
    public Shipment getShipmentById(
            @PathVariable int id
    ) {
        return
                shipmentService
                        .getShipmentById(id);
    }
    //    update shipment
    @PutMapping("/update-shipment/{id}")
    public ResponseEntity<String> updateShipment(
            @RequestBody ShipmentRequestDTO shipmentDTO,
            @PathVariable int id
    ){
        shipmentService
                .updateShipment(shipmentDTO,id);
        return
                ResponseEntity
                        .ok("Shipment updated successfully");
    }
    //    delete shipment
    @DeleteMapping("/delete-shipment/{id}")
    public ResponseEntity<String> deleteShipment(
            @PathVariable int id
    ){
        shipmentService
                .deleteShipment(id);
        return
                ResponseEntity
                        .ok("Shipment deleted successfully");
    }

}
