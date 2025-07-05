package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.Warehouse;
import com.waresafe.warehousemanagement.requestDTO.WarehouseRequestDTO;
import com.waresafe.warehousemanagement.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;
    @PostMapping("/add-warehouse")
    public ResponseEntity<String> addWarehouse(
            @RequestBody WarehouseRequestDTO warehouseDTO
    ){
        warehouseService
                .addWarehouse(warehouseDTO);
        return
                ResponseEntity
                        .ok("Warehouse added");
    }
    @PutMapping("/update-warehouse/{id}")
    public ResponseEntity<String> updateWarehouse(
            @RequestBody WarehouseRequestDTO warehouseDTO,
            @PathVariable int id
    ){
        warehouseService
                .updateWarehouse(warehouseDTO,id);
        return
                ResponseEntity
                        .ok("Warehouse has been updated successfully");
    }

    @GetMapping("/get-all-warehouse")
    public List<Warehouse> getAllWarehouse(){
        return
                warehouseService
                        .getAllWarehouse();
    }
    @GetMapping("/get-warehouse/filter/{id}")
    public Warehouse getWarehouseById(
            @PathVariable int id
    ){
        return
                warehouseService
                        .getWarehouseById(id);
    }
    @DeleteMapping("/delete-warehouse/{id}")
    public ResponseEntity<String> deleteWarehouse(
            @PathVariable int id
    ){
        warehouseService
                .deleteWarehouse(id);
        return
                ResponseEntity
                        .ok("Warehouse has been deleted successfully");
    }

}
