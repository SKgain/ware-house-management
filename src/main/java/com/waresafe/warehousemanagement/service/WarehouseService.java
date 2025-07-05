package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.Warehouse;
import com.waresafe.warehousemanagement.repository.WarehouseRepository;
import com.waresafe.warehousemanagement.requestDTO.WarehouseRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;
    public void addWarehouse(
            WarehouseRequestDTO warehouseDTO
    ){
        Warehouse warehouse = new Warehouse();
        warehouse
                .setName(warehouseDTO.getName());
        warehouse
                .setLocation(warehouseDTO.getLocation());
        warehouse
                .setCapacity(warehouseDTO.getCapacity());
        warehouseRepository
                .save(warehouse);
    }
    public void updateWarehouse(
            WarehouseRequestDTO warehouseDTO,
            int id
    ){
        Warehouse warehouse = warehouseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        warehouse
                .setName(warehouseDTO.getName());
        warehouse
                .setCapacity(warehouseDTO.getCapacity());
        warehouse
                .setLocation(warehouseDTO.getLocation());
        warehouseRepository
                .save(warehouse);
    }
    public List<Warehouse> getAllWarehouse() {
        return
                warehouseRepository
                        .findAll();
    }
    public Warehouse getWarehouseById(
            int id
    ){
        Warehouse warehouse = warehouseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        return
                warehouse;
    }
    public void deleteWarehouse(
            int id
    ){
        Warehouse warehouse = warehouseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        warehouseRepository
                .delete(warehouse);
    }

}
