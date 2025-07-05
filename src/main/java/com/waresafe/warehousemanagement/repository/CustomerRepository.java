package com.waresafe.warehousemanagement.repository;

import com.waresafe.warehousemanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
