package com.waresafe.warehousemanagement.repository;

import com.waresafe.warehousemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
