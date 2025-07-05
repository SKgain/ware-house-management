package com.waresafe.warehousemanagement.repository;

import com.waresafe.warehousemanagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
