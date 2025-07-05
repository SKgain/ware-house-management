package com.waresafe.warehousemanagement.repository;

import com.waresafe.warehousemanagement.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}
