package com.waresafe.warehousemanagement.repository;

import com.waresafe.warehousemanagement.entity.ShipmentItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentItemRepository extends JpaRepository<ShipmentItem, Integer> {
}
