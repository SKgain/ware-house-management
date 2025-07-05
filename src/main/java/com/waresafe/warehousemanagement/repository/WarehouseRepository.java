package com.waresafe.warehousemanagement.repository;

import com.waresafe.warehousemanagement.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
