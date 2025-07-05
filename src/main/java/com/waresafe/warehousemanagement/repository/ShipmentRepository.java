package com.waresafe.warehousemanagement.repository;

import com.waresafe.warehousemanagement.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
}
