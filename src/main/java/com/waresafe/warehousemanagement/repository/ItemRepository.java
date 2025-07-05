package com.waresafe.warehousemanagement.repository;

import com.waresafe.warehousemanagement.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Item, Integer> {
}
